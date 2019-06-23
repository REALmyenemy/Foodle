package Controlador;

import Modelo.Alumno;
import Modelo.Examen;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ExamenController
{
	private static Conectar c=new Conectar();
	
	public static ArrayList<Examen> examenesPendientes(Alumno alumno)
	{
		String al=alumno.getId();
		try
		{
			c.ejecutar("select * from examenes where materia in "
						+ "(select materia from matriculas where alumno="+al+")"
					+ " and id not in "
						+ "(select examen from instanciaexamen where alumno="+al+")");
			ResultSet rst=c.getRset();
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
	
}
