package Modelo;

public class Alumno extends Usuario
{
	private int numero;
	private int edad;
	private String curso;

	public Alumno()
	{
	}
	
	public Alumno(int numero)
	{
		this.numero=numero;
	}
	
	public Alumno(int numero, Usuario usu)
	{
		super(usu);
		this.numero=numero;
		
	}
	
	public Alumno(int numero,Usuario usu,int edad, String curso)
	{
		super(usu);
		this.numero=numero;
		this.edad=edad;
		this.curso=curso;
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
	 * @return the curso
	 */
	public String getCurso() {
		return curso;
	}

	/**
	 * @param curso the curso to set
	 */
	public void setCurso(String curso) {
		this.curso = curso;
	}

	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
}
