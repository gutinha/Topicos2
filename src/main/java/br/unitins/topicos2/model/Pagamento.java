package br.unitins.topicos2.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Pagamento extends DefaultEntity{
	@OneToOne
	private MeioPagamento meioPagamento;
	private LocalDate dataPagamento;
	public MeioPagamento getMeioPagamento() {
		return meioPagamento;
	}
	public void setMeioPagamento(MeioPagamento meioPagamento) {
		this.meioPagamento = meioPagamento;
	}
	public LocalDate getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
}
