package br.unitins.topicos2.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;

@Entity
public class Dominio extends Produto implements Serializable{
	private static final long serialVersionUID = 6259463099845076897L;
	private String dominio;
	private boolean ativo;
	private LocalDateTime dataLimite;
	private String nameServer1 = "hypehost.mars-dns.com";
	private String nameServer2 = "hypehost.earth-dns.com";
	
	public String getDominio() {
		return dominio;
	}
	public void setDominio(String dominio) {
		this.dominio = dominio;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public LocalDateTime getDataLimite() {
		return dataLimite;
	}
	public void setDataLimite(LocalDateTime dataLimite) {
		this.dataLimite = dataLimite;
	}
	public String getNameServer2() {
		return nameServer2;
	}
	public void setNameServer2(String nameServer2) {
		this.nameServer2 = nameServer2;
	}
	public String getNameServer1() {
		return nameServer1;
	}
	public void setNameServer1(String nameServer1) {
		this.nameServer1 = nameServer1;
	}
	
}
