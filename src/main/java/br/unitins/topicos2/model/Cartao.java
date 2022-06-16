package br.unitins.topicos2.model;

import javax.persistence.Entity;

@Entity
public class Cartao extends MeioPagamento{
	private static final long serialVersionUID = -699919787234085058L;
	private String cartao;
	private String cvv;
	private String dataVencimento;
	private String nomeTitular;
	
	public String getCartao() {
		return cartao;
	}
	public void setCartao(String cartao) {
		this.cartao = cartao;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public String getNomeTitular() {
		return nomeTitular;
	}
	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}
	
}
