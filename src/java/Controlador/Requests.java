package Controlador;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "Requests", urlPatterns = {"/r"})
public class Requests extends HttpServlet
{
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)			throws ServletException, IOException {
		
		//Pasar a doPost
		//Log in
		if(request.getParameter("login")!=null)
		{
			String usu=request.getParameter("user");
			String pass=request.getParameter("pass");
			
			if (usu!=null&&pass!=null)
			{
				String usuario=new UsuariosController().conectar(usu,pass);
				if (request.getSession(false)==null&&usuario!=null)
				{
					HttpSession sesion=request.getSession();
					sesion.setAttribute("usuario", usuario);
					
					
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/test.jsp");

					dispatcher.forward(request, response);
				}
			}
		}
		//	
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
