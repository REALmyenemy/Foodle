package Controlador;

import Modelo.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuariosController
{
	private Conectar c=new Conectar();
	public String conectar(Usuario usu)
	{
		
		return conectar(usu.getId(),usu.getPassword());
	}
	
	public String conectar(String usuario, String pass)
	{
		
		try {
			c.ejecutar("select password from usuarios");
			ResultSet rst=c.getRset();
			if(rst.next())
			{
				String dbp=rst.getString(1);
				if (pass.compareTo(dbp)==0||1==2)
				{
					c.getRset().close();
					return usuario;
				}
				/*
					https://www.baeldung.com/java-password-hashing
					https://www.guru99.com/jsp-example.html
				*/
			}
		} catch (SQLException ex) {
			Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}
	
	public boolean esProfesor(String usuario)
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
	
	public boolean esAlumno(String usuario)
	{
		
		try {
			c.ejecutar("select usuario from alumnos where usuario="+usuario);
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
	
}
