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
public class LoginController extends Controller<Usuario> implements Serializable {

	public LoginController() {
		super(new UsuarioRepository());
	}

	private static final long serialVersionUID = -538333419884215676L;

	@Override
	public Usuario getEntity() {
		if (entity == null) {
			entity = new Usuario();
		}
		return entity;
	}

	UsuarioRepository repo = new UsuarioRepository();

	public void login() {
		try {
			setEntity(repo.verifyLogin(getEntity().getEmail(), getEntity()));
			if (getEntity().getId() != null) {
				Session.getInstance().set("usuarioLogado", getEntity());
				Util.redirect("/index");
			} else {
				Util.addErrorMessage("Erro!", "Usuário não encontrado");
				return;
			}
		} catch (RepositoryException e) {
			Util.addErrorMessage("Erro!", "Problema ao fazer login");
			e.printStackTrace();
		}
	}
	
	public void abrirCadastro() {
		
	}

}
