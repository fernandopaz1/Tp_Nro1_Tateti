package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;

public class Tablero_ {

	private JFrame frame;
	private JPanel panelTablero;
	private JTextField casillero11;
	private JTextField casillero12;
	private JTextField casillero13;
	private JTextField casillero21;
	private JTextField casillero22;
	private JTextField casillero23;
	private JTextField casillero31;
	private JTextField casillero32;
	private JTextField casillero33;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tablero_ window = new Tablero_();
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
	public Tablero_() {
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
		
		casillero11 = new JTextField();
		casillero11.setBounds(0, 0, 60, 60);
		panelTablero.add(casillero11);
		casillero11.setColumns(10);
		
		casillero12 = new JTextField();
		casillero12.setColumns(10);
		casillero12.setBounds(0, 73, 60, 60);
		panelTablero.add(casillero12);
		
		casillero13 = new JTextField();
		casillero13.setColumns(10);
		casillero13.setBounds(0, 144, 60, 60);
		panelTablero.add(casillero13);
		
		casillero21 = new JTextField();
		casillero21.setColumns(10);
		casillero21.setBounds(70, 0, 60, 60);
		panelTablero.add(casillero21);
		
		casillero22 = new JTextField();
		casillero22.setColumns(10);
		casillero22.setBounds(70, 73, 60, 60);
		panelTablero.add(casillero22);
		
		casillero23 = new JTextField();
		casillero23.setColumns(10);
		casillero23.setBounds(70, 144, 60, 60);
		panelTablero.add(casillero23);
		
		casillero31 = new JTextField();
		casillero31.setColumns(10);
		casillero31.setBounds(140, 0, 60, 60);
		panelTablero.add(casillero31);
		
		casillero32 = new JTextField();
		casillero32.setColumns(10);
		casillero32.setBounds(140, 73, 60, 60);
		panelTablero.add(casillero32);
		
		casillero33 = new JTextField();
		casillero33.setColumns(10);
		casillero33.setBounds(140, 144, 60, 60);
		panelTablero.add(casillero33);
	}
}
