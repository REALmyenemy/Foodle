package Controlador;

import Modelo.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;
import javax.servlet.http.HttpServletRequest;



public class UsuariosController
{
	private static Conectar c=new Conectar();


	public String conectar(Usuario usu)
	{
		
		return conectar(usu.getId(),usu.getPassword());
	}
	
	public String conectar(String usuario, String pass)
	{
		try {
			c.ejecutar("select password from usuarios where id='"+usuario+"'");
			ResultSet rst=c.getRset();
			if(rst.next())
			{
				String dbp=rst.getString(1);

//				if (pass.compareTo(dbp)==0||BCrypt.checkpw(pass, dbp))
				if (pass.compareTo(dbp)==0||1==2)
				{
					c.getRset().close();
					return usuario;
				}
				/*
					https://www.baeldung.com/java-password-hashing
					https://www.guru99.com/jsp-example.html
					https://stackoverflow.com/questions/36480375/whats-the-java-equivalent-for-phps-password-hash-and-password-verify
				*/
			}
		} catch (SQLException ex) {
			Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}
	
	public static boolean esProfesor(String usuario)
	{
		
		try {
			c.ejecutar("select usuario from profesores where usuario='"+usuario+"'");
			ResultSet rst=c.getRset();
			if(rst.next())
			{
				return true;
			}
			
		} catch (SQLException ex) {
			Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}
	
	public static boolean esAlumno(String usuario)
	{
		
		try {
			c.ejecutar("select usuario from alumnos where usuario='"+usuario+"'");
			ResultSet rst=c.getRset();
			if(rst.next())
			{
				return true;
			}
			
		} catch (SQLException ex) {
			Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}
	
	public Alumno crearAlumno(String alumno)
	{
		try {
			c.ejecutar("select * from alumnos where usuario='"+alumno+"'");
			ResultSet rst=c.getRset();
			if(rst.next())
			{
				Usuario ual=new Usuario(alumno,"");
//				updateSeen(alumno);
				Alumno al=new Alumno(rst.getInt("id"),ual,rst.getInt("edad"),rst.getString("curso"));
				return al;
			}
		} catch (SQLException ex) {
			Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}
	
	public Profesor crearProfesor(String profesor)
	{
		try {
			c.ejecutar("select * from profesores where usuario='"+profesor+"'");
			ResultSet rst=c.getRset();
			if(rst.next())
			{
				Usuario upr=new Usuario(profesor,"");
				Profesor pro=new Profesor(rst.getInt("id"),upr,rst.getDate("fechacontrato"));
				return pro;
			}
		} catch (SQLException ex) {
			Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}
	
	public static ArrayList<Alumno> getAlumnos() throws SQLException
	{
		Conectar con=new Conectar();
		ArrayList<Alumno> alumnos=new ArrayList();
		c.ejecutar("select * from alumnos");
		ResultSet rs, rst=c.getRset();
		Alumno aux;
		while(rst.next())
		{
			aux=new Alumno();
			aux.setId(rst.getString("usuario"));
			con.ejecutar("select * from usuarios where id='"+aux.getId()+"'");
			rs=con.getRset();
			rs.next();
			aux.setDescripcion(rs.getString("descripcion"));
			aux.setNombre(rs.getString("nombre"));
			aux.setLast_seen(rs.getDate("last_seen"));
			aux.setNumero(rst.getInt("id"));
			aux.setCurso(rst.getString("curso"));
			aux.setEdad(rst.getInt("edad"));
			alumnos.add(aux);
			rs.close();
		}
		rst.close();
		return alumnos;
	}
	
	static void altaAlumno(HttpServletRequest request) throws SQLException
	{
		c.ejecutar("insert into usuarios values('"+
			request.getParameter("login")+"','"+
			request.getParameter("pass")+"','"+
			request.getParameter("name")+"','"+
			request.getParameter("desc")+"','"+
			new java.sql.Date(new java.util.Date().getTime())+
		"')");
		
		c.ejecutar ("insert into alumnos values ('"
			+ request.getParameter("login")+"',"
			+ request.getParameter("edad")+",'"
			+ request.getParameter("login")+"','"
			+ "')");
	}
	
	
	private void updateSeen(String usuario)
	{
		
//		c.ejecutar("update usuarios set last_seen='"++"' where id='"+usuario+"'");
	}
}
