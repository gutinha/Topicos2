package br.unitins.topicos2.controller;

import br.unitins.topicos2.model.DefaultEntity;
import br.unitins.topicos2.repository.Repository;
import br.unitins.topicos2.utils.RepositoryException;
import br.unitins.topicos2.utils.Util;
import br.unitins.topicos2.utils.VersionException;

public abstract class Controller <T extends DefaultEntity> {
	private final Repository<T> repository;
	protected T entity;
	
	public Controller(Repository<T> repository) {
		super();
		this.repository = repository;
	}

	public void incluir() {
		try {
			limparRelacionamentosNaoObrigatorios();
			setEntity(getRepository().save(getEntity()));
			Util.addInfoMessage("Sucesso!", "Inclusão realizada com sucesso.");
			limpar();
		} catch (RepositoryException | VersionException e) {
			e.printStackTrace();
			Util.addErrorMessage("Erro!", e.getMessage());
		}
	}
	
	public void salvarSemLimpar() {
		try {
			limparRelacionamentosNaoObrigatorios();
			setEntity(getRepository().save(getEntity()));
			Util.addInfoMessage("Sucesso!", "Salvo com sucesso.");
		} catch (RepositoryException | VersionException e) {
			e.printStackTrace();
			Util.addErrorMessage("Erro!", e.getMessage());
		}
	}

	public void alterar() {
		try {
			limparRelacionamentosNaoObrigatorios();
			setEntity(getRepository().save(getEntity()));
			Util.addInfoMessage("Sucesso", "Alteração realizada com sucesso.");
			limpar();
		} catch (RepositoryException | VersionException e) {
			e.printStackTrace();
			Util.addErrorMessage("Erro!", e.getMessage());
		}
	}
	
	protected void limparRelacionamentosNaoObrigatorios() {

	}
	
	public void excluir(){
		try {
			setEntity(getRepository().save(getEntity()));
			Util.addInfoMessage("Sucesso", "Exclusão realizada com sucesso.");
			limpar();
		} catch (RepositoryException | VersionException e) {
			e.printStackTrace();
			Util.addErrorMessage("Erro!", e.getMessage());
		}
	}

	
	public void limpar() {
		entity = null;
	}
	
	public Repository<T> getRepository() {
		return repository;
	}
	
	public abstract T getEntity();
	
	public void setEntity(T entity) {
		this.entity = entity;
	}
}
