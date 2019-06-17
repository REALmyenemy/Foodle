package Modelo;

import java.io.Serializable;
import java.sql.Date;


public class Usuario implements Serializable
{
	protected String id="";
	protected String password="";
	protected String nombre="";
	protected String descripcion="";
	protected Date last_seen=new Date(new java.util.Date().getTime());
	
	
	public Usuario()
	{
		
	}
	
	public Usuario(Usuario usu)
	{
		this.id=usu.id;
		this.password=usu.password;
		this.nombre=usu.nombre;
		this.descripcion=usu.descripcion;
		this.last_seen=usu.last_seen;
	}
	
	public Usuario(String id, String password)
	{
		this.id=id;
		this.password=password;
	}
	
	public Usuario(String id, String password, String nombre, String Descripcion, Date last_seen)
	{
		this.id=id;
		this.password=password;
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.last_seen=last_seen;
	}
	
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the last_seen
	 */
	public Date getLast_seen() {
		return last_seen;
	}

	/**
	 * @param last_seen the last_seen to set
	 */
	public void setLast_seen(Date last_seen) {
		this.last_seen = last_seen;
	}
	
}
