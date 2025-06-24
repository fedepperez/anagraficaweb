package it.corso.java.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Servlet implementation class Dispatcher
 */
public class DemoSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DemoSessionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		//utilizzo : http://localhost:8080/corso-web05/sessiondemo?articolo=tavolo
		//parte da inserire al momento della spieagazione delle session
	
		List<String>carrello = (List<String>)request.getSession().getAttribute("carrello");
		if(carrello == null) {
			carrello = new ArrayList<String>();
			request.getSession().setAttribute("carrello", carrello);
		}
		
		String articolo = request.getParameter("articolo");
		if(articolo != null && !articolo.trim().equals("")) {
			carrello.add(articolo);
		}
			
					
		request.getServletContext().getRequestDispatcher("/jsp/body.jsp").include(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
	}

}
