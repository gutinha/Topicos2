package br.unitins.topicos2.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Endereco extends DefaultEntity implements Serializable{
	private static final long serialVersionUID = -683480893090481237L;
	public Endereco() {}
	public Endereco(Cidade cidade) {
		this.cidade = cidade;
	}
	@Column(length = 255)
	private String endereco;
	@Column(length = 35)
	private String cep;
	@ManyToOne
	@JoinColumn(name = "id_cidade")
	private Cidade cidade;
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	

}
