package br.unitins.topicos2.controller.listing;

import br.unitins.topicos2.model.Usuario;
import br.unitins.topicos2.repository.UsuarioRepository;

public class EditUserModal extends Listing<Usuario>{

	private static final long serialVersionUID = 7740314572821452391L;

	public EditUserModal() {
		super("editUser", new UsuarioRepository());
	}

	@Override
	public void pesquisar() {
		// TODO Auto-generated method stub
		
	}

}
