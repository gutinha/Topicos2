package br.unitins.topicos2.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import br.unitins.topicos2.model.MeioPagamento;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class MeioPagamento extends DefaultEntity implements Serializable{
	private static final long serialVersionUID = 6195833148934600576L;
	private String tipoPagamento;

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}


}
