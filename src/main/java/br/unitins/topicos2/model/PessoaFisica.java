package br.unitins.topicos2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

@Entity
public class PessoaFisica extends Usuario implements Serializable{
	private static final long serialVersionUID = 1359788998879707211L;
	@Column(length = 30)
	private String sobrenome;
	@CPF(message = "Informe um CPF válido")
	@NotBlank(message = "Não pode ser vazio")
	@Column(length = 30)
	private String cpf;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
}
