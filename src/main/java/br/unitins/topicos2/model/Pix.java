package br.unitins.topicos2.model;

import javax.persistence.Entity;

@Entity
public class Pix extends MeioPagamento{
	private static final long serialVersionUID = -4331420843584327428L;
	private String chavePix;

	public String getChavePix() {
		return chavePix;
	}

	public void setChavePix(String chavePix) {
		this.chavePix = chavePix;
	}
}
