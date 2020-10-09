package logica;

public class Reglas {
	
	private Tablero tablero;
	
	public Reglas(Tablero tablero) {
		this.tablero=tablero;
	}
	
	private boolean esGanadorEnLaFila(int i, Jugador jugador) {
		boolean resultado = true;
		for (int j = 0; j < 3; j++) {
			resultado = resultado && tablero.estaLaFichaEnPosicion(jugador.getPieza(), i, j);
		}
		return resultado;
	}

	private boolean esGanadorEnLaColumna(int i, Jugador jugador) {
		boolean resultado = true;
		for (int j = 0; j < 3; j++) {
			resultado = resultado && tablero.estaLaFichaEnPosicion(jugador.getPieza(), j, i);
		}
		return resultado;
	}

	private boolean esGanadorEnLaDiagonaIzquierda(Jugador jugador, int despl) {
		boolean resultado = true;
		for (int j = 0; j < 3; j++) {
			resultado = resultado && tablero.estaLaFichaEnPosicion(jugador.getPieza(), (j + despl) % 3, j);
		}
		return resultado;
	}

	private boolean esGanadorEnLaDiagonaDerecha(Jugador jugador, int despl) {
		boolean resultado = true;
		for (int j = 0; j < 3; j++) {
			resultado = resultado && tablero.estaLaFichaEnPosicion(jugador.getPieza(), (j + despl) % 3, 2 - j);
		}
		return resultado;
	}

	public String getGanador(Jugador jugador) { 

		boolean result = false;
		for (int i = 0; i < 3; i++) {
			result = result || esGanadorEnLaFila(i, jugador);
			result = result || esGanadorEnLaColumna(i, jugador);
			result = result || esGanadorEnLaDiagonaIzquierda(jugador, i);
			result = result || esGanadorEnLaDiagonaDerecha(jugador, i);
		}

		if (result) {
			return jugador.getPieza();
		}
		return "";

	}

	// Si no hay ganador en la fila ni en la columna entonces hay un empate porque
	// ningun jugador logro completar la fila y la columna.
	public boolean hayEmpate(Jugador jugador, Jugador otroJugador) {
		return tablero.estaCompleto() && getGanador(jugador)=="" && getGanador(otroJugador)=="";
	}
}
