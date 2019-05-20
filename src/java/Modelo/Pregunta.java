package Modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Pregunta implements Serializable
{
	private int id;
	private int examen;
	private String pregunta;
	private String dirImagen;
	private ArrayList<Respuesta> respuestas = new ArrayList<>();

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the examen
	 */
	public int getExamen() {
		return examen;
	}

	/**
	 * @param examen the examen to set
	 */
	public void setExamen(int examen) {
		this.examen = examen;
	}

	/**
	 * @return the pregunta
	 */
	public String getPregunta() {
		return pregunta;
	}

	/**
	 * @param pregunta the pregunta to set
	 */
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	/**
	 * @return the dirImagen
	 */
	public String getDirImagen() {
		return dirImagen;
	}

	/**
	 * @param dirImagen the dirImagen to set
	 */
	public void setDirImagen(String dirImagen) {
		this.dirImagen = dirImagen;
	}

	/**
	 * @return the respuestas
	 */
	public ArrayList<Respuesta> getRespuestas() {
		return respuestas;
	}

	/**
	 * @param respuestas the respuestas to set
	 */
	public void setRespuestas(ArrayList<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}
	
}
