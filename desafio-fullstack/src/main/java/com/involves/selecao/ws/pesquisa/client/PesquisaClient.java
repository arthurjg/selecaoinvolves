package com.involves.selecao.ws.pesquisa.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.involves.selecao.alerta.Pesquisa;

@Component
public class PesquisaClient {
	
	private Client client;
	
	public static final String PESQUISA_BASE_URI = "https://selecao-involves.agilepromoter.com";	
	
	public PesquisaClient(){
		client = ClientBuilder.newClient(new ClientConfig());	
	}
	
	public Pesquisa[] getPesquisas(){
		
		String recurso = "pesquisas";
		
		String recusosContexto = PESQUISA_BASE_URI;
		Response resposta = executaRequisicaoAoRecurso(recusosContexto, recurso, MediaType.TEXT_PLAIN);	
		
		Pesquisa[] pesquisas = null;
		
		if(resposta.getStatus() == 200){
			Gson gson = new Gson();
			pesquisas =  gson.fromJson(resposta.readEntity(String.class), Pesquisa[].class);		
		}
		
		return pesquisas;
	}	

	private Response executaRequisicaoAoRecurso(String recursoContexto, String recursoCaminho, String mediaType){
		
		WebTarget webTarget = client.target(recursoContexto);		
		WebTarget resourceWebTarget = webTarget.path(recursoCaminho);		
		
		Invocation.Builder invocationBuilder =	resourceWebTarget.request(mediaType);
		
		return invocationBuilder.get();		
	}	

}
