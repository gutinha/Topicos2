package br.unitins.topicos2.controller.listing;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos2.model.Estado;
import br.unitins.topicos2.repository.EstadoRepository;
import br.unitins.topicos2.utils.RepositoryException;
import br.unitins.topicos2.utils.Util;

@Named
@ViewScoped
public class EstadoListing extends Listing<Estado>{
	private static final long serialVersionUID = 3644534827217655467L;
	private String filtro;
	public EstadoListing() {
		super("estadolisting", new EstadoRepository());
	}

	@Override
	public void pesquisar() {
		EstadoRepository repo = new EstadoRepository();
		try {
			setList(repo.findByNome(filtro));
		} catch (RepositoryException e) {
			e.printStackTrace();
			Util.addErrorMessage("Erro","Problema ao realizar a consulta.");
		}
	}
	
	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}


}
