package Controlador;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MateriasController
{
	private static Conectar c=new Conectar();
	
	public void insertarMateria(String materia,int id)
	{
		try {
			c.lanzar("insert into materia values ('"+materia+"',"+id+")");
		} catch (SQLException ex) {
			Logger.getLogger(MateriasController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public boolean matriculaAlumno(int alumno,int materia)
	{
		try {
			c.lanzar("insert into matricula values ("+alumno+","+materia+")");
			return true;
		} catch (SQLException ex) {
			return false;
		}
	}
	

}
