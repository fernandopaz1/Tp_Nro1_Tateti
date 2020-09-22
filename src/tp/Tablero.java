package tp;


public class Tablero {

    String [] [] tablero;

    public Tablero() {

        tablero = new String [3] [3]; // preg a grupo si le parece hardcodear el tablero a un 3x3 ya q estamos haciendo un tateti
                                // pq se me hace q queda feo hacer un new tablero y tener q ponerle las dimensiones 
    }

    private void indiceEnRango(int i) {
    	if(i<0)
    		throw new IllegalArgumentException("No se permiten indices negativos: "+i);
    	if(i>=3)
    		throw new IllegalArgumentException("Indice fuera de rango: "+i);
    		
    } 
    
    public boolean estaOcupado(int posicion1, int posicion2) {
    	indiceEnRango(posicion1);
    	indiceEnRango(posicion2);
        if (tablero[posicion1][posicion2]!=null) {
            return true;
                    }
        return false;
    }

    public void agregar(int posicion1,int posicion2, Jugador jugador) { // la posicion tiene q ser un par de numeros pq tengo q comparar la fila y la columna POR AHORA
        if (estaOcupado(posicion1, posicion2) == false) {
             tablero[posicion1][posicion2] = jugador.getPieza(); 
            }
        }



    public String hayGanador (Jugador jugador) { 							// ---------------------> lo malo del algoritmo es q tiene muchos for :( pero casi nada de if  
		String ficha1 = jugador.getPieza();									//  					pq los otros q vi estan llenos de if. 
		
		boolean resultado1 = true ;
		boolean resultado2 = true;
		boolean resultado3 = true;
		boolean resultado4 = true;
		boolean resultado5 = true;
		boolean resultado6 = true;
		boolean resultado7 = true;
		boolean resultado8 = true;
		
		for (int j = 0; j <3; j ++ ) {
			resultado1 = resultado1 && esGanador(ficha1, j,0);      
			resultado2 = resultado2  && esGanador(ficha1, 0, j); 	 
			resultado3= resultado3 && esGanador(ficha1,j,j);
			resultado4 = resultado4 && esGanador(ficha1, j, 1);
			resultado5 = resultado5 && esGanador(ficha1, j, 2);
			resultado6 = resultado6 && esGanador(ficha1, 1, j);
			resultado7 = resultado7 && esGanador(ficha1, 2, j);
			resultado8 = resultado8 && esGanador(ficha1, j, 2-j);
			
			
		}
		
		if ( resultado1 == true || resultado2 == true || resultado3 == true) {
			return jugador.getPieza() ;
		}
		return " ";
		
	}

	public boolean esGanador(String ficha1, int i, int j ) {
		boolean resultado;
		if ( ficha1.equals(tablero[i] [j])) {
			resultado = true;
		}
		resultado = false;
		return resultado;
	}

  


    public void vaciar(){
        tablero = new String [3] [3];
        return;
    }
}
