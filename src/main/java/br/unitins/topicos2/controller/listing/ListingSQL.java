package br.unitins.topicos2.controller.listing;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.primefaces.PrimeFaces;

import br.unitins.topicos2.model.DefaultEntity;
import br.unitins.topicos2.repository.Repository;
import br.unitins.topicos2.utils.RepositoryException;

public abstract class ListingSQL<T extends DefaultEntity> implements Serializable{

	private static final long serialVersionUID = 442507269200062526L;

	private final String page;
	private final Repository<T> repository;
	private List<Object[]> list;

	public ListingSQL(String page, Repository<T> repository) {
		super();
		this.page = page;
		this.repository = repository;
	}

	public void open() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("modal", true);
		options.put("draggable", true);
		options.put("resizable", true);
		options.put("width", 800);
		options.put("height", 400);
		options.put("contentWidth", "100%");
		options.put("contentHeight", "100%");

		PrimeFaces.current().dialog().openDynamic(page, options, null);

	}

	public void select(int id) {
		T obj = null;
		try {
			obj = repository.findById(id);
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		PrimeFaces.current().dialog().closeDynamic(obj);
	}

	public abstract void pesquisar();

	public List<Object[]> getList() {
		return list;
	}

	public void setList(List<Object[]> list) {
		this.list = list;
	}

}
