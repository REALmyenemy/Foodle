package Controlador;

import Modelo.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class ExamenServlet extends HttpServlet {

	private final int max_size = 1024 * 1024 * 16;
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException
	{
		RequestDispatcher dispatcher;		
		if (request.getParameter("submit").toLowerCase().compareTo("agregar pregunta")==0)
		{
			crearPregunta(request);
			dispatcher= getServletContext().getRequestDispatcher("/altaExamen.jsp");
		}
		else if (request.getParameter("submit").toLowerCase().compareTo("crear nuevo ex&aacute;men")==0||request.getParameter("submit").toLowerCase().compareTo("crear nuevo exámen")==0)
		{
			crearPregunta(request);
			dispatcher= getServletContext().getRequestDispatcher("/pLogin.jsp");
		}else	
		{	
			dispatcher = getServletContext().getRequestDispatcher("/");
		}
		dispatcher.forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void subirImagen(Part imagen)
	{
		
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}
	
	
	private int existeONo(int index, HttpServletRequest request)
	{
		String a;
		
		if (request.getParameter("respuesta"+index).compareTo("")==0)
			return index;
		else
		{
			return existeONo(index+1,request);
		}
	}
	
	private void crearPregunta(HttpServletRequest request)
	{
		ArrayList<JPregunta> preguntas;
		
		if (request.getSession(false).getAttribute("preguntas")==null)
		{
			preguntas=new ArrayList();
			request.getSession(false).setAttribute("preguntas",preguntas);
		}
		preguntas=(ArrayList<JPregunta>)request.getSession(false).getAttribute("preguntas");
		JPregunta pregunta=new JPregunta();
		try {
			//pregunta.setDirImagen(getServletContext().getRealPath("/"+sesionExamen+"/"+preguntas.size()));
			pregunta.setImagen(request.getPart("imagen"));
		} catch (IOException ex) {
			Logger.getLogger(ExamenServlet.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ServletException ex) {
			Logger.getLogger(ExamenServlet.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		pregunta.setId(preguntas.size());
		pregunta.setPregunta(request.getParameter("pregunta"));
		int respuestas=existeONo(1,request);
		for (int i=1;i<respuestas;i++)
		{
			Respuesta r=new Respuesta();
			r.setTexto(request.getParameter("respuesta"+i));
			r.setValorSelect(Float.parseFloat(request.getParameter("valor"+i)));
			r.setValorNoSelect(Float.parseFloat(request.getParameter("nega"+i)));
			pregunta.getSrespuestas().add(r);
		}
		preguntas.add(pregunta);
		request.getSession(false).setAttribute("preguntas", request);
	}
	private void crearExamen(HttpServletRequest request)
	{
		Conectar c= new Conectar();
			try {
				c.lanzar("insert into examen values ('"+request.getParameter("materia")+"',"+request.getParameter("desordenar"));
				c.ejecutar("select id from examen");
				ResultSet rst=c.getRset();
				rst.next();
				
				ArrayList<JPregunta> preguntas=(ArrayList<JPregunta>)request.getSession(false).getAttribute("preguntas");
				int examen=rst.getInt(1);
				String materia=request.getParameter("materia");
				for (int i=0;i<preguntas.size();i++)
				{
					JPregunta pregunta=preguntas.get(i);
					pregunta.setDirImagen(getServletContext().getRealPath("/")+examen+"/"+pregunta.getImagen().getSubmittedFileName());
					
					c.lanzar("insert into preguntas values ("+examen+"',"+pregunta.getDirImagen()+"',"+pregunta.getSrespuestas().size()+")");
					ArrayList<Respuesta> respuestas=pregunta.getSrespuestas();
					for (int j=0; j<respuestas.size();j++)
					{
						Respuesta r=respuestas.get(j);
						c.lanzar("insert into respuestas values("+examen+","+i+",'"+r.getTexto()+"',"+r.getValorSelect()+","+r.getValorNoSelect()+")");
					}
					procesarImagen(pregunta);
				}
				
				
			} catch (SQLException ex) {
				
			}
			
	}

	private void procesarImagen(JPregunta pregunta)
	{
		InputStream input=null;
		try {
			Part p=pregunta.getImagen();
			input = p.getInputStream();
			FileOutputStream output = new FileOutputStream(pregunta.getDirImagen());
			byte[] buffer = new byte[max_size];
			while (input.available() > 0) {
			int size = input.read(buffer);
			output.write(buffer, 0, size);
			}
			output.close();
			input.close();
		} catch (IOException ex) {
			Logger.getLogger(ExamenServlet.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				input.close();
			} catch (IOException ex) {
				Logger.getLogger(ExamenServlet.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

}
