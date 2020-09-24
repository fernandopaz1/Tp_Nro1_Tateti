package tp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SolucionesToroidalTest {

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
	public void testDiagonalIzquierda () {
		
		tablero.agregar(0, 0, jugador1);
		tablero.agregar(1, 2, jugador1);
		tablero.agregar(2, 1, jugador1);
		
		assertEquals(jugador1.getPieza(), tablero.hayGanador(jugador1));
	}
	
	@Test
	public void testDiagonalDerecha () {
		
		tablero.agregar(0, 2, jugador1);
		tablero.agregar(1, 0, jugador1);
		tablero.agregar(2, 1, jugador1);
		
		assertEquals(jugador1.getPieza(), tablero.hayGanador(jugador1));
	}
	
	
	@Test
	public void testMedioIzquierda () {
		
		tablero.agregar(0, 1, jugador1);
		tablero.agregar(1, 2, jugador1);
		tablero.agregar(2, 0, jugador1);
		
		assertEquals(jugador1.getPieza(), tablero.hayGanador(jugador1));
	}
	
	@Test
	public void testMedioDerecha () {
		
		tablero.agregar(0, 1, jugador1);
		tablero.agregar(1, 0, jugador1);
		tablero.agregar(2, 2, jugador1);
		
		assertEquals(jugador1.getPieza(), tablero.hayGanador(jugador1));
	}
	
	@Test
	public void testNoHayGanadorToroidal() {
		tablero.agregar(1, 1, jugador1);
		tablero.agregar(1, 0, jugador1);
		tablero.agregar(2, 2, jugador1);
		
		assertEquals("No hay ganador", tablero.hayGanador(jugador1));
	}
	
	

}
