package br.unitins.topicos2.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos2.model.PessoaFisica;
import br.unitins.topicos2.model.PessoaJuridica;
import br.unitins.topicos2.model.Usuario;
import br.unitins.topicos2.repository.UsuarioRepository;
import br.unitins.topicos2.utils.Session;
import br.unitins.topicos2.utils.Util;

@Named
@ViewScoped
public class EditUserController extends Controller<Usuario> implements Serializable{
	private static final long serialVersionUID = 1089768686130090573L;

	public EditUserController() {
		super(new UsuarioRepository());
	}
	//retorna o tipo de usuário logado na sessão
	public boolean getInstanceOfPf() {
		if (getEntity() instanceof PessoaFisica) {
			return true;
		} else return !(getEntity() instanceof PessoaJuridica);
	}
	
	@Override
	public void alterar() {
		super.alterar();
		Util.redirect("/admin/gerenciarUsuario");
	}
	
	@Override
	public Usuario getEntity() {
		if(entity == null) {
			entity = (Usuario) Session.getInstance().get("editUser");
		}
		return entity;
	}

}
