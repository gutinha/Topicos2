package br.unitins.topicos2.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ServidorVM extends Produto implements Serializable{
	private static final long serialVersionUID = -1502934287641581680L;
	
	private String processador;
	private String memoriaRam;
	private String qtdArmazenamento;
	private String tipoArmazenamento;
	private String login;
	private String senha;
	private String ipServidor;
	@ManyToOne
	@JoinColumn(name = "id_servidor")
	private Servidor servidor;
	public String getProcessador() {
		return processador;
	}
	public void setProcessador(String processador) {
		this.processador = processador;
	}
	public String getMemoriaRam() {
		return memoriaRam;
	}
	public void setMemoriaRam(String memoriaRam) {
		this.memoriaRam = memoriaRam;
	}
	public String getQtdArmazenamento() {
		return qtdArmazenamento;
	}
	public void setQtdArmazenamento(String qtdArmazenamento) {
		this.qtdArmazenamento = qtdArmazenamento;
	}
	public String getTipoArmazenamento() {
		return tipoArmazenamento;
	}
	public void setTipoArmazenamento(String tipoArmazenamento) {
		this.tipoArmazenamento = tipoArmazenamento;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getIpServidor() {
		return ipServidor;
	}
	public void setIpServidor(String ipServidor) {
		this.ipServidor = ipServidor;
	}
	public Servidor getServidor() {
		return servidor;
	}
	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}
	
}
