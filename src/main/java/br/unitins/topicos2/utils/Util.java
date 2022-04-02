package br.unitins.topicos2.utils;

import java.io.IOException;
import java.text.DecimalFormat;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

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
	
	public static String formatPrice(Double price) {
		DecimalFormat formatter = new DecimalFormat("###,###,##0.00");
		 return formatter.format(price);
	}

}
