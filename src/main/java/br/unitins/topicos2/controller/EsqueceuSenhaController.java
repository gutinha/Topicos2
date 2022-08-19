package br.unitins.topicos2.controller;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Random;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos2.model.EsqueceuSenha;
import br.unitins.topicos2.model.Usuario;
import br.unitins.topicos2.repository.EsqueceuSenhaRepository;
import br.unitins.topicos2.repository.UsuarioRepository;
import br.unitins.topicos2.utils.Email;
import br.unitins.topicos2.utils.RepositoryException;
import br.unitins.topicos2.utils.Util;
import br.unitins.topicos2.utils.VersionException;

@Named
@ViewScoped
public class EsqueceuSenhaController implements Serializable {
	private static final long serialVersionUID = 9131714887738853550L;

	UsuarioRepository repo = new UsuarioRepository();
	Random r = new Random();
	private String email;
	Usuario usuario = new Usuario();
	String codigo = "";

	public void enviarEmail() {
		if (!findUsuario()) {
			Util.addErrorMessage("Erro!", "E-mail não encontrado em nosso banco de dados.");
			return;
		}

		generateCodigo();

		if (!generateEsqueceuSenha()) {
			Util.addErrorMessage("Erro!", "Não foi possível gerar a chave, tente novamente mais tarde.");
			return;
		}

		Email email = new Email(usuario.getEmail(), "Redefinir senha", codigo);
		if (!email.enviar()) {
			Util.addErrorMessage("Erro!", "Problema ao enviar o email.");
		} else {
			Util.addInfoMessage("Sucesso!", "Código enviado para seu email.");
			Util.redirect("/redefinirSenha");
		}
	}

	public boolean generateEsqueceuSenha() {
		// 3 - EsqueceuSenha
		EsqueceuSenha esqueceu = new EsqueceuSenha();
		esqueceu.setUsuario(usuario);
		esqueceu.setCodigo(codigo);
		esqueceu.setDataHoraLimite(LocalDateTime.now().plusDays(1));
		esqueceu.setUtilizado(false);
		EsqueceuSenhaRepository repoEsqueceu = new EsqueceuSenhaRepository();
		try {
			repoEsqueceu.save(esqueceu);
		} catch (RepositoryException | VersionException e) {
			// Util.addErrorMessage("Erro!", "Problema ao gerar o código, tente
			// novamente.");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean findUsuario() {
		// 1 - Buscar o usuario
		try {
			usuario = repo.findByEmail(getEmail());
			if (usuario == null) {
				// Util.addErrorMessage("Erro!", "Email não encontrado em nosso banco de
				// dados.");
				return false;
			}
		} catch (RepositoryException e) {
			e.printStackTrace();
			// Util.addErrorMessage("Erro!", "Problema ao encontrar o email.");
			return false;
		}
		return true;
	}

	public void generateCodigo() {
		// 2 - Gerar codigo
		codigo = new DecimalFormat("T-000000").format(r.nextInt(1000000));
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
