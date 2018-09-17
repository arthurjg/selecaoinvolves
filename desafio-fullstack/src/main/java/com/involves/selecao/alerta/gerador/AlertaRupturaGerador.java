package com.involves.selecao.alerta.gerador;

import com.involves.selecao.alerta.Alerta;
import com.involves.selecao.alerta.Pesquisa;
import com.involves.selecao.alerta.Resposta;

public class AlertaRupturaGerador extends GeradorDeAlerta {	
	
	@Override
	public Alerta geraAlerta(Pesquisa pesquisa, Resposta resposta) {
		
		Alerta alerta = super.geraAlerta(pesquisa, resposta);		
		alerta.setDescricao(TipoAlerta.RUPTURA.getDescricao());		
		alerta.setFlTipo(TipoAlerta.RUPTURA.getTipo());
		return alerta;
	}

	@Override
	public boolean matchesPerguntaResposta(Pesquisa pesquisa, Resposta resposta) {
		if (resposta.getPergunta().equals(TipoAlerta.RUPTURA.getPergunta())
			&& (resposta.getResposta().equals("Produto ausente na gondola"))){
			return true;
		} else {
			return false;
		}
		
	}
    
}
