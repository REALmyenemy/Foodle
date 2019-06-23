package Modelo;

import java.util.ArrayList;

public class Examen
{
	private int id;
	private String materia;
	private boolean desordenar;
	private ArrayList<Pregunta>preguntas=new ArrayList<>();

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	public boolean getDesordenar()
	{
		return desordenar;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the materia
	 */
	public String getMateria() {
		return materia;
	}

	/**
	 * @param materia the materia to set
	 */
	public void setMateria(String materia) {
		this.materia = materia;
	}

	/**
	 * @return the preguntas
	 */
	public ArrayList<Pregunta> getPreguntas() {
		return preguntas;
	}

	/**
	 * @param preguntas the preguntas to set
	 */
	public void setPreguntas(ArrayList<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public void setDesordenar(boolean aBoolean) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}
