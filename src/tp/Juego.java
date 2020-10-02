package tp;

public class Juego {

	Tablero tablero;
	Jugador jugador1;
	Jugador jugador2;
	
	boolean turno;
	
	
	public Juego() {
	
		this.tablero = new Tablero();
		this.jugador1 = new Jugador("fulanito", "X");
		this.jugador2 = new Jugador("menganito", "O");
		
		turno= true;
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

		tablero.agregar(posicion1, posicion2, this.jugadorActual());
		
		if (!tablero.estaOcupado(posicion1, posicion2) == false ) {
			this.cambiarTurno();
		}
		
	}
	
//	public void hayGanador() {
//		
//		if (tablero.hayGanador(this.jugadorActual())
//				
//	}
	
	
	
}
