package com.involves.selecao.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.involves.selecao.alerta.Alerta;
import com.involves.selecao.alerta.Pesquisa;
import com.involves.selecao.alerta.Resposta;
import com.involves.selecao.alerta.gerador.GeradorDeAlerta;
import com.involves.selecao.alerta.gerador.GeradorDeAlertaFactory;
import com.involves.selecao.gateway.AlertaGateway;
import com.involves.selecao.ws.pesquisa.client.PesquisaClient;

@Service
public class ProcessadorAlertas {

	@Autowired
	private AlertaGateway gateway;
	
	@Autowired
	private PesquisaClient pesquisaClient;
	
	public ProcessadorAlertas(){		
	}
	
	public ProcessadorAlertas(AlertaGateway gateway, PesquisaClient pesquisaClient){	
		this.gateway = gateway;
		this.pesquisaClient = pesquisaClient;
	}
	
	public void processa() throws IOException {		
		
		Pesquisa[] pesquisas = pesquisaClient.getPesquisas();
		
		List<Alerta> alertasGerados = geraAlertasPorPesquisas(pesquisas);	
		
		alertasGerados.forEach(alerta -> gateway.salvar(alerta));
	}
	
	private List<Alerta> geraAlertasPorPesquisas(Pesquisa[] pesquisas) {

		List<Alerta> alertas = new ArrayList<>();

		for (Pesquisa pesquisa : pesquisas) {		
			alertas.addAll(geraAlertasPorPesquisa(pesquisa));			
		}

		return alertas;
	}
	
	private List<Alerta> geraAlertasPorPesquisa(Pesquisa pesquisa) {
		
		List<Alerta> alertas = new ArrayList<>();
		
		if(pesquisa.getRespostas() != null){
			for (Resposta resposta : pesquisa.getRespostas()) {

				GeradorDeAlerta gerador = null;
				if (resposta.getPergunta().equals("Qual a situação do produto?")) {
					if (resposta.getResposta().equals("Produto ausente na gondola")) {
						gerador = GeradorDeAlertaFactory.create(GeradorDeAlertaFactory.RUPTURA);
						Alerta alerta = gerador.geraAlerta(pesquisa, null);
						alertas.add(alerta);
					}
				} else if (resposta.getPergunta().equals("Qual o preço do produto?")) {
					int precoColetado = Integer.parseInt(resposta.getResposta());
					int precoEstipulado = Integer.parseInt(pesquisa.getPreco_estipulado());
					if (precoColetado > precoEstipulado) {
						gerador = GeradorDeAlertaFactory.create(GeradorDeAlertaFactory.PRECO_ACIMA);
					} else if (precoColetado < precoEstipulado) {
						gerador = GeradorDeAlertaFactory.create(GeradorDeAlertaFactory.PRECO_ABAIXO);						
					} else {
						continue;
					}
					
					int margem = precoEstipulado - precoColetado;
					Alerta alerta = gerador.geraAlerta(pesquisa, margem);
					alertas.add(alerta);
					
				} else if(resposta.getPergunta().equals("%Share")){
					int participacaoColetada = Integer.parseInt(resposta.getResposta());
					int participacaoEstipulada = Integer.parseInt(pesquisa.getParticipacao_estipulada());
					if (participacaoColetada > participacaoEstipulada) {
						gerador = GeradorDeAlertaFactory.create(GeradorDeAlertaFactory.PARTICIPACAO_ACIMA);
					} else if (participacaoColetada < participacaoEstipulada) {
						gerador = GeradorDeAlertaFactory.create(GeradorDeAlertaFactory.PARTICIPACAO_ABAIXO);						
					} else {
						continue;
					}
					
					int margem = participacaoEstipulada - participacaoColetada;
					Alerta alerta = gerador.geraAlerta(pesquisa, margem);
					alertas.add(alerta);				
							
				}
			}
		}		
		
		return alertas;
	}
}

