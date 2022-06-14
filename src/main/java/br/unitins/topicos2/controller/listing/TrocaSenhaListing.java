package br.unitins.topicos2.controller.listing;

import br.unitins.topicos2.model.Usuario;
import br.unitins.topicos2.repository.UsuarioRepository;

public class TrocaSenhaListing extends Listing<Usuario>{

	private static final long serialVersionUID = -5969361158536499305L;

	public TrocaSenhaListing() {
		super("trocaSenha", new UsuarioRepository());
	}

	@Override
	public void pesquisar() {}

}
