
package Modelo;

import java.util.ArrayList;

public class JExamen extends Examen
{
	private ArrayList<JPregunta>preguntas;

	/**
	 * @return the preguntas
	 */
	public ArrayList<JPregunta> getJPreguntas() {
		return preguntas;
	}

	/**
	 * @param preguntas the preguntas to set
	 */
	public void setJPreguntas(ArrayList<JPregunta> preguntas) {
		this.preguntas = preguntas;
	}
	public void addJPreguntas(JPregunta pregunta) {
		this.preguntas.add(pregunta);
	}
	
}
