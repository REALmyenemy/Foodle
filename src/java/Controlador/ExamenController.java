package Controlador;

import Modelo.Alumno;
import Modelo.Examen;
import Modelo.JExamen;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ExamenController
{
	private Conectar c=new Conectar();
	
	public ArrayList<Examen> examenesPendientes(Alumno alumno)
	{
		String usu=alumno.getId();
		try
		{
			c.ejecutar("select id from usuario where usuario='"+usu+"'");
			ResultSet rst=c.getRset();
			rst.next();
			int al=rst.getInt(1);
			c.ejecutar("select * from examenes where materia in "
						+ "(select materia from matriculas where alumno="+al+")"
					+ " and id not in "
						+ "(select examen from instanciaexamen where alumno="+al+")");
			
			ArrayList<Examen> examenes=new ArrayList();
			Examen aux;
			while (rst.next())
			{
				aux=new Examen();
				aux.setId(rst.getInt(1));
				aux.setMateria(rst.getString(2));
				aux.setDesordenar(rst.getBoolean(3));
				examenes.add(aux);
			}
			return examenes;
		}
		catch (Exception e)
		{
			return null;
		}
		
	}
	
	public JExamen traerExamen(int id)
	{
		
	}
	
}
