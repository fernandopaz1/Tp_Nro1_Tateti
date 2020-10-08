package visual;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class VentanaFinal {

	private javax.swing.JLabel titulo;
	private JPanel panelInicial;
	private JPanel panelFinal;
	private JPanel panelDeJuego;
	private VentanaDeJuego ventanaDeJuego;
	private JLabel fotoGanadora;
	
	public VentanaFinal(JPanel panelFinal, JPanel panelDeJuego, JPanel panelInicial, VentanaDeJuego ventanaDeJuego) {
		this.panelInicial=panelInicial;
		this.panelDeJuego = panelDeJuego;
		this.panelFinal = panelFinal;
		this.titulo = new javax.swing.JLabel();
		this.ventanaDeJuego=ventanaDeJuego;
	}

	public void initialize() {
		
		
		titulo.setVerticalAlignment(SwingConstants.BOTTOM);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setForeground(new java.awt.Color(255, 69, 0));
		titulo.setFont(new java.awt.Font("Showcard Gothic", java.awt.Font.PLAIN, 28));
		titulo.setBounds(20, 22, 386, 48);
		panelFinal.add(titulo);
		panelFinal.setBackground(new java.awt.Color(244, 164, 96));

		panelFinal.setVisible(false);
		
		fotoGanadora = new JLabel("");
		fotoGanadora.setBounds(185, 76, 63, 48);
		fotoGanadora.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelFinal.add(fotoGanadora);

		JButton botonMenu = new JButton("\u00A1Volver al menu!");
		botonMenu.setForeground(new java.awt.Color(255, 99, 71));
		botonMenu.setFont(new java.awt.Font("Showcard Gothic", java.awt.Font.PLAIN, 16));
		botonMenu.setBackground(new java.awt.Color(240, 230, 140));
		botonMenu.setBounds(128, 190, 180, 48);
		panelFinal.add(botonMenu);
		
		botonMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelFinal.setVisible(false);
				panelInicial.setVisible(true);
				
			}
		});
		
		JButton botonJugarOtraVez = new JButton("\u00A1Nueva ronda!");
		botonJugarOtraVez.setForeground(new java.awt.Color(255, 99, 71));
		botonJugarOtraVez.setFont(new java.awt.Font("Showcard Gothic", java.awt.Font.PLAIN, 16));
		botonJugarOtraVez.setBackground(new java.awt.Color(240, 230, 140));
		botonJugarOtraVez.setBounds(128, 140, 180, 48);
		panelFinal.add(botonJugarOtraVez);
		
		botonJugarOtraVez.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelFinal.setVisible(false);
				panelDeJuego.setVisible(true);
			}
		});
	}

	public void setMensaje(String mensaje) {
		System.out.println("El contenido del titulo es: "+titulo.getText());
		titulo.setText(mensaje);
	}
	
	public void getTitulo() {
		System.out.println(titulo.getText());
	}

	public void mostrarVentana() {
		this.panelFinal.setVisible(true);
		this.panelDeJuego.setVisible(false);

	}
	
	public void mostrarFotoGanador(ImageIcon imagen) {
		fotoGanadora.setIcon(imagen);
	}

}
