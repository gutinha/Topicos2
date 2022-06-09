package br.unitins.topicos2.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.topicos2.controller.listing.CidadeListingSQL;
import br.unitins.topicos2.controller.listing.EstadoListing;
import br.unitins.topicos2.model.Cidade;
import br.unitins.topicos2.model.Estado;
import br.unitins.topicos2.repository.CidadeRepository;
import br.unitins.topicos2.repository.EstadoRepository;
import br.unitins.topicos2.utils.RepositoryException;

@Named
@ViewScoped
public class CadastroCidadeController extends Controller<Cidade> implements Serializable{
	private static final long serialVersionUID = 8217878350772866819L;

	public CadastroCidadeController() {
		super(new CidadeRepository());
	}

	@Override
	public Cidade getEntity() {
		if(entity == null)
			entity = new Cidade();
		return entity;
	}
	
	public void abrirCidadeListing() {
		CidadeListingSQL listing = new CidadeListingSQL();
		listing.open();
	}

	public void obterCidadeListing(SelectEvent<Cidade> event) {
		setEntity(event.getObject());
	}
	public void abrirEstadoListing() {
		EstadoListing listing = new EstadoListing();
		listing.open();
	}
	
	public void obterEstadoListing(SelectEvent<Estado> event) {
		getEntity().setEstado(event.getObject());
	}
	
	public List<Estado> completeEstado(String filtro) {
		EstadoRepository repo = new EstadoRepository();
		try {
			return repo.findByNome(filtro, 4);
		} catch (RepositoryException e) {
			e.printStackTrace();
			return new ArrayList<Estado>();
		}
	}
}
