package br.unitins.topicos2.model;

import javax.persistence.Entity;

@Entity
public class Pais extends DefaultEntity{
	private String nome;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
