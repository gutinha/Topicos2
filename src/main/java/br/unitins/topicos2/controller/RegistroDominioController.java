package br.unitins.topicos2.controller;

import java.io.IOException;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos2.model.Dominio;
import br.unitins.topicos2.model.ItemVenda;
import br.unitins.topicos2.model.Produto;
import br.unitins.topicos2.repository.DominioRepository;
import br.unitins.topicos2.repository.ItemVendaRepository;
import br.unitins.topicos2.repository.ProdutoRepository;
import br.unitins.topicos2.utils.RepositoryException;
import br.unitins.topicos2.utils.Session;
import br.unitins.topicos2.utils.Util;
import br.unitins.topicos2.utils.VersionException;

@Named
@ViewScoped
public class RegistroDominioController extends Controller<Dominio> implements Serializable{
	private static final long serialVersionUID = 217688816469588812L;
	private String dominio;
	private boolean valido = true;
	private ItemVenda itemVenda = new ItemVenda();
	public RegistroDominioController() {
		super(new DominioRepository());
	}
	
	public boolean isReachable() throws IOException{
		setDominio(getDominio().replaceFirst("^https", "http"));
	    HttpURLConnection httpUrlConnection = (HttpURLConnection) new URL("https://"+getDominio()).openConnection();
	    httpUrlConnection.setRequestMethod("HEAD");

	    try{
	        int responseCode = httpUrlConnection.getResponseCode();
	        Util.addErrorMessage("Erro!", "Domínio indisponível");
	        valido = true;
	        return responseCode == HttpURLConnection.HTTP_OK;
	    } catch (UnknownHostException noInternetConnection){
	    	Util.addInfoMessage("Sucesso!", "Domínio disponível");
	    	getEntity().setDominio(getDominio());
	    	getEntity().setPreco(40.0);
	    	getEntity().setDataLimite(LocalDateTime.now().plusYears(1));
	    	getEntity().setAtivo(true);
	    	getItemVenda().setPreco(getEntity().getPreco());
	    	getItemVenda().setProduto(getEntity());
	    	valido = false;
	        return false;
	    } catch (Exception e) {
			Util.addErrorMessage("Erro!", "Ocorreu um erro ao verifica o dominio");
			return true;
		}
	}
	
	public void comprar() {
		if(Session.getInstance().get("carrinho") != null) {
    		Util.redirect("/carrinho");
    	}
		Session.getInstance().set("carrinho", getItemVenda());
    	Util.redirect("/carrinho");
	}

	@Override
	public Dominio getEntity() {
		if(entity == null) {
			entity = new Dominio();
		}
		return entity;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public boolean getValido() {
		return valido;
	}

	public void setValido(boolean valido) {
		this.valido = valido;
	}

	public ItemVenda getItemVenda() {
		return itemVenda;
	}

	public void setItemVenda(ItemVenda itemVenda) {
		this.itemVenda = itemVenda;
	}

}
