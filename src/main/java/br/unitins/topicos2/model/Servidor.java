package br.unitins.topicos2.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Servidor extends DefaultEntity implements Serializable{
	private static final long serialVersionUID = 9085700088617392895L;
	private String nomeServidor;
	private String totalRam;
	private String processador;
	private String armazenamento;
	private Integer quantVirtualizacoes;
	private String ipDedicado;
	
	public String getNomeServidor() {
		return nomeServidor;
	}
	public void setNomeServidor(String nomeServidor) {
		this.nomeServidor = nomeServidor;
	}
	public String getTotalRam() {
		return totalRam;
	}
	public void setTotalRam(String totalRam) {
		this.totalRam = totalRam;
	}
	public String getProcessador() {
		return processador;
	}
	public void setProcessador(String processador) {
		this.processador = processador;
	}
	public String getArmazenamento() {
		return armazenamento;
	}
	public void setArmazenamento(String armazenamento) {
		this.armazenamento = armazenamento;
	}
	public Integer getQuantVirtualizacoes() {
		return quantVirtualizacoes;
	}
	public void setQuantVirtualizacoes(Integer quantVirtualizacoes) {
		this.quantVirtualizacoes = quantVirtualizacoes;
	}
	public String getIpDedicado() {
		return ipDedicado;
	}
	public void setIpDedicado(String ipDedicado) {
		this.ipDedicado = ipDedicado;
	}
	
}
