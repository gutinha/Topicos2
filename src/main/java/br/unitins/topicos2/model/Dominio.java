package br.unitins.topicos2.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Dominio extends DefaultEntity implements Serializable{
	private static final long serialVersionUID = 6259463099845076897L;
	private String dominio;
	private boolean ativo;
	
	public String getDominio() {
		return dominio;
	}
	public void setDominio(String dominio) {
		this.dominio = dominio;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
}
