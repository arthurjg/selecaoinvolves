package com.involves.selecao.alerta.gerador;

import com.involves.selecao.alerta.Alerta;
import com.involves.selecao.alerta.Pesquisa;

public class AlertaRupturaBuilder extends GeradorDeAlerta {	
	
	@Override
	public Alerta geraAlerta(Pesquisa pesquisa, Integer margem) {
		
		Alerta alerta = super.geraAlerta(pesquisa, margem);		
		alerta.setDescricao("Ruptura detectada!");		
		alerta.setFlTipo(1);
		return alerta;
	}
    
}
