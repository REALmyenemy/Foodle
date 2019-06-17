package Controlador;

import Modelo.Usuario;
import java.io.*;
import java.sql.SQLException;
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
	
	private void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException
	{
		String usu=request.getParameter("user");
		String pass=request.getParameter("pass");

		if (!(usu==null||pass==null||usu.isEmpty()||pass.isEmpty()))
		{
			UsuariosController uc=new UsuariosController();
			String usuario=uc.conectar(usu,pass);
			request.getSession().invalidate();
			
			if (usuario!=null)
			{
				HttpSession sesion=request.getSession();
				if(UsuariosController.esAlumno(usuario))
				{
					sesion.setAttribute("usuario", uc.crearAlumno(usuario));
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/aLogin.jsp");
					try {
					dispatcher.forward(request, response);
					} catch (IOException ex) {
						Logger.getLogger(Requests.class.getName()).log(Level.SEVERE, null, ex);
					}
				} else if(UsuariosController.esProfesor(usuario))
				{
					sesion.setAttribute("usuario", uc.crearProfesor(usuario));
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pLogin.jsp");
					try {
						dispatcher.forward(request, response);

						} catch (IOException ex) {
							Logger.getLogger(Requests.class.getName()).log(Level.SEVERE, null, ex);
						}
				}
				else //¿Ni alumno ni profesor? Algo raro pasa aquí....
				{
					try
					{
						response.sendError(HttpServletResponse.SC_NOT_FOUND); //Tirale un 404...
					} catch (IOException ex) {
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/"); //Si no puedes mandalo a relogear
					}
				}
				

				
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
			case "/Foodle":
				
				if(request.getParameter("login")!=null)
					doLogin(request,response);
				else
					response.sendError(HttpServletResponse.SC_NOT_FOUND);
				break;
				
			case "/Foodle/altaAlumno.jsp":
				if(request.getParameter("alta")!=null)
				{
					try {
						UsuariosController.altaAlumno(request);
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pLogin.jsp");
					
						dispatcher.forward(request, response);

						} catch (IOException ex) {
							Logger.getLogger(Requests.class.getName()).log(Level.SEVERE, null, ex);
						} catch (SQLException ex) {
							Logger.getLogger(Requests.class.getName()).log(Level.SEVERE, null, ex); //Salta si usuario duplicado
						}
				}
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
