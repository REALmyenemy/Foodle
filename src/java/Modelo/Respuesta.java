package Modelo;

import java.io.Serializable;

public class Respuesta implements Serializable
{
	private int id;
	private int examen;
	private int pregunta;
	private String texto;
	
	private float valorSelect;
	private float valorNoSelect;

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
	 * @return the texto
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * @param texto the texto to set
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}

	/**
	 * @return the valorSelect
	 */
	public float getValorSelect() {
		return valorSelect;
	}

	/**
	 * @param valorSelect the valorSelect to set
	 */
	public void setValorSelect(float valorSelect) {
		this.valorSelect = valorSelect;
	}

	/**
	 * @return the valorNoSelect
	 */
	public float getValorNoSelect() {
		return valorNoSelect;
	}

	/**
	 * @param valorNoSelect the valorNoSelect to set
	 */
	public void setValorNoSelect(float valorNoSelect) {
		this.valorNoSelect = valorNoSelect;
	}
}
