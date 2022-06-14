package br.unitins.topicos2.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos2.model.Usuario;
import br.unitins.topicos2.repository.UsuarioRepository;
import br.unitins.topicos2.utils.RepositoryException;
import br.unitins.topicos2.utils.Session;
import br.unitins.topicos2.utils.Util;

@Named
@ViewScoped
public class TemplateController extends Controller<Usuario> implements Serializable {
	public TemplateController() {
		super(new UsuarioRepository());
	}

	private static final long serialVersionUID = -1970357078665982948L;

	public void redirecionar(String pagina) {
		Util.redirect(pagina);
	}

	@Override
	public Usuario getEntity() {
		if (entity == null)
			setEntity((Usuario) Session.getInstance().get("usuarioLogado"));
		return entity;
	}
	
	public void encerrarSessao() {
		Session.getInstance().invalidateSession();
		Util.redirect("/index");
	}
	
	public String findNomeById() {
		String nome = null;
		UsuarioRepository repo = new UsuarioRepository();
		try {
			nome = repo.findNomePfById(getEntity().getId());
			if (nome == null) {
				nome = repo.findNomePjById(getEntity().getId());
			}
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		return nome;
	}
}
