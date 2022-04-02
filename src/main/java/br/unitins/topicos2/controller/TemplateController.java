package br.unitins.topicos2.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos2.utils.Util;

@Named
@ViewScoped
public class TemplateController implements Serializable {
	private static final long serialVersionUID = -1970357078665982948L;
	
	public void redirecionar(String pagina) {
		Util.redirect(pagina);
	}
}
