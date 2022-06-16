package br.unitins.topicos2.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos2.model.Dominio;
import br.unitins.topicos2.model.ItemVenda;
import br.unitins.topicos2.model.Produto;
import br.unitins.topicos2.model.ServidorVM;
import br.unitins.topicos2.model.Venda;
import br.unitins.topicos2.repository.VendaRepository;
import br.unitins.topicos2.utils.Session;
import br.unitins.topicos2.utils.Util;

@Named
@ViewScoped
public class CarrinhoController extends Controller<Venda> implements Serializable{
	private static final long serialVersionUID = -1026551679629870828L;

	public CarrinhoController() {
		super(new VendaRepository());
	}

	@Override
	public Venda getEntity() {
		if(entity == null) {
			entity = new Venda();
			entity.setItemVenda((ItemVenda)Session.getInstance().get("carrinho"));
		}
		return entity;
	}
	
	public void finalizar() {
		Session.getInstance().set("carrinho2", getEntity());
		Util.redirect("/finalizarCompra");
	}
	
	//retorna a instancia de dominio ou maquina virtual - usado pra renderizar os campos
		public boolean getInstanceOfProduto() {
			if (getEntity().getItemVenda().getProduto() instanceof Dominio) {
				return true;
			} else if (getEntity().getItemVenda().getProduto() instanceof ServidorVM) {
				return false;
			} else {
				return true;
			}
			
		}

}
