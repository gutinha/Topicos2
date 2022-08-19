package br.unitins.topicos2.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.topicos2.controller.listing.EditUserModal;
import br.unitins.topicos2.controller.listing.EstadoListing;
import br.unitins.topicos2.controller.listing.UsuarioModal;
import br.unitins.topicos2.model.Cidade;
import br.unitins.topicos2.model.PessoaFisica;
import br.unitins.topicos2.model.PessoaJuridica;
import br.unitins.topicos2.model.Usuario;
import br.unitins.topicos2.repository.UsuarioRepository;
import br.unitins.topicos2.utils.RepositoryException;
import br.unitins.topicos2.utils.Session;
import br.unitins.topicos2.utils.Util;

@Named
@ViewScoped
public class GerenciarUsuarioController extends Controller<Usuario> implements Serializable {
	private static final long serialVersionUID = 6499961826748908257L;
	private List<Usuario> users= null;
	UsuarioRepository repo = new UsuarioRepository();
	public GerenciarUsuarioController() {
		super(new UsuarioRepository());
	}

	@Override
	public Usuario getEntity() {
		if (entity == null) {
			setEntity((Usuario) Session.getInstance().get("usuarioLogado"));
		}
		return entity;
	}
	
	public List<Usuario> listUser(){
		try {
			setUsers(repo.findAllUsers());
		} catch (RepositoryException e) {
			Util.addErrorMessage("Erro!", "Problema ao buscar os usuários");
			e.printStackTrace();
		}
		return getUsers();
		
	}
	
	public void view(Integer id) {
		try {
			setEntity(repo.findById(id));
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Session.getInstance().set("usuarioFlash", getEntity());
		abrirUsuarioModal();
	}
	
	public void abrirUsuarioModal() {
		UsuarioModal modal = new UsuarioModal();
		modal.open();
	}
	public void edit(Integer id) {
		try {
			Session.getInstance().set("editUser", repo.findById(id));
			Util.redirect("/admin/editUser");
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(Integer id) {
		
			try {
				setEntity(repo.findById(id));
				getEntity().setExcluido(true);
			} catch (RepositoryException e) {
				e.printStackTrace();
			}
		
		super.excluir();
	}

	public List<Usuario> getUsers() {
		return users;
	}

	public void setUsers(List<Usuario> users) {
		this.users = users;
	}
	
}
