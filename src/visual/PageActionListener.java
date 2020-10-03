package visual;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import tp.Juego;

public class PageActionListener implements ActionListener{

		   private Juego  juego;
           private int i;
           private int j;
           private VentanaFinal ventanaFinal;
           
           public PageActionListener(int i, int j,Juego juego, VentanaFinal ventanaFinal) {
               this.i = i;
               this.j=j;
               this.juego=juego;
               this.ventanaFinal = ventanaFinal;
               
           }

           public void actionPerformed(ActionEvent e) {
           	
			
			JButton clicked = (JButton) e.getSource();
			if (clicked.getText() == "") {
				clicked.setText(juego.jugadorActual().getPieza());
				juego.guardarMovimiento(i,j);
				String ganador = juego.hayGanador();
				ventanaFinal.setMensaje(ganador);
				if (ganador != "") {
					ventanaFinal.mostrarVentana();
				}
			}
			
			
			}
           
       }
       

