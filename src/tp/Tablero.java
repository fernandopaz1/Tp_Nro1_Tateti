package tp;


public class Tablero {

	String [] tablero;

	public Tablero(String []  tablero) {
		
		this.tablero = tablero;
	}
	
	
	public void agregar(int posicion, Jugador jugador) {
		
		
	}
	
	public boolean estaOcupado(int posicion) {
		return true;
	}
	
	public String hayGanador () {
		return "x";
	}
}
