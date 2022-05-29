package br.unitins.topicos2.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

import br.unitins.topicos2.model.PessoaFisica;
import br.unitins.topicos2.model.PessoaJuridica;
import br.unitins.topicos2.model.Usuario;
import br.unitins.topicos2.repository.UsuarioRepository;
import br.unitins.topicos2.utils.Session;
import br.unitins.topicos2.utils.Util;

@Named
@ViewScoped
public class PerfilController extends Controller<Usuario> implements Serializable {
	private static final long serialVersionUID = -6192990699589999580L;
	private InputStream fotoInputStream = null;
	public PerfilController() {
		super(new UsuarioRepository());
	}
	
	public void upload(FileUploadEvent event) {
		UploadedFile uploadFile = event.getFile();
		System.out.println("nome arquivo: " + uploadFile.getFileName());
		System.out.println("tipo: " + uploadFile.getContentType());
		System.out.println("tamanho: " + uploadFile.getSize());

		if (uploadFile.getContentType().equals("image/png")) {
			try {
				fotoInputStream = uploadFile.getInputStream();
				System.out.println("inputStream: " + uploadFile.getInputStream().toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Util.addInfoMessage("Sucesso!", "Upload realizado com sucesso.");
		} else {
			Util.addErrorMessage("Erro!", "O tipo da image deve ser png.");
		}

	}

	@Override
	public void incluir() {
		super.salvarSemLimpar();

		// caso exista uma imagem
		if (getFotoInputStream() != null) {
			// salvando a imagem
			if (! Util.saveImageUsuario(getFotoInputStream(), "png", getEntity().getId())) {
				Util.addErrorMessage("Erro!", "Erro ao salvar. Não foi possível salvar a imagem do usuário.");
				return;
			}
		}
		limpar();
	}

	@Override
	public void alterar() {
		super.salvarSemLimpar();

		// caso exista uma imagem
		if (getFotoInputStream() != null) {
			// salvando a imagem
			if (! Util.saveImageUsuario(getFotoInputStream(), "png", getEntity().getId())) {
				Util.addErrorMessage("Erro!", "Erro ao salvar. Não foi possível salvar a imagem do usuário.");
				return;
			}
		}
		limpar();
	}


	public InputStream getFotoInputStream() {
		return fotoInputStream;
	}

	public void setFotoInputStream(InputStream fotoInputStream) {
		this.fotoInputStream = fotoInputStream;
	}

	@Override
	public Usuario getEntity() {
		if (entity == null) {
			setEntity((Usuario) Session.getInstance().get("usuarioLogado"));
		}
		return entity;
	}

	public boolean getInstanceOfPf() {
		if (getEntity() instanceof PessoaFisica) {
			return true;
		} else if (getEntity() instanceof PessoaJuridica) {
			return false;
		} else {
			return true;
		}
	}

}
