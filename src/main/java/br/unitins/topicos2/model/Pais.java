package br.unitins.topicos2.model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Pais extends DefaultEntity implements Serializable{
	private static final long serialVersionUID = -3916532536189662186L;
	@Column(length = 60)
	private String nome;
	@Column(length = 60)
	private String nome_pt;
	@Column(length = 2)
	private String sigla;
	private Integer bacen;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome_pt() {
		return nome_pt;
	}
	public void setNome_pt(String nome_pt) {
		this.nome_pt = nome_pt;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public Integer getBacen() {
		return bacen;
	}
	public void setBacen(Integer bacen) {
		this.bacen = bacen;
	}
	@Override
	public String toString() {
		return nome_pt;
	}
	
	
	
	
}
