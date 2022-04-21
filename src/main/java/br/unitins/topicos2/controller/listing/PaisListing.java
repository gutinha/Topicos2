package br.unitins.topicos2.controller.listing;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import br.unitins.topicos2.model.Pais;
import br.unitins.topicos2.repository.PaisRepository;
import br.unitins.topicos2.utils.RepositoryException;
import br.unitins.topicos2.utils.Util;

@Named
@ViewScoped
public class PaisListing extends Listing<Pais> {

	private static final long serialVersionUID = -2800428910149904765L;

	private String filtro;

	public PaisListing() {
		super("paislisting", new PaisRepository());
	}

	@Override
	public void pesquisar() {
		PaisRepository repo = new PaisRepository();
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
