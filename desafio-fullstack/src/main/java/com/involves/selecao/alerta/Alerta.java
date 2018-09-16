package com.involves.selecao.alerta;

public class Alerta {
	
	private String pontoDeVenda;
	private String descricao;
	private String produto;
	private String categoria;
	private Integer flTipo;
	private Integer margem;
	
	public String getPontoDeVenda() {
		return pontoDeVenda;
	}
	public void setPontoDeVenda(String pontoDeVenda) {
		this.pontoDeVenda = pontoDeVenda;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public Integer getFlTipo() {
		return flTipo;
	}
	public void setFlTipo(Integer flTipo) {
		this.flTipo = flTipo;
	}
	public Integer getMargem(){
		return margem;
	}
	public void setMargem(Integer margem){
		this.margem = margem;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((flTipo == null) ? 0 : flTipo.hashCode());
		result = prime * result + ((margem == null) ? 0 : margem.hashCode());
		result = prime * result + ((pontoDeVenda == null) ? 0 : pontoDeVenda.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alerta other = (Alerta) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (flTipo == null) {
			if (other.flTipo != null)
				return false;
		} else if (!flTipo.equals(other.flTipo))
			return false;
		if (margem == null) {
			if (other.margem != null)
				return false;
		} else if (!margem.equals(other.margem))
			return false;
		if (pontoDeVenda == null) {
			if (other.pontoDeVenda != null)
				return false;
		} else if (!pontoDeVenda.equals(other.pontoDeVenda))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}
	
	
}
