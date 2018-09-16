package com.involves.selecao.service;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.involves.selecao.alerta.Alerta;
import com.involves.selecao.alerta.Pesquisa;
import com.involves.selecao.alerta.Resposta;
import com.involves.selecao.gateway.AlertaGateway;
import com.involves.selecao.ws.pesquisa.client.PesquisaClient;


public class ProcessadorAlertasTest {
	
	private ProcessadorAlertas processadorAlertas;
	private AlertaGateway gateway;	
	private PesquisaClient pesquisaClient;

	@Before
	public void setUp() throws Exception {		
		gateway = mock(AlertaGateway.class);
		pesquisaClient = mock(PesquisaClient.class);
		processadorAlertas = new ProcessadorAlertas(gateway, pesquisaClient);
	}

	@Test
	public void testProcessa() {		
		
		Pesquisa pesquisa = new Pesquisa();
		pesquisa.setId(10);
		pesquisa.setNotificante("Paulo");
		pesquisa.setPonto_de_venda("Padaria do Alemão");
		pesquisa.setCategoria("Shampoo");
		pesquisa.setParticipacao_estipulada("30");
		pesquisa.setRotulo("Acompanhamento de evolução dos refrigerantes");
		
		Resposta res = new Resposta();
		res.setPergunta("%Share");
		res.setResposta("10");
		
		Alerta alerta = new Alerta();
		alerta.setPontoDeVenda("Padaria do Alemão");
		alerta.setMargem(20);
		alerta.setCategoria(pesquisa.getCategoria());
		alerta.setDescricao("Participação inferior ao estipulado.");			
		alerta.setFlTipo(3);
		
		pesquisa.setRespostas(Arrays.asList(res));
		
		Pesquisa[] pesquisas = new Pesquisa[1];
		pesquisas[0] = pesquisa;		
		
		when(pesquisaClient.getPesquisas()).thenReturn(pesquisas);
		
		try {
			processadorAlertas.processa();			
		} catch (IOException e) {			
			e.printStackTrace();
			fail(e.getMessage());
		}		
		
		verify(gateway).salvar(alerta);			
	}

}
