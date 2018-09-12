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
	
	public void processa() throws IOException {		
		
		Pesquisa[] ps = pesquisaClient.getPesquisas();
		
		
		/*for (int i = 0; i < ps.length; i++){
			for (int j = 0; j < ps[i].getRespostas().size(); j++){
				Resposta resposta = ps[i].getRespostas().get(j);
				if (resposta.getPergunta().equals("Qual a situação do produto?")) {
					if(resposta.getResposta().equals("Produto ausente na gondola")){
					    Alerta alerta = new Alerta();
					    alerta.setPontoDeVenda(ps[i].getPonto_de_venda());
					    alerta.setDescricao("Ruptura detectada!");
					    alerta.setProduto(ps[i].getProduto());
					    alerta.setFlTipo(1);
					    gateway.salvar(alerta);
					}
				} else if(resposta.getPergunta().equals("Qual o preço do produto?")) {
					int precoColetado = Integer.parseInt(resposta.getResposta());
					int precoEstipulado = Integer.parseInt(ps[i].getPreco_estipulado());
					if(precoColetado > precoEstipulado){
					    Alerta alerta = new Alerta();
					    int margem = precoEstipulado - Integer.parseInt(resposta.getResposta());
					    alerta.setMargem(margem);
					    alerta.setDescricao("Preço acima do estipulado!");
					    alerta.setProduto(ps[i].getProduto());
					    alerta.setPontoDeVenda(ps[i].getPonto_de_venda());
					    alerta.setFlTipo(2);
					    gateway.salvar(alerta);
					} else if(precoColetado < precoEstipulado){
						Alerta alerta = new Alerta();
					    int margem = precoEstipulado - Integer.parseInt(resposta.getResposta());
					    alerta.setMargem(margem);
					    alerta.setDescricao("Preço abaixo do estipulado!");
					    alerta.setProduto(ps[i].getProduto());
					    alerta.setPontoDeVenda(ps[i].getPonto_de_venda());
					    alerta.setFlTipo(3);
					    gateway.salvar(alerta);
					}
				} else {
					System.out.println("Alerta ainda não implementado!");
				}
			} 
		}*/
	}
	
	public List<Alerta> geraAlertasPorPesquisas(List<Pesquisa> pesquisas) {

		List<Alerta> alertas = new ArrayList<>();

		for (Pesquisa pesquisa : pesquisas) {
			for (Resposta resposta : pesquisa.getRespostas()) {

				GeradorDeAlerta gerador = null;
				if (resposta.getPergunta().equals("Qual a situação do produto?")) {
					if (resposta.getResposta().equals("Produto ausente na gondola")) {
						gerador = GeradorDeAlertaFactory.create(GeradorDeAlertaFactory.RUPTURA);
						Alerta alerta = gerador.geraAlerta(pesquisa);
						alertas.add(alerta);
					}
				} else if (resposta.getPergunta().equals("Qual o preço do produto?")) {
					int precoColetado = Integer.parseInt(resposta.getResposta());
					int precoEstipulado = Integer.parseInt(pesquisa.getPreco_estipulado());
					if (precoColetado > precoEstipulado) {
						gerador = GeradorDeAlertaFactory.create(GeradorDeAlertaFactory.PRECO_ACIMA);
						int margem = precoColetado - precoEstipulado;
						Alerta alerta = gerador.geraAlerta(pesquisa, margem);

						alertas.add(alerta);

					} else if (precoColetado < precoEstipulado) {
						gerador = GeradorDeAlertaFactory.create(GeradorDeAlertaFactory.PRECO_ACIMA);
						int margem = precoColetado - precoEstipulado;
						Alerta alerta = gerador.geraAlerta(pesquisa, margem);

						alertas.add(alerta);
					}
				} else if(resposta.getPergunta().equals("%Share")){
					int participacaoColetada = Integer.parseInt(resposta.getResposta());
					int participacaoEstipulada = Integer.parseInt(pesquisa.getParticipação_estipulada());
					if (participacaoColetada > participacaoEstipulada) {
						gerador = GeradorDeAlertaFactory.create(GeradorDeAlertaFactory.PARTICIPACAO_ACIMA);
						int margem = participacaoColetada - participacaoEstipulada;
						Alerta alerta = gerador.geraAlerta(pesquisa, margem);

						alertas.add(alerta);

					} else if (participacaoColetada < participacaoEstipulada) {
						gerador = GeradorDeAlertaFactory.create(GeradorDeAlertaFactory.PARTICIPACAO_ABAIXO);
						int margem = participacaoColetada - participacaoEstipulada;
						Alerta alerta = gerador.geraAlerta(pesquisa, margem);

						alertas.add(alerta);
					}
				}
			}
		}

		return alertas;
	}
}

