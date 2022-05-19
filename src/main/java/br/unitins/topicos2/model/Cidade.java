package br.unitins.topicos2.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cidade extends DefaultEntity implements Serializable{
	private static final long serialVersionUID = -402761132885451207L;
	public Cidade() {}
	public Cidade(Estado estado) {
		this.estado = estado;
	}
	@Column(length = 55)
	private String nome;
	@ManyToOne()
	@JoinColumn(name = "id_estado")
	private Estado estado;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return getNome();
	}

	
}
