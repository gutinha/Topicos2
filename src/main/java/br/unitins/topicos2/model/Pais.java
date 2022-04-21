package br.unitins.topicos2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Pais extends DefaultEntity implements Serializable{
	private static final long serialVersionUID = -3916532536189662186L;
	@Column(length = 50)
	private String pais_nome;
	@Column(length = 50)
	private String pais_name;
	public String getPais_nome() {
		return pais_nome;
	}
	public void setPais_nome(String pais_nome) {
		this.pais_nome = pais_nome;
	}
	public String getPais_name() {
		return pais_name;
	}
	public void setPais_name(String pais_name) {
		this.pais_name = pais_name;
	}
	
	
}
