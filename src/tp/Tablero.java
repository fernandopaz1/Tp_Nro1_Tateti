package tp;

public class Tablero {

	String[][] tablero;

	public Tablero() {

		tablero = new String[3][3]; // preg a grupo si le parece hardcodear el tablero a un 3x3 ya q estamos
									// haciendo un tateti
		// pq se me hace q queda feo hacer un new tablero y tener q ponerle las
		// dimensiones
	}

	private void indiceEnRango(int i) {
		if (i < 0)
			throw new IllegalArgumentException("No se permiten indices negativos: " + i);
		if (i >=3)
			throw new IllegalArgumentException("Indice fuera de rango: " + i);

	}

	public boolean estaOcupado(int posicion1, int posicion2) {
		indiceEnRango(posicion1);
		indiceEnRango(posicion2);
		if (tablero[posicion1][posicion2] != null) {
			return true;
		}
		return false;
	}

	public void agregar(int posicion1, int posicion2, Jugador jugador) {     // la posicion tiene q ser un par de numeros pq
																			// tengo q comparar la fila y la columna POR
																			// AHORA
		if (!estaOcupado(posicion1, posicion2)) {
			tablero[posicion1][posicion2] = jugador.getPieza();
		}
	}

	private boolean esGanadorEnLaFila(int i, Jugador jugador) {
		boolean resultado = true;
		for (int j = 0; j < 3; j++) {
			resultado = resultado && estaLaFichaEnPosicion(jugador.getPieza(), i, j);
		}
		return resultado;
	}

	private boolean esGanadorEnLaColumna(int i, Jugador jugador) {
		boolean resultado = true;
		for (int j = 0; j < 3; j++) {
			resultado = resultado && estaLaFichaEnPosicion(jugador.getPieza(), j, i);
		}
		return resultado;
	}

	private boolean esGanadorEnLaDiagonaIzquierda(Jugador jugador, int despl) {
		boolean resultado = true;
		for (int j = 0; j < 3; j++) {
			resultado = resultado && estaLaFichaEnPosicion(jugador.getPieza(), (j + despl) % 3, j);
		}
		return resultado;
	}

	private boolean esGanadorEnLaDiagonaDerecha(Jugador jugador, int despl) {
		boolean resultado = true;
		for (int j = 0; j < 3; j++) {
			resultado = resultado && estaLaFichaEnPosicion(jugador.getPieza(), (j + despl) % 3, 2 - j);
		}
		return resultado;
	}

	public String hayGanador(Jugador jugador) { 

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

	public boolean estaLaFichaEnPosicion(String ficha1, int i, int j) {
		return (ficha1.equals(tablero[i][j]));
	}

	public void vaciar() {
		tablero = new String[3][3];
		return;
	}
	
	
	// Si no hay ganador en la fila ni en la columna entonces hay un empate porque
	// ningun jugador logro completar la fila y la columna.
	public boolean hayEmpate(Jugador jugador, Jugador otroJugador) {
		boolean result = true;
		for (int i = 0; i < 3; i++) {
			result = result && (!esGanadorEnLaFila(i, jugador) && !esGanadorEnLaFila(i, otroJugador))
					&& (!esGanadorEnLaColumna(i, jugador) && !esGanadorEnLaColumna(i, otroJugador));
		}
		return result;
	}

}
