package com.involves.selecao.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.involves.selecao.alerta.Alerta;
import com.involves.selecao.alerta.Pesquisa;
import com.involves.selecao.alerta.Resposta;
import com.involves.selecao.alerta.gerador.TipoAlerta;
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
				
				for(TipoAlerta tipoAlerta : TipoAlerta.values()){
					if(tipoAlerta.getGerador().matchesPerguntaResposta(pesquisa, resposta)){
						Alerta alerta = tipoAlerta.getGerador().geraAlerta(pesquisa, resposta);
						alertas.add(alerta);
					}
				}					
			}
		}		
		
		return alertas;
	}
}

