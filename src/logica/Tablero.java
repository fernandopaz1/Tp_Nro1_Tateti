package logica;

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


	public boolean estaLaFichaEnPosicion(String ficha1, int i, int j) {
		return (ficha1.equals(tablero[i][j]));
	}

	public void vaciar() {
		tablero = new String[3][3];
		return;
	}
	
	public boolean estaCompleto(){
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(tablero[i][j] == null)
					return false;
			}
		}
		return true;
		
	}
	

}
