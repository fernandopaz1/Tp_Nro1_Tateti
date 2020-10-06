package logica;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
	

public class AgregarPiezaTest {

	Tablero tablero;
	Jugador jugador1;
	Jugador jugador2;

	@Before
	public void setUp() throws Exception {
		tablero = new Tablero();
		jugador1 = new Jugador("pepe", "X");
		jugador2 = new Jugador("pepe2", "O");

	}

	@Test(expected = IllegalArgumentException.class)
	public void testEstaOcupadoFueraDelTablero() {
		tablero.estaOcupado(3, 3); // Fuera del tablero podemos pensar que esta ocupado?
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEstaOcupadoFueraDelTableroIndiceNegativo() {
		tablero.estaOcupado(-3, 3); // Fuera del tablero podemos pensar que esta ocupado?
	}
	
	@Test
	public void testNoEstaOcupado() {
		assertFalse(tablero.estaOcupado(1, 1)); // se crea vacio (no se si poner todos)
	}

	@Test
	public void testEstaOcupado() {

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
		tablero.agregar(0, 0, jugador1);
		tablero.vaciar();
		assertEquals(null,tablero.tablero[0][0]);
	}

}
