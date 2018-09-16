package com.involves.selecao.alerta.gerador;

import com.involves.selecao.alerta.Alerta;
import com.involves.selecao.alerta.Pesquisa;

public class AlertaPrecoAcimaBuilder extends GeradorDeAlerta {	
	
	@Override
	public Alerta geraAlerta(Pesquisa pesquisa, Integer margem) {
		
		Alerta alerta = super.geraAlerta(pesquisa, margem);			
		alerta.setDescricao("Preço acima do estipulado!");			
		alerta.setFlTipo(2);
		return alerta;
	}	
    
}
