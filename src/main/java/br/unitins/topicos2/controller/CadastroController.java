package br.unitins.topicos2.controller;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import br.unitins.topicos2.controller.listing.UsuarioListing;
import br.unitins.topicos2.model.PessoaFisica;
import br.unitins.topicos2.model.PessoaJuridica;
import br.unitins.topicos2.model.Usuario;
import br.unitins.topicos2.repository.UsuarioRepository;
import br.unitins.topicos2.utils.Util;

@Named
@ViewScoped
public class CadastroController extends Controller<Usuario> implements Serializable {
	private static final long serialVersionUID = 1654611211341132483L;
	private boolean pessoaJuridica;

	public CadastroController() {
		super(new UsuarioRepository());
	}


	@Override
	public Usuario getEntity() {
		if (entity == null) {
            entity = new Usuario();
            if (isPessoaJuridica()) {
                entity = new PessoaJuridica();
            } else {
                entity = new PessoaFisica();
            }

            //entity.setEndereco(new Endereco(new Cidade(new Estado())));
        }
		
		return entity;
	}
	
	public void abrirUsuarioListing() {
		UsuarioListing listing = new UsuarioListing();
		listing.open();
	}

	public void obterUsuarioListing(SelectEvent<Usuario> event) {
		setEntity(event.getObject());
	}


	public void redirecionar(String pagina) {
		Util.redirect(pagina);
	}

	public boolean isPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(boolean pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}
}
