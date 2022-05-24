package br.unitins.topicos2.controller;

import java.io.Serializable;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos2.model.EsqueceuSenha;
import br.unitins.topicos2.model.Usuario;
import br.unitins.topicos2.repository.EsqueceuSenhaRepository;
import br.unitins.topicos2.repository.UsuarioRepository;
import br.unitins.topicos2.utils.RepositoryException;
import br.unitins.topicos2.utils.Util;
import br.unitins.topicos2.utils.VersionException;

@Named
@ViewScoped
public class RedefinirSenhaController extends Controller<Usuario> implements Serializable {
	private static final long serialVersionUID = 7042168092791308258L;
	Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
	String codigoUrl = params.get("cod");
	String codigo = null;
	String senha = "";
	EsqueceuSenhaRepository repoE = new EsqueceuSenhaRepository();
	UsuarioRepository repoU = new UsuarioRepository();
	EsqueceuSenha es = new EsqueceuSenha();
	boolean retorno = false;

	public RedefinirSenhaController() {
		super(new UsuarioRepository());
	}

	@Override
	public Usuario getEntity() {
		if (entity == null) {
			entity = new Usuario();
		}
		return entity;
	}

	public boolean validCodigo() {
		try {
			setEs(repoE.validateCodigo(codigo));
			if (getEs() != null) {
				Util.addInfoMessage("Sucesso!", "Código válido");
				getEs().setUtilizado(true);
				setRetorno(true);
				return true;
			} else {
				Util.addErrorMessage("Erro!", "Código inválido ou expirado");
				setCodigo(null);
			}
		} catch (RepositoryException e) {
			Util.addErrorMessage("Erro!", "Ocorreu um erro ao validar o código");
			e.printStackTrace();
		}
		return false;
	}

	public void redefinirSenha() {
		try {
			if(getCodigoUrl() != null) {
				validCodigo();
			}
			if (isRetorno() == false) {
				return;
			}
			setEntity(repoE.findUserByCodigo(getCodigo()));
			if (getEntity().getId() != null) {
				getEntity().setSenha(senha);
				getEntity().setSenha(Util.hash(getEntity()));
				//Salvando o EsqueceuSenha (necessario salvar primeiro pq tem relacionamento no usuario e o version tava travando)
				try {
					repoE.save(getEs());
				} catch (RepositoryException e) {
					Util.addErrorMessage("Erro!", "Problema ao desabilitar o código");
					e.printStackTrace();
				} catch (VersionException e) {
					Util.addErrorMessage("Erro!", "Código alterado, gere outro");
					e.printStackTrace();
				}
				//Trocando a senha
				try {
					repoU.save(getEntity());
					Util.addInfoMessage("Sucesso!", "Senha alterada com sucesso");
				} catch (VersionException e) {
					e.printStackTrace();
				}
			}
		} catch (RepositoryException e) {
			Util.addErrorMessage("Erro!", "Problema ao alterar a senha");
			e.printStackTrace();
		}
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCodigo() {
		if(getCodigoUrl() != null) {
			setCodigo(getCodigoUrl());
		}
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getCodigoUrl() {
		return codigoUrl;
	}

	public void setCodigoUrl(String codigo) {
		this.codigoUrl = codigo;
	}

	public boolean isRetorno() {
		return retorno;
	}

	public void setRetorno(boolean retorno) {
		this.retorno = retorno;
	}

	public EsqueceuSenha getEs() {
		return es;
	}

	public void setEs(EsqueceuSenha es) {
		this.es = es;
	}

}
