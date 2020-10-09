package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;

import logica.Juego;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class Ventana {

	private JFrame frame;
	private Juego juego = new Juego();
	private VentanaInicial ventanaInicial;
	private VentanaFinal ventanaFinal;
	private VentanaDeJuego ventanaDeJuego;
	private JPanel panelDeJuego;
	private JLabel Foto1;
	private JLabel Foto2;
	private JButton Boton1;
	private JButton Boton2;
	private final Action action = new SwingAction();

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

		ventanaFinal = new VentanaFinal(panelFinal, panelDeJuego, panelInicial, ventanaDeJuego);
		panelInicial.setLayout(null);

//		Foto1 = new JLabel("Foto jugador 1");
//		Foto1.setBounds(361, 44, 63, 48);
//		panelInicial.add(Foto1);
//		
//		Foto2 = new JLabel("Foto jugador 2 ");
//		Foto2.setBounds(361, 137, 63, 48);
//		panelInicial.add(Foto2);
//		
//		Boton1 = new JButton("New button");
//		Boton1.setAction(action);
//		Boton1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				JFileChooser fc = new JFileChooser();
//				fc.setDialogTitle("Buscar foto");
//				
//				if (fc.showOpenDialog() == JFileChooser.APPROVE_OPTION) {
//					File archivo = new File(fc.getSelectedFile().toString());
//				}
//			}
//		});
//		Boton1.setBounds(335, 103, 89, 23);
//		panelInicial.add(Boton1);
//		
//		Boton2 = new JButton("New button");
//		Boton2.setBounds(335, 196, 89, 23);
//		panelInicial.add(Boton2);

		ventanaDeJuego = new VentanaDeJuego(panelDeJuego, juego, ventanaFinal);

		ventanaInicial.initialize();

		ventanaFinal.initialize();

		ventanaDeJuego.initialize();

	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}
}
