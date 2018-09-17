package com.involves.selecao.alerta.gerador;

import com.involves.selecao.alerta.Alerta;
import com.involves.selecao.alerta.Pesquisa;
import com.involves.selecao.alerta.Resposta;

public class AlertaPrecoAcimaGerador extends GeradorDeAlerta {	
	
	@Override
	public Alerta geraAlerta(Pesquisa pesquisa, Resposta resposta) {
		
		Alerta alerta = super.geraAlerta(pesquisa, resposta);			
		alerta.setDescricao(TipoAlerta.PRECO_ACIMA.getDescricao());			
		alerta.setFlTipo(TipoAlerta.PRECO_ACIMA.getTipo());
		
		int precoColetado = Integer.parseInt(resposta.getResposta());
		int precoEstipulado = Integer.parseInt(pesquisa.getPreco_estipulado());		
		int margem = precoColetado - precoEstipulado;
		alerta.setMargem(margem);
		return alerta;
	}

	@Override
	public boolean matchesPerguntaResposta(Pesquisa pesquisa, Resposta resposta) {
		if (resposta.getPergunta().equals(TipoAlerta.PRECO_ACIMA.getPergunta())) {
			int precoColetado = Integer.parseInt(resposta.getResposta());
			int precoEstipulado = Integer.parseInt(pesquisa.getPreco_estipulado());
			if (precoColetado > precoEstipulado) {
				return true;
			} 
		}
		return false;
	}	
    
}
