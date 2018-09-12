package com.involves.selecao.alerta.gerador;

import com.involves.selecao.alerta.Alerta;
import com.involves.selecao.alerta.Pesquisa;

public abstract class GeradorDeAlerta {     
	
	public Alerta geraAlerta(Pesquisa pesquisa){
		Alerta alerta = new Alerta();
		alerta.setPontoDeVenda(pesquisa.getPonto_de_venda());
		alerta.setProduto(pesquisa.getProduto());	
		return alerta;
	}  	 
	
	public Alerta geraAlerta(Pesquisa pesquisa, int margem){
		Alerta alerta = geraAlerta(pesquisa);
		alerta.setMargem(margem);
		return alerta;
	}  	 
	
	
     
}
     
