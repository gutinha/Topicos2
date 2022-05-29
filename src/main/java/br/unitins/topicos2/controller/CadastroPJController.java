package br.unitins.topicos2.controller;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.SelectEvent;
import br.unitins.topicos2.controller.listing.CidadeListing;
import br.unitins.topicos2.model.Cidade;
import br.unitins.topicos2.model.Endereco;
import br.unitins.topicos2.model.PessoaJuridica;
import br.unitins.topicos2.repository.PessoaJuridicaRepository;
import br.unitins.topicos2.utils.Util;

@Named
@ViewScoped
public class CadastroPJController extends Controller<PessoaJuridica> implements Serializable {
	private static final long serialVersionUID = 1654611211341132483L;
	private boolean skip;

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	public CadastroPJController() {
		super(new PessoaJuridicaRepository());
	}
	

	@Override
	public PessoaJuridica getEntity() {
		if (entity == null) {
			entity = new PessoaJuridica();
			entity.setEndereco(new Endereco(new Cidade()));
			entity.setPerfil("cliente");
        }
		return entity;
	}
	
	public void incluirHash() {
		getEntity().setSenha(Util.hash(getEntity()));
		incluir();
	}
	
	public String onFlowProcess(FlowEvent event) {
        if (skip) {
            skip = false; //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }
	
	public void abrirCidadeListing() {
		CidadeListing listing = new CidadeListing();
		listing.open();
	}

	public void obterCidadeListing(SelectEvent<Cidade> event) {
		getEntity().getEndereco().setCidade(event.getObject());
	}
	
}
