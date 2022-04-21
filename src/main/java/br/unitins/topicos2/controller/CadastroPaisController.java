package br.unitins.topicos2.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.topicos2.controller.listing.PaisListing;
import br.unitins.topicos2.model.Pais;
import br.unitins.topicos2.repository.PaisRepository;
import br.unitins.topicos2.utils.Util;
@Named
@ViewScoped
public class CadastroPaisController extends Controller<Pais> implements Serializable{
	private static final long serialVersionUID = 8363663169323611378L;

	public CadastroPaisController() {
		super(new PaisRepository());
	}

	@Override
	public Pais getEntity() {
		if (entity == null)
            entity = new Pais();
		return entity;
	}
	public void redirecionar(String pagina) {
		Util.redirect(pagina);
	}
	
	public void abrirPaisListing() {
		PaisListing listing = new PaisListing();
		listing.open();
	}

	public void obterPaisListing(SelectEvent<Pais> event) {
		setEntity(event.getObject());
	}

}
