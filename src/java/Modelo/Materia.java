package Modelo;

import java.io.Serializable;


public class Materia implements Serializable
{
	private String id;
	private String nombre;
	private  int creador;


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.setId(id);
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the creador
	 */
	public int getCreador() {
		return creador;
	}

	/**
	 * @param creador the creador to set
	 */
	public void setCreador(int creador) {
		this.creador = creador;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
}
