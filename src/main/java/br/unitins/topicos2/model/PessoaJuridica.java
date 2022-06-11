package br.unitins.topicos2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CNPJ;

@Entity
public class PessoaJuridica extends Usuario implements Serializable {
	private static final long serialVersionUID = 2552627594148288238L;
	@Column(length = 30)
	private String razaoSocial;
	@CNPJ(message = "Informe um CNPJ válido")
	@NotBlank(message = "Não pode ser vazio")
	@Column(length = 30)
	private String cnpj;
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	

}
