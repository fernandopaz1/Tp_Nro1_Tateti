package visual;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logica.Juego;

public class VentanaDeJuego extends ModeloDeVentana {

	private JPanel panelDeJuego;
	private Juego juego;
	private VentanaFinal ventanaFinal;
	private JButton botones[][];
	private JLabel labelJugador1;
	private JLabel labelJugador2;
	private JLabel labelTurno;

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

		Color colorJugador = new java.awt.Color(105, 105, 105);
		Font fontJugador = new java.awt.Font("Sitka Banner", java.awt.Font.PLAIN, 16);
		
		labelJugador1=createJLabel(panelDeJuego, "X = " + "jugador1", colorJugador, fontJugador, 25, 13, 200,
				27);
		labelJugador2=createJLabel(panelDeJuego, "O = " + "jugador2", colorJugador, fontJugador, 300, 13, 200,
				27);
		
		labelTurno=createJLabel(panelDeJuego, "Turno 0", colorJugador, fontJugador, 25, 200, 200,
				27);

		limpiarTablero();
	}


	public void matrizBotones() {
		panelDeJuego.setLayout(null);

		Color colorBotones = new Color(240, 230, 140);
		Font fuenteBotones = new Font("Showcard Gothic", Font.PLAIN, 33);
		int y = 44;
		int x = 120;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				botones[i][j] = createButton(panelDeJuego, "", null, fuenteBotones, colorBotones, x, y, 60, 60);
				x += 70;
			}
			y += 69;
			x = 120;
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				botones[i][j].addActionListener(new CapturadorDeClick(i, j, juego, ventanaFinal, this));
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
	
	public void refreshJugadorLabel() {
		String text1="X= "+juego.getJugador1().getNombre();
		String text2="O= "+juego.getJugador2().getNombre();
		labelJugador1.setText(text1);
		labelJugador2.setText(text2);
	}

	public void refreshTurnoLabel() {
		String turno="Turno " +juego.getNroDeTurno();
		labelTurno.setText(turno);
	}
}
