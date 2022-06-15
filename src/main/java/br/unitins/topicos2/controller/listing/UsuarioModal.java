package br.unitins.topicos2.controller.listing;

import br.unitins.topicos2.model.Usuario;
import br.unitins.topicos2.repository.UsuarioRepository;

public class UsuarioModal extends Listing<Usuario>{
	private static final long serialVersionUID = 2970874529045004574L;

	public UsuarioModal() {
		super("usuarioModal", new UsuarioRepository());
	}

	@Override
	public void pesquisar() {}

}
