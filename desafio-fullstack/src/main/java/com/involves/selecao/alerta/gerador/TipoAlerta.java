package com.involves.selecao.alerta.gerador;

public enum TipoAlerta {
	
	RUPTURA(1, "Ruptura detectada!", "Qual a situação do produto?", new AlertaRupturaGerador()),
	PRECO_ACIMA(2, "Preço acima do estipulado!", "Qual o preço do produto?", new AlertaPrecoAcimaGerador() ),
	PRECO_ABAIXO(3, "Preço abaixo do estipulado!", "Qual o preço do produto?", new AlertaPrecoAbaixoGerador()),
	PARTICIPACAO_ACIMA(4, "Participação superior ao estipulado.", "%Share", new AlertaParticipacaoAcimaGerador()),
	PARTICIPACAO_ABAIXO(5, "Participação inferior ao estipulado.", "%Share", new AlertaParticipacaoAbaixoGerador());	
	
	private int tipo;
	private String descricao;
	private String pergunta;
	private GeradorDeAlerta gerador;
	
	private TipoAlerta(int tipo, String descricao, String pergunta, GeradorDeAlerta gerador){
		this.tipo = tipo;
		this.descricao = descricao;
		this.pergunta = pergunta;
		this.gerador = gerador;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public GeradorDeAlerta getGerador() {
		return gerador;
	}	

}
