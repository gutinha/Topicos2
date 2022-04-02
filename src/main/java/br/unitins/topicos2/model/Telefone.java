package br.unitins.topicos2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Telefone extends DefaultEntity implements Serializable{
	private static final long serialVersionUID = 6745933777860485973L;
	
	private String ddd;
	@Column(length = 100)
	private String telefone;

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
