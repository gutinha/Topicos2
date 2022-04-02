package br.unitins.topicos2.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import br.unitins.topicos2.model.Usuario;
import br.unitins.topicos2.repository.UsuarioRepository;
import br.unitins.topicos2.utils.RepositoryException;
import br.unitins.topicos2.utils.Util;

@Named
@ViewScoped
public class CadastroController extends Controller<Usuario> implements Serializable {
	private static final long serialVersionUID = 1654611211341132483L;
	private List<Usuario> listaUsuario;
	private String nomePesquisa;

	public CadastroController() {
		super(new UsuarioRepository());
	}

	public void pesquisar() {
		UsuarioRepository repo = new UsuarioRepository();
		try {
			listaUsuario = repo.findByNome(getNomePesquisa());
		} catch (RepositoryException e) {
			e.printStackTrace();
			listaUsuario = new ArrayList<Usuario>();
		}
	}

	public void editar(Usuario usuario) {
		setEntity(usuario);
	}

	public List<Usuario> getListaUsuario() {
		if (listaUsuario == null) {
			listaUsuario = new ArrayList<Usuario>();
		}
		return listaUsuario;
	}

	@Override
	public Usuario getEntity() {
		if (entity == null)
			entity = new Usuario();
		return entity;
	}

	public String getNomePesquisa() {
		return nomePesquisa;
	}

	public void setNomePesquisa(String nomePesquisa) {
		this.nomePesquisa = nomePesquisa;
	}

	public void redirecionar(String pagina) {
		Util.redirect(pagina);
	}
}
