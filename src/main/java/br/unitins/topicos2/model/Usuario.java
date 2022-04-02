package br.unitins.topicos2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Usuario extends DefaultEntity implements Serializable {
	private static final long serialVersionUID = 512261310652722752L;

	@Column(length = 30)
	private String nome;
	@Column(length = 30)
	private String sobrenome;
	@Column(length = 30)
	private String cpf;
	@Column(length = 150)
	private String email;
	@ManyToOne
	private Endereco endereco;
	@Column(length = 30)
	private String senha;
	@ManyToOne
	private Telefone telefone;

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
