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

		panelDeJuego.setBackground(new java.awt.Color(244, 164, 96));
		

		javax.swing.JLabel msj_jugador1_pieza = new javax.swing.JLabel();
		msj_jugador1_pieza.setForeground(new java.awt.Color(105, 105, 105));
		msj_jugador1_pieza.setFont(new java.awt.Font("Sitka Banner", java.awt.Font.PLAIN, 16));
		msj_jugador1_pieza.setBounds(25, 13, 200, 27);
		msj_jugador1_pieza.setText("X = " + juego.getJugador1().getNombre());
		panelDeJuego.add(msj_jugador1_pieza);
		
		javax.swing.JLabel msj_jugador2_pieza = new javax.swing.JLabel("O = ");
		msj_jugador2_pieza.setForeground(new java.awt.Color(105, 105, 105));
		msj_jugador2_pieza.setFont(new java.awt.Font("Sitka Banner", java.awt.Font.PLAIN, 16));
		msj_jugador2_pieza.setBounds(300, 13, 200, 27);
		msj_jugador2_pieza.setText("O = " + "jugador2");
		panelDeJuego.add(msj_jugador2_pieza);
		
		limpiarTablero();
	}

	public JButton crearBoton(int x, int y) {
		JButton boton = new JButton("");
		boton.setBounds(x, y, 60, 60);
		panelDeJuego.add(boton);

		return boton;
	}

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
				botones[i][j].addActionListener(new CapturadorDeClick(i, j, juego, ventanaFinal,this));
			}
		}

	}

	public void setVisible(boolean visibilidad) {
		limpiarTablero();
		this.panelDeJuego.setVisible(visibilidad);
	}

	public void limpiarTablero() {
		juego.tableroNuevo();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				botones[i][j].setText("");
			}
		}
	}

}
