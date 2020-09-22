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


    public String hayGanador (Jugador jugador) {                             // ---------------------> lo malo del algoritmo es q tiene muchos for :frowning: pero casi nada de if
        String ficha1 = jugador.getPieza();                                    //                      pq los otros q vi estan llenos de if. 

        boolean resultado1 = false ;
        boolean resultado2 = false;
        boolean resultado3 = false;

        //recorro todas las columnas
        for (int i = 0; i <3; i ++) {
            if ( ficha1.equals(tablero[0] [i])) {
                resultado1 = true;
            }
            resultado1 = false;
        }
        // recorro todas las filas
        for (int j = 0; j <3; j ++ ) {
            if ( ficha1.equals(tablero[j] [0])) {
                resultado2 = true;
            }
            resultado2 = false;
        }
        // recorro la diagonal (0,0) (1,1) (2, 2) 
        for (int k = 0; k <3; k ++ ) {
            if ( ficha1.equals(tablero[k] [k])) {
                resultado3 = true;
            }
            resultado3 = false;
        }

        // falta verificar la otra diagonal

        if ( resultado1 == true | resultado2 == true | resultado3 == true) {
            return "El ganador es " + jugador.getPieza() ;
        }
        return "no hay ganador";

    }

    public void vaciar(){
        tablero = new String [3] [3];
        return;
    }
}
