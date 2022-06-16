package br.unitins.topicos2.filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.unitins.topicos2.model.Usuario;
@WebFilter(filterName = "AdminFilter", urlPatterns = {"/admin/*"})
public class AdminFilter implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
				HttpServletRequest servletRequest = (HttpServletRequest) request;
				// retorna uma sessao corrente (false - nao cria uma nova estrutura de sessao)
				HttpSession session =  servletRequest.getSession(false);
				Usuario usuarioLogado = null;
				if (session != null) {
					usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
				}
				
				// se nao estiver logado, redirecionar para a pagina de login
				if(usuarioLogado == null) {
					((HttpServletResponse)response).sendRedirect("/Topicos2/login");
				} else {
					if(usuarioLogado.getPerfil().getId() == 1) {
						chain.doFilter(request, response);
					} else {
						((HttpServletResponse)response).sendRedirect("/Topicos2/index");
					}
				}
				
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
		System.out.println("Filtro Admin inicializado.");
	}
}
