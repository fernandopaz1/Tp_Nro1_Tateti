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
          
           public PageActionListener(int i, int j,Juego juego) {
               this.i = i;
               this.j=j;
               this.juego=juego;
               
           }

           public void actionPerformed(ActionEvent e) {
           	
			
			JButton clicked = (JButton) e.getSource();
			if (clicked.getText() == "") {
				clicked.setText(juego.jugadorActual().getPieza());
				juego.guardarMovimiento(i,j);
			} 
			}
       }
       

