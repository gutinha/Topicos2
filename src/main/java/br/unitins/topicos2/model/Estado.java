package br.unitins.topicos2.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Estado extends DefaultEntity implements Serializable{
	private static final long serialVersionUID = 8661594980174148444L;
	@Column(length = 30)
	private String nome;
	@Column(length = 5)
	private String sigla;
	@ManyToOne()
	@JoinColumn(name = "id_pais")
	private Pais pais;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	

}
