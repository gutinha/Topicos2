package br.unitins.topicos2.controller.listing;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import br.unitins.topicos2.model.Usuario;
import br.unitins.topicos2.repository.UsuarioRepository;
import br.unitins.topicos2.utils.RepositoryException;
import br.unitins.topicos2.utils.Util;

@Named
@ViewScoped
public class UsuarioListing extends Listing<Usuario> {

	private static final long serialVersionUID = -2800428910149904765L;

	private String filtro;
	private String dtype;


	public UsuarioListing() {
		super("usuariolisting", new UsuarioRepository());
	}

	@Override
	public void pesquisar() {
		UsuarioRepository repo = new UsuarioRepository();
		try {
			setList(repo.findByEmailAndDTYPE(filtro, dtype));
		} catch (RepositoryException e) {
			e.printStackTrace();
			Util.addErrorMessage("Erro","Problema ao realizar a consulta.");
			limpar();
		}
		
	}

	public String getFiltro() {
		return filtro;
	}
	public void limpar() {
		setList(null);
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public String getDtype() {
		return dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

}
