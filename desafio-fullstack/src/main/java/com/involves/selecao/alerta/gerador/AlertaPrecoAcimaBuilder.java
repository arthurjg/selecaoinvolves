package com.involves.selecao.alerta.gerador;

import com.involves.selecao.alerta.Alerta;
import com.involves.selecao.alerta.Pesquisa;

public class AlertaPrecoAcimaBuilder extends GeradorDeAlerta {	
	
	@Override
	public Alerta geraAlerta(Pesquisa pesquisa) {
		
		Alerta alerta = super.geraAlerta(pesquisa);		
		alerta.setDescricao("Preço acima do estipulado!");			
		alerta.setFlTipo(2);
		return alerta;
	}	
	
	@Override
	public Alerta geraAlerta(Pesquisa pesquisa, int margem){
		Alerta alerta = super.geraAlerta(pesquisa, margem);
		alerta.setDescricao("Preço acima do estipulado!");			
		alerta.setFlTipo(2);
		return alerta;
	} 

    
}
