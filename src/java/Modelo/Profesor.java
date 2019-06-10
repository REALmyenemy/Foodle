package Modelo;

import java.sql.Date;


public class Profesor extends Usuario
{
	private int numero;
	private Date fechaContrato;

	public Profesor(int numero, Usuario usu, Date fechaContrato) {
		this.numero=numero;
		this.nombre=usu.nombre;
		this.password=usu.password;
		this.fechaContrato=fechaContrato;		
	}

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return the fechaContrato
	 */
	public Date getFechaContrato() {
		return fechaContrato;
	}

	/**
	 * @param fechaContrato the fechaContrato to set
	 */
	public void setFechaContrato(Date fechaContrato) {
		this.fechaContrato = fechaContrato;
	}

}
