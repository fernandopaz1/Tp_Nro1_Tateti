package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import logica.Juego;

public class Main {

	private JFrame frame;
	private Juego juego = new Juego();
	private VentanaInicial ventanaInicial;
	private VentanaFinal ventanaFinal;
	private VentanaDeJuego ventanaDeJuego;
	private JPanel panelDeJuego;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panelDeJuego = new JPanel();
		panelDeJuego.setBounds(0, 0, 0, 0);
		frame.getContentPane().add(panelDeJuego);

		JPanel panelInicial = new JPanel();
		panelInicial.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panelInicial);

		JPanel panelFinal = new JPanel();
		panelFinal.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panelFinal);
		panelFinal.setLayout(null);

		ventanaInicial = new VentanaInicial(panelInicial, panelDeJuego, juego);

		ventanaFinal = new VentanaFinal(panelFinal, panelDeJuego, panelInicial);
		panelInicial.setLayout(null);


		ventanaDeJuego = new VentanaDeJuego(panelDeJuego, juego, ventanaFinal);

		ventanaInicial.initialize();

		ventanaFinal.initialize();

		ventanaDeJuego.initialize();

	}


}
