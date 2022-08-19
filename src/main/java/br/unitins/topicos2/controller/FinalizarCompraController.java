package br.unitins.topicos2.controller;

import java.io.Serializable;
import java.time.LocalDate;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos2.model.Cartao;
import br.unitins.topicos2.model.Dominio;
import br.unitins.topicos2.model.Pagamento;
import br.unitins.topicos2.model.Pix;
import br.unitins.topicos2.model.ServidorVM;
import br.unitins.topicos2.model.Usuario;
import br.unitins.topicos2.model.Venda;
import br.unitins.topicos2.repository.CartaoRepository;
import br.unitins.topicos2.repository.PagamentoRepository;
import br.unitins.topicos2.repository.PixRepository;
import br.unitins.topicos2.repository.VendaRepository;
import br.unitins.topicos2.utils.RepositoryException;
import br.unitins.topicos2.utils.Session;
import br.unitins.topicos2.utils.Util;
import br.unitins.topicos2.utils.VersionException;

@Named
@ViewScoped
public class FinalizarCompraController extends Controller<Venda> implements Serializable {
	private static final long serialVersionUID = 735262482692923732L;
	private String tipoPagamento;
	private Cartao cartao = new Cartao();

	public FinalizarCompraController() {
		super(new VendaRepository());
	}

	@Override
	public Venda getEntity() {
		if (entity == null) {
			entity = (Venda) Session.getInstance().get("carrinho2");
		}
		return entity;
	}

	public void comprar() {
		Usuario usu = (Usuario) Session.getInstance().get("usuarioLogado");
		if (usu == null) {
			Util.addErrorMessage("Erro!", "Você precisa estar logado");
			return;
		}
		if (getEntity() == null) {
			Util.addErrorMessage("Erro!", "Carrinho vazio");
			return;
		}
		if (tipoPagamento.equals("pix")) {
			PixRepository pRepo = new PixRepository();
			Pix pix = new Pix();
			pix.setTipoPagamento("pix");
			pix.setChavePix("03829558112");
			try {
				pix = pRepo.save(pix);
			} catch (RepositoryException | VersionException e1) {
				e1.printStackTrace();
			}
			PagamentoRepository paRepo = new PagamentoRepository();
			Pagamento paga = new Pagamento();
			paga.setDataPagamento(LocalDate.now());
			paga.setMeioPagamento(pix);
			try {
				paga = paRepo.save(paga);
			} catch (RepositoryException | VersionException e) {
				e.printStackTrace();
			}
			getEntity().setPagamento(paga);
		} else if (tipoPagamento.equals("cartao")) {
			CartaoRepository cRepo = new CartaoRepository();
			try {
				getCartao().setTipoPagamento("cartao");
				Cartao a = cRepo.save(getCartao());
				try {
					PagamentoRepository paRepo = new PagamentoRepository();
					Pagamento paga = new Pagamento();
					paga.setDataPagamento(LocalDate.now());
					paga.setMeioPagamento(a);
					paga = paRepo.save(paga);
					getEntity().setPagamento(paga);
				} catch (RepositoryException | VersionException e) {
					e.printStackTrace();
				}
			} catch (RepositoryException | VersionException e) {
				e.printStackTrace();
			}
		}
		getEntity().setUsuario((Usuario) Session.getInstance().get("usuarioLogado"));
		incluir();
		Util.redirect("/index");
	}

	public void excluirCarrinho() {
		Session.getInstance().set("carrinho2", null);
		Session.getInstance().set("carrinho", null);
		getEntity().setItemVenda(null);
	}
	
	public void chama() {
		if(getEntity().getItemVenda() == null) {
			Util.redirect("/index");
		}
	}

	public String formatPrice() {
		return Util.formatPrice(getEntity().getItemVenda().getPreco());
	}

	// retorna a instancia de dominio ou maquina virtual - usado pra renderizar os
	// campos
	public boolean getInstanceOfProduto() {
		if (getEntity().getItemVenda().getProduto() instanceof Dominio) {
			return true;
		} else return !(getEntity().getItemVenda().getProduto() instanceof ServidorVM);
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

}
