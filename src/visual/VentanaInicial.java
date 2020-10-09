package visual;

import java.awt.Color;
import java.awt.Font;
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

public class VentanaInicial extends ModeloDeVentana {

	private javax.swing.JTextField textJugador1;
	private javax.swing.JTextField textJugador2;
	private JPanel panelInicial;
	private JPanel panelDeJuego;
	private Juego newGame;
	private JLabel msjError;
	private JLabel foto1;
	private JLabel foto2;
	private JButton boton1;
	private JButton boton2;

	public VentanaInicial(JPanel panelInicial, JPanel panelDeJuego, Juego newGame) {

		this.panelDeJuego = panelDeJuego;
		this.panelInicial = panelInicial;
		this.newGame = newGame;

	}

	public JLabel agregarMsjError(String textoDeError) {

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
		foto1 = new JLabel("");
		foto1.setBounds(250, 66, 63, 48);
		foto1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelInicial.add(foto1);

		foto2 = new JLabel("");
		foto2.setBounds(250, 137, 63, 48);
		foto2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelInicial.add(foto2);

		
	    boton1 = createButton(panelInicial, "Elegir foto", null, null, null, 335, 79, 89, 23);

		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.setDialogTitle("Buscar foto");

				if (fc.showOpenDialog(panelInicial) == JFileChooser.APPROVE_OPTION) {

					Image img = new ImageIcon(fc.getSelectedFile().toString()).getImage();
					ImageIcon img2 = new ImageIcon(img.getScaledInstance(78, 124, Image.SCALE_SMOOTH));
					newGame.setImagenJugador1(img2);
					foto1.setIcon(img2);

				}
			}

		});
		
		boton2 = createButton(panelInicial, "Elegir foto", null, null, null, 335, 150, 89, 23);
		
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.setDialogTitle("Buscar foto");

				if (fc.showOpenDialog(panelInicial) == JFileChooser.APPROVE_OPTION) {

					Image img = new ImageIcon(fc.getSelectedFile().toString()).getImage();
					ImageIcon img2 = new ImageIcon(img.getScaledInstance(78, 124, Image.SCALE_SMOOTH));
					newGame.setImagenJugador2(img2);
					foto2.setIcon(img2);

				}

			}
		});

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

				if (textJugador1.getText().length() > 1 && textJugador2.getText().length() > 1
						&& textJugador1.getText().length() < 6 && textJugador2.getText().length() < 6) {

					panelInicial.setVisible(false);
					panelDeJuego.setVisible(true);
					newGame.cambiarNombreJugador1(textJugador1.getText());
					newGame.cambiarNombreJugador2(textJugador2.getText());
					borrarNombres();
					borrarFotos();
					panelDeJuego.setVisible(true);

				}

				if (textJugador1.getText().length() == 1 || textJugador2.getText().length() == 1) {
					msjError.setVisible(false);
					msjError = agregarMsjError("Todos los jugadores deben colocar un nombre con mas de una letra! ");
					msjError.setVisible(true);
				}

				if (textJugador1.getText().length() > 6 || textJugador2.getText().length() > 6) {
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
		foto1.setIcon(null);
		foto2.setIcon(null);
	}
}