package visual;

import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JPanel;

import logica.Juego;

public class VentanaDeJuego {

	private JPanel panelDeJuego;
	private Juego juego;
	private VentanaFinal ventanaFinal;
	private JButton botones[][];

	public VentanaDeJuego(JPanel panelDeJuego, Juego juego, VentanaFinal ventanaFinal) {
		this.panelDeJuego = panelDeJuego;
		this.juego = juego;
		this.ventanaFinal = ventanaFinal;
		this.botones = new JButton[3][3];
		matrizBotones();
	}

	public void initialize() {
		panelDeJuego.setVisible(false);
		panelDeJuego.setBounds(0, 0, 434, 261);

		panelDeJuego.setBackground(SystemColor.menu);
	}

	public JButton crearBoton(int x, int y) {
		JButton boton = new JButton("");
		boton.setBounds(x, y, 60, 60);
		panelDeJuego.add(boton);

		return boton;
	}

//	int y =  39 ;
//    int x =  107 ;
//    para ( int i =  0 ; i <  3 ; i ++ ) {
//        para ( int j =  0 ; j <  3 ; j ++ ) {
//            botones [i] [j] =  new  JButton ();
//            botones [i] [j] . setBounds (x, y, 60 , 60 );
//            marco . getContentPane () . agregar (botones [i] [j]);
//            x + =  65 ;
//        }
//        y + =  64 ;
//        x =  107 ;
//}

	public void matrizBotones() {
		panelDeJuego.setLayout(null);

		int y = 44;
		int x = 120;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				botones[i][j] = crearBoton(x, y);
				x += 70;
			}
			y += 69;
			x = 120;
		}
		
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				botones[i][j].addActionListener(new PageActionListener(i, j, juego, ventanaFinal));
			}
		}

	}

	public void setVisible(boolean visibilidad) {
		this.panelDeJuego.setVisible(visibilidad);
	}

	public void limpiarTableroVisual() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				botones[i][j].setText("");
			}
		}
	}

}
