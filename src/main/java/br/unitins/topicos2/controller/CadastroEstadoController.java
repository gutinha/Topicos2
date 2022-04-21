package br.unitins.topicos2.controller;

import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import br.unitins.topicos2.controller.listing.EstadoListing;
import br.unitins.topicos2.model.Estado;
import br.unitins.topicos2.model.Pais;
import br.unitins.topicos2.repository.EstadoRepository;
import br.unitins.topicos2.repository.PaisRepository;
import br.unitins.topicos2.utils.RepositoryException;
import br.unitins.topicos2.utils.Util;
@Named
@ViewScoped
public class CadastroEstadoController extends Controller<Estado> implements Serializable{
	private static final long serialVersionUID = 8363663169323611378L;

	public CadastroEstadoController() {
		super(new EstadoRepository());
	}
	PaisRepository pRepo = new PaisRepository();
	@Override
	public Estado getEntity() {
		if (entity == null)
            entity = new Estado();
		return entity;
	}
	public void redirecionar(String pagina) {
		Util.redirect(pagina);
	}
	
	public void abrirEstadoListing() {
		EstadoListing listing = new EstadoListing();
		listing.open();
	}

	public void obterEstadoListing(SelectEvent<Estado> event) {
		setEntity(event.getObject());
	}
	
	public List<Pais> getListPais(){
		try {
			return pRepo.findAll();
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		return null;
	}

}
