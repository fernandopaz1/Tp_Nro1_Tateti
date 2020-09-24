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

}