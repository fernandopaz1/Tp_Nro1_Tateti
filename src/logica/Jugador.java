package logica;

import javax.swing.ImageIcon;

public class Jugador {

	private String nombre;
	private String pieza;
	private ImageIcon foto;
	
	
	
	public Jugador(String nombre, String pieza) {
		this.nombre = nombre;
		this.pieza = pieza;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPieza() {
		return pieza;
	}

	public void setNombre(String nombre2) {
		nombre = nombre2;
		
	}
	public ImageIcon getImagenJugador() {
		return foto;
	}
	public void setImagenJugador(ImageIcon imagen) {
		foto=imagen;
	}
	

}