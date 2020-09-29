package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

public class Ventana {

	private JFrame frame;

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
		matrizBotones();

	}

	public JButton[][] matrizBotones() {
		JButton botones[][] = new JButton[3][3];
		int y = 39;
		int x = 107;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				botones[i][j] = new JButton();
				botones[i][j].setBounds(x, y, 60, 60);
				frame.getContentPane().add(botones[i][j]);
				x += 65;
			}
			y += 64;
			x = 107;

		}
		return botones;
	}

}
