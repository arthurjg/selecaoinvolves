package com.involves.selecao.alerta.gerador;

import com.involves.selecao.alerta.Alerta;
import com.involves.selecao.alerta.Pesquisa;

public class AlertaPrecoAbaixoBuilder extends GeradorDeAlerta {
	
	@Override
	public Alerta geraAlerta(Pesquisa pesquisa) {
		
		Alerta alerta = super.geraAlerta(pesquisa);
		alerta.setDescricao("Preço abaixo do estipulado!");			
		alerta.setFlTipo(3);
		return alerta;
	}	
	
	@Override
	public Alerta geraAlerta(Pesquisa pesquisa, int margem){
		Alerta alerta = super.geraAlerta(pesquisa, margem);
		alerta.setDescricao("Preço abaixo do estipulado!");			
		alerta.setFlTipo(3);
		return alerta;
	} 

    
}
