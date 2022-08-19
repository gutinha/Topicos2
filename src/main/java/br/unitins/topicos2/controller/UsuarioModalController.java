package br.unitins.topicos2.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos2.model.PessoaFisica;
import br.unitins.topicos2.model.PessoaJuridica;
import br.unitins.topicos2.model.Usuario;
import br.unitins.topicos2.repository.UsuarioRepository;
import br.unitins.topicos2.utils.Session;

@Named
@ViewScoped
public class UsuarioModalController extends Controller<Usuario> implements Serializable{
	private static final long serialVersionUID = 7018980303302111935L;
	public UsuarioModalController() {
		super(new UsuarioRepository());
		entity = (Usuario) Session.getInstance().get("usuarioFlash");
	}

	@Override
	public Usuario getEntity() {
		return entity;
	}
	//retorna a instancia de pessoa fisica ou juridica - usado pra renderizar os campos
		public boolean getInstanceOfPf() {
			if (getEntity() instanceof PessoaFisica) {
				return true;
			} else return !(getEntity() instanceof PessoaJuridica);
		}

}
