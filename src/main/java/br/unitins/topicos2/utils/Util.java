package br.unitins.topicos2.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;

import org.apache.commons.codec.digest.DigestUtils;

import br.unitins.topicos2.model.Usuario;
import br.unitins.topicos2.servlet.ImgUsuarioServlet;

public class Util {
	
	public static void redirect(String page) {
		try {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();;
			ec.redirect(ec.getRequestContextPath() + page);
		} catch (IOException e) {
			System.out.println("Não foi possível realizar o redirecionamento.");
			e.printStackTrace();
		}
	}
	
	private static String hash(String valor) {
		return DigestUtils.sha256Hex(valor);
	}
	public static String hash(Usuario usuario) {
		return hash(usuario.getEmail()+usuario.getSenha());
	}
	
	public static String hash(Usuario usuario, String senha) {
		return hash(usuario.getEmail()+senha);
	}
	
	private static void addMessage(String titulo, Severity severity, String content) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, titulo, content));
	}
	
	public static void addErrorMessage(String titulo, String content) {
		addMessage(titulo,FacesMessage.SEVERITY_ERROR,content);
	}
	
	public static void addWarnMessage(String titulo, String content) {
		addMessage(titulo,FacesMessage.SEVERITY_WARN,content);
	}
	
	public static void addInfoMessage(String titulo, String content) {
		addMessage(titulo,FacesMessage.SEVERITY_INFO,content);
	}
	
	private static DecimalFormat formatter = new DecimalFormat("###,###,##0.00");
	public static String formatPrice(Double price) {
		 return formatter.format(price);
	}
	
	public static boolean saveImageUsuario(InputStream inputStream, String imageType, int idUsuario) {
		// Exemplo da maquina do janio: /home/janio/images/usuario
		String diretorio = System.getProperty("user.home") + ImgUsuarioServlet.PATH_IMAGES_USUARIO;

		// Criando os diretorios caso nao exista
		File file = new File(diretorio);
		if (!file.exists()) {
			file.mkdirs(); // mkdirs - cria arquivo ou diretorio (caso o diretorio anterior nao exista ele cria tambem)
		}

		try {
			// criando o espaco de memoria para armazenamento de uma imagem
			// inputStream - eh o fluxo de dados de entrada 
			BufferedImage bImage = ImageIO.read(inputStream);

			// estrutura final do arquivo ex: /home/janio/images/usuario/01.png
			File arquivoFinal = new File(diretorio + File.separator + idUsuario + "." + imageType);
			// salvando a imagem
			// buffer da imagem, png/gif, 01.png
			ImageIO.write(bImage, imageType, arquivoFinal);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
