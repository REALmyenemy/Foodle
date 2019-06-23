package Controlador;

import Modelo.*;
import java.io.File;
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
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher;		
		if (request.getParameter("submit").toLowerCase().compareTo("agregar pregunta")==0)
		{
			crearPregunta(request);
			dispatcher= getServletContext().getRequestDispatcher("/altaExamen.jsp");
		}
		else if (request.getParameter("submit").toLowerCase().compareTo("crear nuevo ex&aacute;men")==0||request.getParameter("submit").toLowerCase().compareTo("crear nuevo exámen")==0)
		{
			crearExamen(request);
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
	

	@Override
	public String getServletInfo() {
		return "Short description";
	}
	
	
	private int existeONo(int index, HttpServletRequest request)
	{
		String a;
		try
		{
			if (request.getParameter("respuesta"+index).compareTo("")==0)
				return index;
			else
			{
				return existeONo(index+1,request);
			}
		}
		catch (Exception e)
		{
			return index;
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
		request.getSession(false).setAttribute("preguntas", preguntas);
	}
	private void crearExamen(HttpServletRequest request)
	{
		Conectar c= new Conectar();
		
		try {
			String desordenar=request.getParameter("desordenar")!=null ? "true":"false";
			c.lanzar("insert into examenes values ((select count(*) from examenes as e),'"+request.getParameter("materia")+"',"+desordenar+")");
			
			c.ejecutar("select id from examenes");
			ResultSet rst=c.getRset();
			rst.next();
			
			ArrayList<JPregunta> preguntas=(ArrayList<JPregunta>)request.getSession(false).getAttribute("preguntas");
			int examen=rst.getInt(1);
			
			new File(getServletContext().getRealPath("/")+examen).mkdir();

			for (int i=0;i<preguntas.size();i++)
			{
				JPregunta pregunta=preguntas.get(i);
				
				if (pregunta.getImagen()!=null)
					pregunta.setDirImagen(getServletContext().getRealPath("/")+examen+"/"+pregunta.getImagen().getSubmittedFileName());
				else
					pregunta.setDirImagen("");

				c.lanzar("insert into preguntas values ((select count(*) from preguntas as p where examen="+examen+"),"+examen+",'"+pregunta.getPregunta()+"','"+pregunta.getDirImagen()+"',"+pregunta.getSrespuestas().size()+")");
				
				ArrayList<Respuesta> respuestas=pregunta.getSrespuestas();
				for (int j=0; j<respuestas.size();j++)
				{
					
					Respuesta r=respuestas.get(j);
					
					c.lanzar("insert into respuestas values((select count(*) from respuestas as r where examen="+examen+" and pregunta="+i+"),"+examen+","+i+",'"+r.getTexto()+"',"+r.getValorSelect()+","+r.getValorNoSelect()+")");
					System.out.println("qqqqqqqqqqqqqqqqqqqqq");
				}
				if (pregunta.getDirImagen()!="")
					procesarImagen(pregunta);
			}

			request.getSession(false).setAttribute("preguntas",null);

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
