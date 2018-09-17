package com.involves.selecao.alerta.gerador;

import com.involves.selecao.alerta.Alerta;
import com.involves.selecao.alerta.Pesquisa;
import com.involves.selecao.alerta.Resposta;

public abstract class GeradorDeAlerta {     
	
	public Alerta geraAlerta(Pesquisa pesquisa, Resposta resposta){
		Alerta alerta = new Alerta();
		alerta.setPontoDeVenda(pesquisa.getPonto_de_venda());
		alerta.setProduto(pesquisa.getProduto());			
		return alerta;
	}  	
	
	public abstract boolean matchesPerguntaResposta(Pesquisa pesquisa, Resposta resposta);
     
}
     
