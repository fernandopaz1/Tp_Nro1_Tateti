package visual;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VentanaFinal {

	public javax.swing.JLabel titulo;
	public JPanel panelInicial;
	public JPanel panelFinal;
	public JPanel panelDeJuego;
	
	public VentanaFinal(JPanel panelFinal, JPanel panelDeJuego, JPanel panelInicial) {
		this.panelInicial=panelInicial;
		this.panelDeJuego = panelDeJuego;
		this.panelFinal = panelFinal;
		this.titulo = new javax.swing.JLabel();
	}

	public void initialize() {
		
		
		titulo.setVerticalAlignment(SwingConstants.BOTTOM);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setForeground(new java.awt.Color(255, 69, 0));
		titulo.setFont(new java.awt.Font("Showcard Gothic", java.awt.Font.PLAIN, 28));
		titulo.setBounds(73, 22, 286, 48);
		panelFinal.add(titulo);

		panelFinal.setVisible(false);

		javax.swing.JButton boton_jugar = new javax.swing.JButton("\u00A1JUGAR!");
		boton_jugar.setForeground(new java.awt.Color(255, 99, 71));
		boton_jugar.setFont(new java.awt.Font("Showcard Gothic", java.awt.Font.PLAIN, 16));
		boton_jugar.setBackground(new java.awt.Color(240, 230, 140));
		boton_jugar.setBounds(158, 169, 118, 48);
		panelFinal.add(boton_jugar);
		
		boton_jugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelFinal.setVisible(false);
				panelInicial.setVisible(true);
				
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

}
