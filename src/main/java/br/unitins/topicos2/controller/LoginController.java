package br.unitins.topicos2.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import br.unitins.topicos2.model.Usuario;
import br.unitins.topicos2.repository.UsuarioRepository;

@Named
@ViewScoped
public class LoginController extends Controller<Usuario> implements  Serializable{
	
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
	
	

}
