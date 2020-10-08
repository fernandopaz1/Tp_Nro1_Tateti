package logica;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Juego {

	Tablero tablero;
	Jugador jugador1;
	Jugador jugador2;
	String nombre1;
	
	
	boolean turno;
	
	
	public Juego() {
	
		this.tablero = new Tablero();
		this.jugador1 = new Jugador("", "X");
		this.jugador2 = new Jugador("", "O");
		
		turno= true;
	}
	public Jugador getJugador1() {
		return jugador1;
	}
	
	public Jugador getJugador2() {
		return jugador2;
	}
	
	public Jugador jugadorActual () {
		if (turno == true ) {
			return jugador1;
		}
			return jugador2;
	
	}
	
	public void cambiarTurno() {
		if (turno) 
			turno=false;
		else
			turno=true;
	}
	
	public void guardarMovimiento (int posicion1 , int posicion2) {

		
		
		if (!tablero.estaOcupado(posicion1, posicion2) ) {
			tablero.agregar(posicion1, posicion2, this.jugadorActual());
		}
	}
	
	public void cambiarNombreJugador1 (String nombre) {
		
	  jugador1.setNombre(nombre);
	  System.out.println(jugador1.getNombre());
	}
	
	public void cambiarNombreJugador2 (String nombre) {

		  jugador2.setNombre(nombre);
		  System.out.println (jugador2.getNombre());
	}

	public String hayGanador() {
		String ganador = tablero.getGanador(jugadorActual());
		if (!ganador.equals("")) {
			return "EL GANADOR ES : " + jugadorActual().getNombre() ;
		}
		this.cambiarTurno();
		return "";
	}
	
	public boolean hayEmpate() {
		return tablero.hayEmpate(jugador1, jugador2);
	}
	
	public void tableroNuevo() {
		tablero.vaciar();
	}
	
	public void setImagenJugador1(ImageIcon imagen1) {
		jugador1.setImagenJugador(imagen1);
		
	}
	
	public void setImagenJugador2(ImageIcon imagen2) {
		jugador2.setImagenJugador(imagen2);
		
	}
	
	
}
	
	

	
	
	

