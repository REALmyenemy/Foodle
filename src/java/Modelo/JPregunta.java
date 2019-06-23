package Modelo;

import java.util.ArrayList;
import javax.servlet.http.Part;

public class JPregunta extends Pregunta
{
	
	private Part imagen;
	private ArrayList<Respuesta> srespuestas=new ArrayList();

	public Part getImagen() {
		return imagen;
	}

	public void setImagen(Part imagen) {
		this.imagen = imagen;
	}

	/**
	 * @return the srespuestas
	 */
	public ArrayList<Respuesta> getSrespuestas() {
		return srespuestas;
	}

	/**
	 * @param srespuestas the srespuestas to set
	 */
	public void addRespuestas(Respuesta respuesta) {
		this.srespuestas.add(respuesta);
		
	}
	public void setSrespuestas(ArrayList<Respuesta> srespuestas) {
		this.srespuestas = srespuestas;
	}

}
