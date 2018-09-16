package com.involves.selecao.alerta.gerador;

import com.involves.selecao.alerta.Alerta;
import com.involves.selecao.alerta.Pesquisa;

public class AlertaParticipacaoAbaixoGerador extends GeradorDeAlerta {	
	
	@Override
	public Alerta geraAlerta(Pesquisa pesquisa, Integer margem) {
		
		Alerta alerta = super.geraAlerta(pesquisa, margem);		
		alerta.setCategoria(pesquisa.getCategoria());
		alerta.setDescricao("Participação inferior ao estipulado.");			
		alerta.setFlTipo(3);
		return alerta;
	}	
    
}
