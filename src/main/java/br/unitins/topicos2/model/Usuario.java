package br.unitins.topicos2.model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario extends DefaultEntity implements Serializable {
	private static final long serialVersionUID = 512261310652722752L;
	@Email(message = "Informe um email válido")
	@NotBlank(message = "Não pode ser vazio")
	@Column(length = 150)
	private String email;
	@NotBlank(message = "Não pode ser vazio")
	@Column(length = 100)
	private String nome;
	@OneToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;
	@Column(length = 200)
	private String senha;
	@Column(length = 30)
	private String telefone;
	private Perfil perfil;

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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}
