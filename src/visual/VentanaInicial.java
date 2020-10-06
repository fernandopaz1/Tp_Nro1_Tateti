package visual;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import logica.Juego;

public class VentanaInicial {

	private javax.swing.JTextField textJugador1;
	private javax.swing.JTextField textJugador2;
	private JPanel panelInicial;
	private JPanel panelDeJuego;
	private Juego newGame;
	

	public VentanaInicial(JPanel panelInicial, JPanel panelDeJuego, Juego newGame) {
		this.panelDeJuego=panelDeJuego;
		this.panelInicial=panelInicial;
		this.newGame=newGame;
	}
	


	public void initialize() {
		
			panelInicial.setBorder(null);
			panelInicial.setBackground(new java.awt.Color(244, 164, 96));
			panelInicial.setBounds(0, 0, 434, 261);
			panelInicial.setLayout(null);
			
			javax.swing.JLabel titulo = new javax.swing.JLabel("TA - TE - TORO");
			titulo.setVerticalAlignment(SwingConstants.BOTTOM);
			titulo.setHorizontalAlignment(SwingConstants.CENTER);
			titulo.setForeground(new java.awt.Color(255, 69, 0));
			titulo.setFont(new java.awt.Font("Showcard Gothic", java.awt.Font.PLAIN, 38));
			titulo.setBounds(73, 22, 286, 48);
			panelInicial.add(titulo);
			
			javax.swing.JLabel msj_jugador1 = new javax.swing.JLabel("Jugador 1 : ");
			msj_jugador1.setForeground(new java.awt.Color(105, 105, 105));
			msj_jugador1.setFont(new java.awt.Font("Sitka Banner", java.awt.Font.PLAIN, 16));
			msj_jugador1.setBounds(83, 81, 91, 27);
			panelInicial.add(msj_jugador1);
			
			javax.swing.JLabel msj_jugador2 = new javax.swing.JLabel("Jugador 2 : ");
			msj_jugador2.setForeground(new java.awt.Color(105, 105, 105));
			msj_jugador2.setFont(new java.awt.Font("Sitka Banner", java.awt.Font.PLAIN, 16));
			msj_jugador2.setBounds(81, 119, 72, 27);
			panelInicial.add(msj_jugador2);
			
			textJugador1 = new javax.swing.JTextField();
			textJugador1.setBackground(new java.awt.Color(240, 230, 140));
			textJugador1.setBounds(190, 81, 86, 20);
			panelInicial.add(textJugador1);
			textJugador1.setColumns(10);
			
			textJugador2 = new javax.swing.JTextField();
			textJugador2.setBackground(new java.awt.Color(240, 230, 140));
			textJugador2.setColumns(10);
			textJugador2.setBounds(190, 121, 86, 20);
			panelInicial.add(textJugador2);
			
			javax.swing.JButton boton_jugar = new javax.swing.JButton("\u00A1JUGAR!");
			boton_jugar.setForeground(new java.awt.Color(255, 99, 71));
			boton_jugar.setFont(new java.awt.Font("Showcard Gothic", java.awt.Font.PLAIN, 16));
			boton_jugar.setBackground(new java.awt.Color(240, 230, 140));
			boton_jugar.setBounds(158, 169, 118, 48);
			panelInicial.add(boton_jugar);
			
			
			javax.swing.JLabel msjError = new javax.swing.JLabel("Error: nombre inválido");
			msjError.setForeground(new java.awt.Color(105, 105, 105));
			msjError.setFont(new java.awt.Font("Sitka Banner", java.awt.Font.PLAIN, 16));
			msjError.setBounds(158, 220, 200, 27);
			msjError.setVisible(false);
			panelInicial.add(msjError);
			
			
			boton_jugar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					
					if(textJugador1.getText().length()>0 && textJugador2.getText().length()>0 &&
					   textJugador1.getText().length()<6 && textJugador2.getText().length()<6) {
							panelInicial.setVisible(false);
							panelDeJuego.setVisible(true);
							newGame.cambiarNombreJugador1(textJugador1.getText());
							newGame.cambiarNombreJugador2(textJugador2.getText());
							borrarNombres();
							panelDeJuego.setVisible(true);
							msjError.setVisible(false);
					}else {
						msjError.setVisible(true);
						
					}
				
					
				}
			});
			
		}
	public void borrarNombres() {
		textJugador1.setText("");
		textJugador2.setText("");
	}
}