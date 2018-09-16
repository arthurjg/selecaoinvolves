package com.involves.selecao.ws.pesquisa.client;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.involves.selecao.alerta.Pesquisa;
import com.involves.selecao.alerta.Resposta;

public class PesquisaClientTest {

	PesquisaClient pesquisaClient;
	
	@Before
	public void setUp() throws Exception {
		pesquisaClient = new PesquisaClient();
	}

	@Test
	public void testGetPesquisas() {
		try {
			Pesquisa[] pesquisas = pesquisaClient.getPesquisas();
			assertNotNull(pesquisas);
			assertFalse(pesquisas.length == 0);
			
			for(Pesquisa pesquisa : pesquisas){
				System.out.println("pesquisa...******************************");
				System.out.println("id: " + pesquisa.getId());
				System.out.println("pdv: " + pesquisa.getPonto_de_venda());
				System.out.println("cat: " + pesquisa.getCategoria());
				System.out.println("not: " + pesquisa.getNotificante());
				
				System.out.println("prod: " + pesquisa.getProduto());
				System.out.println("rot: " + pesquisa.getRotulo());
				System.out.println("preco: " + pesquisa.getPreco_estipulado());
				System.out.println("part: " + pesquisa.getParticipacao_estipulada());
				
				for(Resposta resposta : pesquisa.getRespostas()){
					System.out.println("resposta...*********************");
					System.out.println("perg: " + resposta.getPergunta());
					System.out.println("resp: " + resposta.getResposta());	
					System.out.println("*********************");
				}
				
				System.out.println("************************************");
			}
		} catch(Exception exc){
			exc.printStackTrace();
			fail();
		}
		
		
	}

}
