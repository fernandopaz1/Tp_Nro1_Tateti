package tp;


public class Tablero {

    String [] [] tablero;

    public Tablero() {

        tablero = new String [3] [3]; // preg a grupo si le parece hardcodear el tablero a un 3x3 ya q estamos haciendo un tateti
                                // pq se me hace q queda feo hacer un new tablero y tener q ponerle las dimensiones 
    }

    public boolean estaOcupado(int posicion1, int posicion2) {
        if (tablero[posicion1][posicion2].equals("x") ||  tablero[posicion1][posicion2].equals("o")) {
            return true;
                    }
        return false;
    }

    public void agregar(int posicion1,int posicion2, Jugador jugador) { // la posicion tiene q ser un par de numeros pq tengo q comparar la fila y la columna POR AHORA
        if (estaOcupado(posicion1, posicion2) == false) {
             tablero[posicion1][posicion2] = jugador.getPieza(); 
            }
        }


    public String hayGanador () {
        return "x";
    }

    public void vaciar(){
        tablero = new String [3] [3];
        return;
    }
}
