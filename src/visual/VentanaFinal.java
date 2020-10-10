package visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class VentanaFinal extends ModeloDeVentana {

	private JLabel titulo;
	private JPanel panelInicial;
	private JPanel panelFinal;
	private JPanel panelDeJuego;
	private JLabel fotoGanadora;

	public VentanaFinal(JPanel panelFinal, JPanel panelDeJuego, JPanel panelInicial) {
		this.panelInicial = panelInicial;
		this.panelDeJuego = panelDeJuego;
		this.panelFinal = panelFinal;
		this.titulo = new JLabel();
	}

	public void initialize() {

		panelFinal.setBackground(new java.awt.Color(244, 164, 96));
		panelFinal.setVisible(false);

		Font fontTitulo = new java.awt.Font("Showcard Gothic", java.awt.Font.PLAIN, 28);
		Color foreGround = new java.awt.Color(255, 69, 0);
		titulo = createJLabel(panelFinal, "", foreGround, fontTitulo, 20, 22, 386, 48);
		alignJLabel(titulo);

		fotoGanadora = createJLabel(panelFinal, "", null, null, 185, 76, 63, 48);
		fotoGanadora.setBorder(new LineBorder(new Color(240, 230, 140), 2));

		Color backgroundBttn = new java.awt.Color(240, 230, 140);
		Font fontBttn = new java.awt.Font("Showcard Gothic", java.awt.Font.PLAIN, 16);
		Color foreGroundBttn = new java.awt.Color(255, 99, 71);
		JButton botonMenu = createButton(panelFinal, "\u00A1Volver al menu!", foreGroundBttn, fontBttn, backgroundBttn,
				128, 190, 180, 48);
		JButton botonJugarOtraVez = createButton(panelFinal, "\u00A1Nueva ronda!", foreGroundBttn, fontBttn,
				backgroundBttn, 128, 140, 180, 48);

		botonMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelFinal.setVisible(false);
				panelInicial.setVisible(true);

			}
		});

		botonJugarOtraVez.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelFinal.setVisible(false);
				panelDeJuego.setVisible(true);
			}
		});
	}

	public void setMensaje(String mensaje) {
		titulo.setText(mensaje);
	}

	public void getTitulo() {
	
	}

	public void mostrarVentana() {
		this.panelFinal.setVisible(true);
		this.panelDeJuego.setVisible(false);

	}

	public void mostrarFotoGanador(ImageIcon imagen) {
		fotoGanadora.setIcon(imagen);
	}

}
