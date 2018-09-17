package com.involves.selecao.alerta.gerador;

import com.involves.selecao.alerta.Alerta;
import com.involves.selecao.alerta.Pesquisa;
import com.involves.selecao.alerta.Resposta;

public class AlertaParticipacaoAbaixoGerador extends GeradorDeAlerta {	
	
	@Override
	public Alerta geraAlerta(Pesquisa pesquisa, Resposta resposta) {
		
		Alerta alerta = super.geraAlerta(pesquisa, resposta);		
		alerta.setCategoria(pesquisa.getCategoria());
		alerta.setDescricao(TipoAlerta.PARTICIPACAO_ABAIXO.getDescricao());			
		alerta.setFlTipo(TipoAlerta.PARTICIPACAO_ABAIXO.getTipo());
		
		int participacaoColetada = Integer.parseInt(resposta.getResposta());
		int participacaoEstipulada = Integer.parseInt(pesquisa.getParticipacao_estipulada());		
		int margem = participacaoEstipulada - participacaoColetada;
		alerta.setMargem(margem);
		return alerta;
	}	
	
	@Override
	public boolean matchesPerguntaResposta(Pesquisa pesquisa, Resposta resposta) {
		if(resposta.getPergunta().equals(TipoAlerta.PARTICIPACAO_ABAIXO.getPergunta())){
			int participacaoColetada = Integer.parseInt(resposta.getResposta());
			int participacaoEstipulada = Integer.parseInt(pesquisa.getParticipacao_estipulada());
			if (participacaoColetada < participacaoEstipulada) {
				return true;
			} 
		}
		return false;
	}	
    
}
