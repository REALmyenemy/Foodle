package Controlador;

import Modelo.Materia;
import Modelo.Profesor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MateriasController
{
	private static Conectar c=new Conectar();
	
	public boolean insertarMateria(String materia,int creador,String id)
	{
		try {
			c.lanzar("insert into materias values ('"+id+"','"+materia+"',"+creador+")");
			return true;
		} catch (SQLException ex) {
			return false;
		}
	}
	
	public boolean matriculaAlumno(int alumno,String materia)
	{
		try {
			c.lanzar("insert into matricula values ("+alumno+",'"+materia+"')");
			return true;
		} catch (SQLException ex) {
			return false;
		}
	}
	
	
	public static ArrayList<Materia> getMaterias() throws SQLException
	{
		
		ArrayList<Materia> materias=new ArrayList();
		c.ejecutar("select * from materias where creador="+id);
		ResultSet rs, rst=c.getRset();
		Materia aux;
		while(rst.next())
		{
			aux=new Materia();
			aux.setCreador(id);
			aux.setNombre(rst.getString("nombre"));
			aux.setId(rst.getString("id"));			
			materias.add(aux);			
		}
		rst.close();
		return materias;
	}
	

}
