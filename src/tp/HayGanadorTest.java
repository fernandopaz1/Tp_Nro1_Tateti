package tp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HayGanadorTest {

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
	public void testHayGanadorDiagonalIzquierda() {
		tablero.agregar(0, 0, jugador1);
		tablero.agregar(1, 1, jugador1);
		tablero.agregar(2, 2, jugador1);
		assertEquals("X", tablero.hayGanador(jugador1)); // cambiar nombre de hayGanador() parece booleano
	}

	@Test
	public void testDiagonaDerecha() {
		tablero.agregar(0, 2, jugador1);
		tablero.agregar(1, 1, jugador1);
		tablero.agregar(2, 0, jugador1);
		assertEquals(tablero.hayGanador(jugador1), "X"); // cambiar nombre de hayGanador() parece booleano

	}

	@Test
	public void testHayGanadorFila1() {
		tablero.agregar(0, 0, jugador2);
		tablero.agregar(0, 1, jugador2);
		tablero.agregar(0, 2, jugador2);
		assertEquals(tablero.hayGanador(jugador2), "O"); // cambiar nombre de hayGanador() parece booleano
	}

	@Test
	public void testHayGanadorFila2() {
		tablero.agregar(1, 0, jugador1);
		tablero.agregar(1, 1, jugador1);
		tablero.agregar(1, 2, jugador1);
		assertEquals(tablero.hayGanador(jugador1), "X"); // cambiar nombre de hayGanador() parece booleano

	}

	@Test
	public void testHayGanadorFila3() {
		tablero.agregar(2, 0, jugador1);
		tablero.agregar(2, 1, jugador1);
		tablero.agregar(2, 2, jugador1);
		assertEquals(tablero.hayGanador(jugador1), "X"); // cambiar nombre de hayGanador() parece booleano

	}

	@Test
	public void testHayGanadorColumna1() {
		tablero.agregar(0, 0, jugador1);
		tablero.agregar(1, 0, jugador1);
		tablero.agregar(2, 0, jugador1);
		assertEquals(tablero.hayGanador(jugador1), "X"); // cambiar nombre de hayGanador() parece booleano

	}

	@Test
	public void testHayGanadorColumna2() {
		tablero.agregar(0, 1, jugador1);
		tablero.agregar(1, 1, jugador1);
		tablero.agregar(2, 1, jugador1);
		assertEquals(tablero.hayGanador(jugador1), "X"); // cambiar nombre de hayGanador() parece booleano

	}

	@Test
	public void testHayGanadorColumna3() {
		tablero.agregar(0, 2, jugador1);
		tablero.agregar(1, 2, jugador1);
		tablero.agregar(2, 2, jugador1);
		assertEquals(tablero.hayGanador(jugador1), "X"); // cambiar nombre de hayGanador() parece booleano

	}

	@Test
	public void testTableroVacio() {

		assertEquals("No hay ganador", tablero.hayGanador(jugador1));
	}

	@Test
	public void testNoHayGanador() {

		tablero.agregar(0, 2, jugador1);
		tablero.agregar(1, 2, jugador2);

		assertEquals("No hay ganador", tablero.hayGanador(jugador1));
	}

	@Test
	public void testDiagonalMixta() {
		tablero.agregar(0, 0, jugador1);
		tablero.agregar(1, 1, jugador2);
		tablero.agregar(2, 2, jugador1);
		assertEquals("No hay ganador", tablero.hayGanador(jugador1));

	}
	
	// Mover a clase hayaGanadorToroidalTest

}
