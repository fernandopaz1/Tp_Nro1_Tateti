package visual;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ModeloDeVentana {

	public JLabel createJLabel(JPanel panel, String texto, Color color, Font fuente, int posX, int posY, int ancho,
			int alto) {
		JLabel titulo = new JLabel(texto);
		// titulo.setVerticalAlignment(SwingConstants.BOTTOM);
		// titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setForeground(color);
		titulo.setFont(fuente);
		titulo.setBounds(posX, posY, ancho, alto);
		panel.add(titulo);
		return titulo;
	}

	public void alignJLabel(JLabel label) {
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		label.setHorizontalAlignment(SwingConstants.CENTER);
	}

	public JTextField createTextField(JPanel panel, Color color, int posX, int posY, int ancho, int alto) {
		JTextField textJugador = new JTextField();
		textJugador.setBackground(color);
		textJugador.setBounds(posX, posY, ancho, alto);
		panel.add(textJugador);
		// textJugador.setColumns(10);
		return textJugador;
	}

	public JButton createButton(JPanel panel, String text, Color foreGround, Font font, Color background, int posX,
			int posY, int ancho, int alto) {
		JButton boton = new JButton(text);
		if (foreGround != null)
			boton.setForeground(foreGround);
		if (font != null)
			boton.setFont(font);
		if (background != null)
			boton.setBackground(background);
		boton.setBounds(posX, posY, ancho, alto);
		panel.add(boton);
		return boton;
	}
}
