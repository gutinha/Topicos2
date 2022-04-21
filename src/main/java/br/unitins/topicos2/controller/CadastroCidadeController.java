package br.unitins.topicos2.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.topicos2.controller.listing.CidadeListing;
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
		CidadeListing listing = new CidadeListing();
		listing.open();
	}

	public void obterCidadeListing(SelectEvent<Cidade> event) {
		setEntity(event.getObject());
	}
	EstadoRepository eRepo = new EstadoRepository();
	public List<Estado> getListEstado(){
		try {
			return eRepo.findAll();
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		return null;
	}

}
