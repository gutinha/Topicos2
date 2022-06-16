package br.unitins.topicos2.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Venda extends DefaultEntity implements Serializable{
	private static final long serialVersionUID = -7283938118735552577L;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_item_venda")
	private ItemVenda itemVenda;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pagamento")
	private Pagamento pagamento;
	public ItemVenda getItemVenda() {
		return itemVenda;
	}
	public void setItemVenda(ItemVenda itemVenda) {
		this.itemVenda = itemVenda;
	}
	public Pagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
