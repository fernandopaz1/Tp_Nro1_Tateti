package tp;

public class Jugador {

	private String nombre;
	// foto
	private String pieza;

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

}