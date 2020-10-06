package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.ComponentOrientation;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;

import logica.Juego;

import javax.swing.JSlider;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ventana {

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
		frame.getContentPane().add(panelDeJuego);
		

		JPanel panelInicial = new JPanel();
		panelInicial.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panelInicial);


		JPanel panelFinal = new JPanel();
		panelFinal.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panelFinal);
		panelFinal.setLayout(null);

		
		ventanaInicial=new VentanaInicial(panelInicial, panelDeJuego, juego);
		
		ventanaFinal = new VentanaFinal(panelFinal, panelDeJuego, panelInicial, ventanaDeJuego);
		
		
		ventanaDeJuego= new VentanaDeJuego(panelDeJuego,juego,ventanaFinal);
		
		
		ventanaInicial.initialize();
		
	
		
		
		ventanaFinal.initialize();
		
		
		ventanaDeJuego.initialize();
		

	}
	
}
