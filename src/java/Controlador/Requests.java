package Controlador;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "Requests", urlPatterns = {"/r"})
public class Requests extends HttpServlet
{
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException
	{
		try (PrintWriter out = response.getWriter())
		{
			//out.println(request.getRequestURL().toString());
			out.println(request.getContextPath());
			//out.println(request.getContentType());
			//out.println(request.getPathInfo());
			//out.println(request.getHeader("Referer"));
			
		}
		
	}
	
	private void doLogin(HttpServletRequest request, HttpServletResponse response)
	{
		//Pasar a doPost
		//Log in
		if(request.getParameter("login")!=null)
		{
			String usu=request.getParameter("user");
			String pass=request.getParameter("pass");
			
			StringBuffer a=new StringBuffer();
			String b=a.toString();
			
			if (!(usu==null||pass==null||usu.isEmpty()||pass.isEmpty()))
			{
				String usuario=new UsuariosController().conectar(usu,pass);
				request.getSession(false).invalidate();
				
				if (usuario!=null)
				{
					HttpSession sesion=request.getSession();
					sesion.setAttribute("usuario", usuario);
					
	//				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/test.jsp");

	//				dispatcher.forward(request, response);
					
					
					
					//	out.println("Hola "+sesion.getAttribute("usuario"));
					
				}
				else
				{
					try (PrintWriter out = response.getWriter()) {
						out.println("Usuario o contraseña equivocados.");
						
					} catch (IOException ex) {
						Logger.getLogger(Requests.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
			}
		}
		//	
	}
	
	private String parseUrl(String url)
	{
		return url.substring(7);
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
		switch (request.getContextPath())
		{
			case "":
				if(request.getParameter("login")!=null)
					doLogin(request,response);
				else
					response.sendError(HttpServletResponse.SC_NOT_FOUND);
				break;
			default:
				processRequest(request, response);
		}
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
		switch (request.getContextPath())
		{
			
			default:
				processRequest(request, response);
		}
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
