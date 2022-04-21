package br.unitins.topicos2.controller;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import br.unitins.topicos2.model.Cidade;
import br.unitins.topicos2.repository.CidadeRepository;

@Named
@ViewScoped
public class CadastroCidadeController extends Controller<Cidade> implements Serializable{
	private static final long serialVersionUID = 8217878350772866819L;

	public CadastroCidadeController() {
		super(new CidadeRepository());
	}

	@Override
	public Cidade getEntity() {
		// TODO Auto-generated method stub
		return null;
	}

}
