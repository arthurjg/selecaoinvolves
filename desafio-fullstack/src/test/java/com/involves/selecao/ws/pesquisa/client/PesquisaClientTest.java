package com.involves.selecao.ws.pesquisa.client;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.involves.selecao.alerta.Pesquisa;

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
		} catch(Exception exc){
			exc.printStackTrace();
			fail();
		}
		
		
	}

}
