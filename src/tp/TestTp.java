package tp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tp.Tablero;
import tp.Jugador;

public class TestTp {

	Tablero tablero;
	Jugador jugador1;
	Jugador jugador2;

	@Before
	public void setUp() throws Exception {
		tablero = new Tablero();
		jugador1 = new Jugador("pepe", "X");
		jugador2 = new Jugador("pepe2", "O");

	}

	@Test
	public void testEstaOcupado() {

		assertTrue(tablero.estaOcupado(3, 3)); // Fuera del tablero podemos pensar que esta ocupado?

		assertFalse(tablero.estaOcupado(1, 1)); // se crea vacio (no se si poner todos)

		tablero.agregar(1, 1, jugador2);
		assertTrue(tablero.estaOcupado(1, 1)); // ocupo una posicion y debe devolver true

		tablero.agregar(1, 1, jugador1);
		assertTrue(tablero.estaOcupado(1, 1)); // sigue estando ocupado si tratan de jugar en la posicion misma
	}

	@Test
	public void testAgregar() {
		tablero.agregar(0, 0, jugador1);
		assertEquals(tablero.tablero[0][0], "X");

		tablero.agregar(1, 1, jugador2);
		assertEquals(tablero.tablero[1][1], "O");

		tablero.agregar(1, 1, jugador1);
		assertEquals(tablero.tablero[1][1], "O"); // No sobreescribe donde ya hay pieza
	}

	@Test
	public void vaciar() {
		//pendiente
	}
	
	
	@Test
	public void testHayGanador() {
		tablero.agregar(0, 0, jugador1);
		tablero.agregar(1, 1, jugador1);
		tablero.agregar(2, 2, jugador1);
		assertEquals(tablero.hayGanador(), "X"); // cambiar nombre de hayGanador() parece booleano

		tablero.vaciar();
		
		tablero.agregar(0, 1, jugador2);
		tablero.agregar(0, 2, jugador2);
		tablero.agregar(0, 3, jugador2);
		assertEquals(tablero.hayGanador(), "O"); // cambiar nombre de hayGanador() parece booleano
		
		tablero.vaciar();
		
		tablero.agregar(1, 1, jugador2);
		tablero.agregar(1, 2, jugador2);
		tablero.agregar(1, 3, jugador2);
		assertEquals(tablero.hayGanador(), "X"); // cambiar nombre de hayGanador() parece booleano
		
		tablero.vaciar();
	}

}