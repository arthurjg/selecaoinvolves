package com.involves.selecao.alerta;
import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Pesquisa implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3679426224575474209L;	
	
	private int id;
	private String rotulo;
	private String notificante;
	private String ponto_de_venda;
	private String produto;
	private String categoria;
	private String preco_estipulado;
	private String participacao_estipulada;	
	
	private List<Resposta> respostas;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRotulo() {
		return rotulo;
	}
	public void setRotulo(String rotulo) {
		this.rotulo = rotulo;
	}
	public String getNotificante() {
		return notificante;
	}
	public void setNotificante(String notificante) {
		this.notificante = notificante;
	}
	public String getPonto_de_venda() {
		return ponto_de_venda;
	}
	public void setPonto_de_venda(String ponto_de_venda) {
		this.ponto_de_venda = ponto_de_venda;
	}
	public List<Resposta> getRespostas() {
		return respostas;
	}
	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getPreco_estipulado() {
		return preco_estipulado;
	}
	public void setPreco_estipulado(String preco_estipulado) {
		this.preco_estipulado = preco_estipulado;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getParticipacao_estipulada() {
		return participacao_estipulada;
	}
	public void setParticipacao_estipulada(String participacao_estipulada) {
		this.participacao_estipulada = participacao_estipulada;
	}
	
	
}
