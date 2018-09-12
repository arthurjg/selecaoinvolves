package com.involves.selecao.alerta.gerador;

import com.involves.selecao.alerta.Pesquisa;

public class GeradorDeAlertaFactory {
	
	public static final int RUPTURA = 0;
	public static final int PRECO_ACIMA = 1;
	public static final int PRECO_ABAIXO = 2;
	public static final int PARTICIPACAO_ACIMA = 3;
	public static final int PARTICIPACAO_ABAIXO = 4;
	
	public static GeradorDeAlerta create(int tipo){
		GeradorDeAlerta gerador = null;
		
		if(tipo == RUPTURA){			
			gerador = new AlertaRupturaBuilder();
		} else if(tipo == PRECO_ACIMA){			
			gerador = new AlertaPrecoAcimaBuilder();
		} else if(tipo == PRECO_ABAIXO){			
			gerador = new AlertaPrecoAbaixoBuilder();
		} else if(tipo == PARTICIPACAO_ABAIXO){			
			gerador = new AlertaParticipacaoAbaixoGerador();
		} else if(tipo == PARTICIPACAO_ACIMA){			
			gerador = new AlertaParticipacaoAcimaGerador();
		}
		
		return gerador;
		
	}

}
