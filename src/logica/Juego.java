package logica;

import javax.swing.ImageIcon;

public class Juego {

	private Tablero tablero;
	private Jugador jugador1;
	private Jugador jugador2;
	private Reglas reglas;
	private boolean turno;
	private int turnoNro;

	public Juego() {

		this.tablero = new Tablero();
		this.reglas = new Reglas(tablero);
		this.jugador1 = new Jugador("", "X");
		this.jugador2 = new Jugador("", "O");
		turno = true;
		turnoNro=0;
	}

	public Jugador getJugador1() {
		return jugador1;
	}

	public Jugador getJugador2() {
		return jugador2;
	}

	public Jugador jugadorActual() {
		if (turno == true) {
			return jugador1;
		}
		return jugador2;

	}

	public void cambiarTurno() {
		if (turno)
			turno = false;
		else
			turno = true;
	}

	public void guardarMovimiento(int posicion1, int posicion2) {

		if (!tablero.estaOcupado(posicion1, posicion2)) {
			tablero.agregar(posicion1, posicion2, this.jugadorActual());
			turnoNro++;
		}
	}

	public void cambiarNombreJugadores(String nombre1,String nombre2) {

		jugador1.setNombre(nombre1);
		jugador2.setNombre(nombre2);

	}

	

	public String hayGanador() {
		String ganador = reglas.getGanador(jugadorActual());
		if (!ganador.equals("")) {
			return "EL GANADOR ES : " + jugadorActual().getNombre();
		}
		this.cambiarTurno();
		return "";
	}

	public boolean hayEmpate() {
		return reglas.hayEmpate(jugador1, jugador2);
	}

	public void tableroNuevo() {
		tablero.vaciar();
	}

	public void setImagenJugador(ImageIcon imagen) {
		jugadorActual().setImagenJugador(imagen);
		cambiarTurno();

	}

	public void setImagenJugador2(ImageIcon imagen2) {
		jugador2.setImagenJugador(imagen2);

	}
	
	
	public int getNroDeTurno() {
		return turnoNro;
	}
	public void resetTurno() {
		turnoNro=0;
	}
	
	

	private boolean tienenNombresDistintos() {
		return !jugador1.getNombre().equals(jugador2.getNombre());
	}

	private boolean tienenPocasLetras() {
		return jugador1.getNombre().length() <= 1 || jugador2.getNombre().length() <= 1;
	}
	
	private boolean tienenMuchasLetras() {
		return jugador1.getNombre().length() > 6 || jugador2.getNombre().length() > 6;
	}
	
	public String sonNombresValidos() {
		if(tienenPocasLetras()) {
			return "Todos los nombres deben tener mas de una letra! ";
		}
		if(tienenMuchasLetras()) {
			return "Todos los nombres deben tener menos de 6 letras ! ";
		}
		if(!tienenNombresDistintos()) {
			return "Los nombres deben ser distinos ! ";
		}
		return "";
	}
	
}
