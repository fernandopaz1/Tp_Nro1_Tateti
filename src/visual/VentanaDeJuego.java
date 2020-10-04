package visual;

import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JPanel;

import tp.Juego;

public class VentanaDeJuego {
	
	private JPanel panelDeJuego;
	private Juego juego;
	private VentanaFinal ventanaFinal;
	private JButton botones[][];
	
	public VentanaDeJuego(JPanel panelDeJuego,Juego juego,VentanaFinal ventanaFinal) {
		this.panelDeJuego=panelDeJuego;
		this.juego=juego;
		this.ventanaFinal=ventanaFinal;
		this.botones = new JButton[3][3];
		matrizBotones();
	}
	
	public void initialize() {
		panelDeJuego.setVisible(false);
		panelDeJuego.setBounds(0, 0, 434, 261);
		
		panelDeJuego.setBackground(SystemColor.menu);
	}
	
	
	public void matrizBotones() {
		panelDeJuego.setLayout(null);

		JButton boton00 = new JButton("");
		boton00.setBounds(120, 44, 60, 60);
		botones[0][0] = boton00;
		panelDeJuego.add(boton00);

		JButton boton01 = new JButton("");
		boton01.setBounds(190, 44, 60, 60);
		panelDeJuego.add(boton01);
		botones[0][1] = boton01;

		JButton boton02 = new JButton("");
		boton02.setBounds(260, 44, 60, 60);
		panelDeJuego.add(boton02);
		botones[0][2] = boton02;

		JButton boton10 = new JButton("");
		boton10.setBounds(120, 109, 60, 60);
		panelDeJuego.add(boton10);
		botones[1][0] = boton10;

		JButton boton11 = new JButton("");
		boton11.setBounds(190, 109, 60, 60);
		panelDeJuego.add(boton11);
		botones[1][1] = boton11;

		JButton boton12 = new JButton("");
		boton12.setBounds(260, 109, 60, 60);
		panelDeJuego.add(boton12);
		botones[1][2] = boton12;

		JButton boton20 = new JButton("");
		boton20.setBounds(120, 177, 60, 60);
		panelDeJuego.add(boton20);
		botones[2][0] = boton20;

		JButton boton21 = new JButton("");
		boton21.setBounds(190, 177, 60, 60);
		panelDeJuego.add(boton21);
		botones[2][1] = boton21;

		JButton boton22 = new JButton();
		boton22.setBounds(260, 177, 60, 60);
		panelDeJuego.add(boton22);
		botones[2][2] = boton22;

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
