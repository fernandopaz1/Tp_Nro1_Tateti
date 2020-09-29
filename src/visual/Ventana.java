package visual;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;

public class Ventana {

	private JFrame frame;
	private JPanel panelTablero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panelFondo = new JPanel();
		panelFondo.setForeground(Color.BLACK);
		panelFondo.setBounds(0, 0, 434, 261);
		panelFondo.setBackground(Color.WHITE);
		frame.getContentPane().add(panelFondo);
		panelFondo.setLayout(null);

		panelTablero = new JPanel();
		panelTablero.setBackground(Color.BLACK);
		panelTablero.setBounds(102, 32, 202, 205);
		panelFondo.add(panelTablero);
		panelTablero.setLayout(null);

		// creo un array de los jTextField tamaño 9
		JTextField[] casilleros = new JTextField[9];
		int x = 0;
		int y = 73;

		for (int i = 0; i < casilleros.length; i++) {
			casilleros[i] = new JTextField();

			if (i == 0) {
				y = 0;
			}

			if (i > 0 && i % 3 == 0) {
				x = x + 70;
				y = 0;
			}
			if (i == 1 || i % 3 == 1) {
				y = 73;
			}

			casilleros[i].setBounds(x, y, 60, 60);
			y = y + 71;

			panelTablero.add(casilleros[i]);
			casilleros[i].setColumns(10);
		}
	}

}
