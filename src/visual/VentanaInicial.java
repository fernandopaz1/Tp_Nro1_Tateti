package visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import logica.Juego;

public class VentanaInicial extends ModeloDeVentana {

	private javax.swing.JTextField textJugador1;
	private javax.swing.JTextField textJugador2;
	private JPanel panelInicial;
	private JPanel panelDeJuego;
	private Juego newGame;
	private JLabel msjError;
	private JLabel foto1;
	private JLabel foto2;

	public VentanaInicial(JPanel panelInicial, JPanel panelDeJuego, Juego newGame) {

		this.panelDeJuego = panelDeJuego;
		this.panelInicial = panelInicial;
		this.newGame = newGame;

	}

	public void initialize() {

		panelInicial.setBorder(null);
		panelInicial.setBackground(new java.awt.Color(244, 164, 96));
		panelInicial.setBounds(0, 0, 434, 261);
		panelInicial.setLayout(null);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); // Esto lo q hace es darle una vista de
																					// tipo windows
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

		foto1 = crearBotonImagen(panelInicial, newGame, 335, 79, 89, 23, 250, 66, 63, 48);
		foto2 = crearBotonImagen(panelInicial, newGame, 335, 150, 89, 23, 250, 137, 63, 48);

		Color colorTitulo = new Color(255, 69, 0);
		Font fuenteTitulo = new Font("Showcard Gothic", java.awt.Font.PLAIN, 38);
		createJLabel(panelInicial, "TA - TE - TORO", colorTitulo, fuenteTitulo, 73, 5, 286, 48);

		Color colorJugador = new Color(105, 105, 105);
		Font fuenteJugador = new Font("Sitka Banner", java.awt.Font.PLAIN, 16);
		createJLabel(panelInicial, "Jugador 1: ", colorJugador, fuenteJugador, 60, 81, 91, 27);
		createJLabel(panelInicial, "Jugador 2: ", colorJugador, fuenteJugador, 60, 150, 91, 27);

		Color colorTextField = new Color(240, 230, 140);
		textJugador1 = createTextField(panelInicial, colorTextField, 140, 81, 86, 20);
		textJugador2 = createTextField(panelInicial, colorTextField, 140, 150, 86, 20);

		Color foreGround = new Color(255, 99, 71);
		Font buttonFont = new Font("Showcard Gothic", java.awt.Font.PLAIN, 16);
		Color background = new Color(240, 230, 140);
		JButton boton_jugar = createButton(panelInicial, "\u00A1JUGAR!", foreGround, buttonFont, background, 158, 190,
				118, 48);

		msjError = agregarMsjError("");

		boton_jugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				msjError.setVisible(false);
				
				newGame.cambiarNombreJugadores(textJugador1.getText(),textJugador2.getText());

				String mensajeDeError = newGame.sonNombresValidos();
				
				if(!mensajeDeError.equals("")){

					msjError.setText(mensajeDeError);
					msjError.setVisible(true);
				}
				else {

					panelInicial.setVisible(false);
					 

					borrarNombres();
					borrarFotos();

					panelDeJuego.setVisible(true);

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
		foto1.setIcon(null);
		foto2.setIcon(null);
	}

	public JLabel agregarMsjError(String textoDeError) {
		Color color = new Color(105, 105, 105);
		Font font = new Font("Sitka Banner", Font.PLAIN, 16);
		msjError = createJLabel(panelInicial, textoDeError, color, font, 10, 238, 450, 27);
		msjError.setVisible(false);
		panelInicial.add(msjError);
		return msjError;
	}


}