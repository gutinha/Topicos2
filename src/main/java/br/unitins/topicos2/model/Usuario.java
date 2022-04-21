package br.unitins.topicos2.model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Usuario extends DefaultEntity implements Serializable {
	private static final long serialVersionUID = 512261310652722752L;

	@Column(length = 150)
	private String email;
	@OneToOne
	private Endereco endereco;
	@Column(length = 30)
	private String senha;
	@Column(length = 30)
	private String telefone;

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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
