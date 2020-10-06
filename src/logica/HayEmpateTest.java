package logica;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class HayEmpateTest {
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
	public void testNoHayEmpate() {
		tablero.agregar(0, 0, jugador1);
		tablero.agregar(1, 2, jugador2);
		tablero.agregar(0, 1, jugador1);
		tablero.agregar(1, 0, jugador2);
		tablero.agregar(0, 2, jugador1);
		tablero.agregar(1, 1, jugador2);
		tablero.agregar(2, 1, jugador1);
		
		assertFalse(tablero.hayEmpate(jugador1, jugador2));
	}
	
	@Test
	public void testHayEmpate() {
		tablero.agregar(0, 0, jugador1);
		tablero.agregar(0, 2, jugador2);
		tablero.agregar(0, 1, jugador1);
		tablero.agregar(1, 0, jugador2);
		tablero.agregar(1, 2, jugador1);
		tablero.agregar(1, 1, jugador2);
		tablero.agregar(2, 1, jugador1);
		tablero.agregar(2, 1, jugador2);
		
		assertTrue(tablero.hayEmpate(jugador1, jugador2));
	}
	
	@Test
	public void testHayEmpateTiro() {
		tablero.agregar(0, 0, jugador1);
		tablero.agregar(0, 2, jugador2);
		tablero.agregar(0, 1, jugador1);
		tablero.agregar(1, 0, jugador2);
		tablero.agregar(1, 2, jugador1);
		tablero.agregar(1, 1, jugador2);
		tablero.agregar(2, 1, jugador1);
		tablero.agregar(2, 1, jugador2);
		
		assertTrue(tablero.hayEmpate(jugador1, jugador2));
	}
	
	


}
