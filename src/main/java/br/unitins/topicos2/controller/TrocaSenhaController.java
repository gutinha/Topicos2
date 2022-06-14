package br.unitins.topicos2.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.hibernate.internal.build.AllowSysOut;

import br.unitins.topicos2.model.Usuario;
import br.unitins.topicos2.repository.UsuarioRepository;
import br.unitins.topicos2.utils.Session;
import br.unitins.topicos2.utils.Util;
@Named
@ViewScoped
public class TrocaSenhaController extends Controller<Usuario> implements Serializable{

	private static final long serialVersionUID = -3289281458840023248L;
	private String senhaAtual;
	private String novaSenha;
	private String repeteSenha;
	private String senhaAtualHash;

	public TrocaSenhaController() {
		super(new UsuarioRepository());
	}
	
	public void trocaSenha() {
		setSenhaAtualHash(Util.hash(getEntity(), getSenhaAtual()));
		if(!getNovaSenha().equals(getRepeteSenha())) {
			Util.addErrorMessage("Erro!", "As senhas não coincidem");
		}
		
		if(getEntity().getSenha().equals(getSenhaAtualHash())) {
			getEntity().setSenha(Util.hash(getEntity(), getNovaSenha()));
			alterar();
		} else {
			System.out.print(Util.hash(getEntity()));
			Util.addErrorMessage("Erro!", "Senha atual incorreta");
			return;
		}
		
	}
	
	@Override
	public Usuario getEntity() {
		if(entity == null) {
			setEntity((Usuario) Session.getInstance().get("usuarioLogado"));
		}
		return entity;
	}

	public String getSenhaAtual() {
		return senhaAtual;
	}

	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}

	public String getRepeteSenha() {
		return repeteSenha;
	}

	public void setRepeteSenha(String repeteSenha) {
		this.repeteSenha = repeteSenha;
	}

	public String getSenhaAtualHash() {
		return senhaAtualHash;
	}

	public void setSenhaAtualHash(String senhaAtualHash) {
		this.senhaAtualHash = senhaAtualHash;
	}
	
}
