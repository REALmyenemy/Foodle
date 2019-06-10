package Controlador;

import Modelo.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


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
				System.out.println(dbp+" "+usuario);
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
			c.ejecutar("select usuario from profesores where usuario="+usuario);
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
				Alumno al=new Alumno(rst.getInt("id"),ual,rst.getInt("edad"),rst.getString(alumno));
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
			c.ejecutar("select * from profesores where usuario="+profesor);
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
}
