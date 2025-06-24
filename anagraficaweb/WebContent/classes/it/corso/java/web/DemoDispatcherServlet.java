package it.corso.java.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class DispatcherDemo
 */
public class DemoDispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DemoDispatcherServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //fase 1 esempio di uso del include
        //inoltra la richiesta a una pagine JSP	e poi per includere l'output proveniente da un'altra risorsa
	
		request.getServletContext().getRequestDispatcher("/jsp/header.jsp").include(request, response);
		
		
		String pagina = request.getParameter("pagina");
		if(pagina != null && !pagina.trim().equals("")) {
			if(pagina.equals("1")) {
				request.getServletContext().getRequestDispatcher("/jsp/body1.jsp").include(request, response);
			}else if(pagina.equals("2")){
				request.getServletContext().getRequestDispatcher("/jsp/body2.jsp").include(request, response);
			}else{
				request.getServletContext().getRequestDispatcher("/jsp/body3.jsp").include(request, response);
			}
		}else {
			request.getServletContext().getRequestDispatcher("/jsp/body.jsp").include(request, response);
		}
	

		request.getServletContext().getRequestDispatcher("/jsp/footer.jsp").include(request, response);
        
		// esempio uso forward noto che l' URL non cambia perche' l'indirizzamento avviene a livello di server 
//		request.getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(request, response);
		
		//Esempio redirect :
//		response.sendRedirect("https://www.google.it");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
