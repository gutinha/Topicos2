package br.unitins.topicos2.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos2.model.Dominio;
import br.unitins.topicos2.model.ServidorVM;
import br.unitins.topicos2.model.Usuario;
import br.unitins.topicos2.model.Venda;
import br.unitins.topicos2.repository.VendaRepository;
import br.unitins.topicos2.utils.Session;
import br.unitins.topicos2.utils.Util;

@Named
@ViewScoped
public class FinalizarCompraController extends Controller<Venda> implements Serializable{
	private static final long serialVersionUID = 735262482692923732L;
	public FinalizarCompraController() {
		super(new VendaRepository());
		// TODO Auto-generated constructor stub
	}

	@Override
	public Venda getEntity() {
		if(entity == null) {
			entity = (Venda) Session.getInstance().get("carrinho2");
		}
		return entity;
	}
	
	public void comprar() {
		Usuario usu = (Usuario) Session.getInstance().get("usuarioLogado");
		if(usu == null) {
			Util.addErrorMessage("Erro!", "Você precisa estar logado");
			return;
		}
		if(getEntity() == null) {
			Util.addErrorMessage("Erro!", "Carrinho vazio");
			return;
		}
		getEntity().setUsuario((Usuario)Session.getInstance().get("usuarioLogado"));
		incluir();
		Util.redirect("/index");
	}
	
	public String formatPrice() {
		return Util.formatPrice(getEntity().getItemVenda().getPreco());
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
