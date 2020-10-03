package visual;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import tp.Juego;



public class VentanaFinal {
	JPanel panelFinal; 
	javax.swing.JLabel titulo;;
	private JFrame frame;
	JPanel panelDeJuego;



public void initialize(JPanel panelFinal,JPanel panelDeJuego, JPanel panelIncial) {
	this.panelDeJuego = panelDeJuego;
	this.panelFinal = panelFinal;
	titulo = new javax.swing.JLabel();
	titulo.setVerticalAlignment(SwingConstants.BOTTOM);
	titulo.setHorizontalAlignment(SwingConstants.CENTER);
	titulo.setForeground(new java.awt.Color(255, 69, 0));
	titulo.setFont(new java.awt.Font("Showcard Gothic", java.awt.Font.PLAIN, 28));
	titulo.setBounds(73, 22, 286, 48);
	panelFinal.add(titulo);
	
	panelFinal.setVisible(false);
	
	
	
//	this.panelFinal.setVisible(false);
}
public void setMensaje (String mensaje) {
	titulo.setText(mensaje);
}
public void mostrarVentana() {
	this.panelFinal.setVisible(true);
	this.panelDeJuego.setVisible(false);
	
	
}
}
