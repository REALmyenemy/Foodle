package Controlador;
import Modelo.Materia;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;

public class MateriaController
{
	private Conectar c=new Conectar();
	
	public ArrayList getMaterias()
	{
		ArrayList<Materia> materias=null;
		Materia aux;
		try {
			c.ejecutar("select * from materias");
			ResultSet rst=c.getRset();
			while(rst.next())
			{
				aux=new Materia();
				aux.setId(rst.getInt("id"));
				aux.setCreador(rst.getInt("creador"));
				aux.setNombre(rst.getString("nombre"));
			}
			
		} catch (SQLException ex) {
			Logger.getLogger(MateriaController.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return materias;
	}
	
	public ArrayList getMaterias(int creador)
	{
		ArrayList<Materia> materias=null;
		Materia aux;
		try {
			c.ejecutar("select * from materias where creador="+creador);
			ResultSet rst=c.getRset();
			while(rst.next())
			{
				aux=new Materia();
				aux.setId(rst.getInt("id"));
				aux.setCreador(creador);
				aux.setNombre(rst.getString("nombre"));
			}
			
		} catch (SQLException ex) {
			Logger.getLogger(MateriaController.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		
		return materias;
	}
	
	public Materia getMateria(int id)
	{
		Materia resultado=null;
		try {
			c.ejecutar("select * from materias where id="+id);
			ResultSet rst=c.getRset();
			if(rst.next())
			{
				resultado=new Materia();
				resultado.setId(id);
				resultado.setCreador(rst.getInt("creador"));
				resultado.setNombre(rst.getString("nombre"));
			}
			
		} catch (SQLException ex) {
			Logger.getLogger(MateriaController.class.getName()).log(Level.SEVERE, null, ex);
		}
		return resultado;
	}
}
