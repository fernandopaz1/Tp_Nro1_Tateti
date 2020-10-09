package visual;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import logica.Juego;

public class CapturadorDeClick implements ActionListener {

	private Juego juego;
	private int i;
	private int j;
	private VentanaFinal ventanaFinal;
	private VentanaDeJuego ventanaDeJuego;

	public CapturadorDeClick(int i, int j, Juego juego, VentanaFinal ventanaFinal, VentanaDeJuego ventanaDeJuego) {
		this.i = i;
		this.j = j;
		this.juego = juego;
		this.ventanaFinal = ventanaFinal;
		this.ventanaDeJuego = ventanaDeJuego;
	}

	// El nombre de este metodo no se puede cambiar
	// debido a la clase acctionListener;
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();
		if (clicked.getText() == "") {
			clicked.setText(juego.jugadorActual().getPieza());
			juego.guardarMovimiento(i, j);
			String ganador = juego.hayGanador();

			if (ganador != "") {
				ventanaFinal.setMensaje(ganador);
				ventanaFinal.mostrarVentana();
				ventanaFinal.mostrarFotoGanador(juego.jugadorActual().getImagenJugador());
				ventanaDeJuego.limpiarTablero();
			} else if (juego.hayEmpate()) {
				ventanaFinal.setMensaje("Empate");
				ventanaFinal.mostrarVentana();
				ventanaDeJuego.limpiarTablero();
			}
		}

	}

}
