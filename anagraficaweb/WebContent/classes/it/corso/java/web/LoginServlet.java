package it.corso.java.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		/*
		 * Quando accedi a un sito con username e password:
		 * 
		 * Il server crea una sessione e la memorizza. Ogni richiesta successiva (ad
		 * esempio, navigare tra le pagine) mantiene l'utente autenticato grazie alla
		 * sessione. Se cancelli i cookie del browser o la sessione scade, dovrai
		 * effettuare nuovamente il login.
		 */
		// Ottieni la sessione o creane una nuova se non esiste
		HttpSession session = request.getSession(true);

		// Imposta username e password come attributi di sessione
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		

		// Aggiungi messaggio di conferma alla risposta
		response.setContentType("text/html");
		response.getWriter().println("Username e password impostati nella sessione con successo.");
		if (username.equalsIgnoreCase((String)session.getAttribute("username")) 
				&& password.equalsIgnoreCase((String)session.getAttribute("password"))) {
			httpResponse.sendRedirect(httpRequest.getContextPath() + "/jsp/pagina_che_vorrei_visitare.jsp");
		}
	}

}
