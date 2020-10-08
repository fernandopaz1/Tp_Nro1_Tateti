package visual;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

import logica.Juego;

public class VentanaInicial {

	private javax.swing.JTextField textJugador1;
	private javax.swing.JTextField textJugador2;
	private JPanel panelInicial;
	private JPanel panelDeJuego;
	private Juego newGame;
	private JLabel msjError;
	private JLabel Foto1;
	private JLabel Foto2;
	private JButton Boton1;
	private JButton Boton2;
	

	public VentanaInicial(JPanel panelInicial, JPanel panelDeJuego, Juego newGame) {
		
		this.panelDeJuego=panelDeJuego;
		this.panelInicial=panelInicial;
		this.newGame=newGame;
		
	}
	
	public JLabel agregarMsjError (String textoDeError) {
		
		javax.swing.JLabel msjError = new javax.swing.JLabel(textoDeError);
		msjError.setForeground(new java.awt.Color(105, 105, 105));
		msjError.setFont(new java.awt.Font("Sitka Banner", java.awt.Font.PLAIN, 16));
		msjError.setBounds(10, 238, 450, 27);
		msjError.setVisible(false);
		panelInicial.add(msjError);
		return msjError;
	}
	
	
	public void initialize() {
			
			
			panelInicial.setBorder(null);
			panelInicial.setBackground(new java.awt.Color(244, 164, 96));
			panelInicial.setBounds(0, 0, 434, 261);
			panelInicial.setLayout(null);
			
			
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());     //Esto lo q hace es darle una vista de tipo windows 
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UnsupportedLookAndFeelException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Foto1 = new JLabel("");
			Foto1.setBounds(250, 66, 63, 48);
			Foto1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			panelInicial.add(Foto1);
			
			Foto2 = new JLabel("");
			Foto2.setBounds(250, 137, 63, 48);
			Foto2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			panelInicial.add(Foto2);
			
			Boton1 = new JButton("Elegir foto");
			Boton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser fc = new JFileChooser();
					fc.setDialogTitle("Buscar foto");
		
						if (fc.showOpenDialog(panelInicial) == JFileChooser.APPROVE_OPTION) {
								
								
								Image img= new ImageIcon(fc.getSelectedFile().toString()).getImage();
								ImageIcon img2=new ImageIcon(img.getScaledInstance(78, 124, Image.SCALE_SMOOTH));
								newGame.setImagenJugador1(img2);
								Foto1.setIcon(img2); 
								
							}
						}
					
				
			});
			Boton1.setBounds(335, 79, 89, 23);
			panelInicial.add(Boton1);
			
			Boton2 = new JButton("Elegir foto");
			Boton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser fc = new JFileChooser();
					fc.setDialogTitle("Buscar foto");
		
						if (fc.showOpenDialog(panelInicial) == JFileChooser.APPROVE_OPTION) {
								
								
								Image img= new ImageIcon(fc.getSelectedFile().toString()).getImage();
								ImageIcon img2=new ImageIcon(img.getScaledInstance(78, 124, Image.SCALE_SMOOTH));
								newGame.setImagenJugador2(img2);
								Foto2.setIcon(img2); 
								
							}
					
				}
			});
			Boton2.setBounds(335, 150, 89, 23);
			panelInicial.add(Boton2);
			
			
			
			
			
			javax.swing.JLabel titulo = new javax.swing.JLabel("TA - TE - TORO");
			titulo.setVerticalAlignment(SwingConstants.BOTTOM);
			titulo.setHorizontalAlignment(SwingConstants.CENTER);
			titulo.setForeground(new java.awt.Color(255, 69, 0));
			titulo.setFont(new java.awt.Font("Showcard Gothic", java.awt.Font.PLAIN, 38));
			titulo.setBounds(73, 5, 286, 48);
			panelInicial.add(titulo);
			
			javax.swing.JLabel msj_jugador1 = new javax.swing.JLabel("Jugador 1: ");
			msj_jugador1.setForeground(new java.awt.Color(105, 105, 105));
			msj_jugador1.setFont(new java.awt.Font("Sitka Banner", java.awt.Font.PLAIN, 16));
			msj_jugador1.setBounds(60, 81, 91, 27);
			panelInicial.add(msj_jugador1);
			
			javax.swing.JLabel msj_jugador2 = new javax.swing.JLabel("Jugador 2: ");
			msj_jugador2.setForeground(new java.awt.Color(105, 105, 105));
			msj_jugador2.setFont(new java.awt.Font("Sitka Banner", java.awt.Font.PLAIN, 16));
			msj_jugador2.setBounds(60, 150, 91, 27);
			panelInicial.add(msj_jugador2);
			
			textJugador1 = new javax.swing.JTextField();
			textJugador1.setBackground(new java.awt.Color(240, 230, 140));
			textJugador1.setBounds(140, 81, 86, 20);
			panelInicial.add(textJugador1);
			textJugador1.setColumns(10);
			
			textJugador2 = new javax.swing.JTextField();
			textJugador2.setBackground(new java.awt.Color(240, 230, 140));
			textJugador2.setColumns(10);
			textJugador2.setBounds(140, 150, 86, 20);
			panelInicial.add(textJugador2);
			
			
			
			javax.swing.JButton boton_jugar = new javax.swing.JButton("\u00A1JUGAR!");
			boton_jugar.setForeground(new java.awt.Color(255, 99, 71));
			boton_jugar.setFont(new java.awt.Font("Showcard Gothic", java.awt.Font.PLAIN, 16));
			boton_jugar.setBackground(new java.awt.Color(240, 230, 140));
			boton_jugar.setBounds(158, 190, 118, 48);
			panelInicial.add(boton_jugar);
			
			msjError = agregarMsjError("");

			
			
			
			
			boton_jugar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					msjError.setVisible(false);	

					if(textJugador1.getText().length()>1 && textJugador2.getText().length()>1 &&
					   textJugador1.getText().length()<6 && textJugador2.getText().length()<6) {
					
							panelInicial.setVisible(false);
							panelDeJuego.setVisible(true);
							newGame.cambiarNombreJugador1(textJugador1.getText());
							newGame.cambiarNombreJugador2(textJugador2.getText());
							borrarNombres();
							borrarFotos();
							panelDeJuego.setVisible(true);

					}
						
					if(textJugador1.getText().length() == 1 || textJugador2.getText().length() == 1 ) {
							msjError.setVisible(false);
							msjError = agregarMsjError("Todos los jugadores deben colocar un nombre con mas de una letra! ");
							msjError.setVisible(true);
						}

					
					if (textJugador1.getText().length()>6  || textJugador2.getText().length()>6) {
						msjError.setVisible(false);
						msjError = agregarMsjError("Todos los jugadores deben tener un nombre con 5 letras o menos ! ");
						msjError.setVisible(true);
				
					}
					
				
				}	
			}
			
			);
			
			
		}
	
	public void borrarNombres() {
		textJugador1.setText("");
		textJugador2.setText("");
	}
	
	public void borrarFotos() {
		Foto1.setIcon(null);
		Foto2.setIcon(null);
	}
}