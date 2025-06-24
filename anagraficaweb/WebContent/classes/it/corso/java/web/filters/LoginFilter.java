package it.corso.java.web.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

/**
 * Servlet Filter implementation class LoginFilter
 */
//@WebFilter("/jsp/*")
public class LoginFilter extends HttpFilter implements Filter {

	/**
	 * @see HttpFilter#HttpFilter()
	 */
	public LoginFilter() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	
		 	HttpServletRequest httpRequest = (HttpServletRequest) request;
		    HttpServletResponse httpResponse = (HttpServletResponse) response;
		    // Questo metodo non crea una nuova sessione se non ne esiste già una. 
		    // Se una sessione esiste, la restituisce; altrimenti, restituisce null.
		    // Ottiene la sessione dell'utente
		    HttpSession session = httpRequest.getSession(false);

		    // Controlla se l'utente è autenticato
		    if (session != null && session.getAttribute("username") != null) {
		        // Log di debug
		        System.out.println("Utente autenticato, continua il processo della richiesta.");
		        // Se l'utente è autenticato, continua il processo della richiesta
		        chain.doFilter(request, response);
		    
		    } else {
		        // Log di debug
		        System.out.println("Utente non autenticato, reindirizza alla pagina di login.");
		        // Se l'utente non è autenticato, reindirizza alla pagina di login
		        System.out.println(httpRequest.getContextPath() + "/loginservlet");
		        httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
		        // Assicurati che la risposta non venga processata ulteriormente
		        return;
		    }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
