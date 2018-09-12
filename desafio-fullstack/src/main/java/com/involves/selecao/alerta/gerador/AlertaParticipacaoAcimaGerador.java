package com.involves.selecao.alerta.gerador;

import com.involves.selecao.alerta.Alerta;
import com.involves.selecao.alerta.Pesquisa;

public class AlertaParticipacaoAcimaGerador extends GeradorDeAlerta {	
	
	@Override
	public Alerta geraAlerta(Pesquisa pesquisa) {
		
		Alerta alerta = super.geraAlerta(pesquisa);		
		alerta.setDescricao("Participação superior ao estipulado.");				
		alerta.setFlTipo(4);
		return alerta;
	}	
	
	@Override
	public Alerta geraAlerta(Pesquisa pesquisa, int margem){
		Alerta alerta = super.geraAlerta(pesquisa, margem);
		alerta.setDescricao("Participação superior ao estipulado.");	
		alerta.setFlTipo(4);
		return alerta;
	} 

    
}
