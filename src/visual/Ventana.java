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

import tp.Juego;

import javax.swing.JSlider;
import javax.swing.JMenuBar;

public class Ventana {

	private JFrame frame;
	Juego juego = new Juego();
	VentanaInicial ventanaInicial = new VentanaInicial ();
	private JPanel panel_1;

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
		
		ventanaInicial.initialize(frame);
		frame.getContentPane().setLayout(null);
		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 434, 261);
        panel_1.setBackground(SystemColor.menu);
        frame.getContentPane().add(panel_1);
        matrizBotones (panel_1);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 434, 261);
        frame.getContentPane().add(panel);

	}

	
	public void matrizBotones (JPanel panel){
      
		 JButton botones[][] = new JButton[3][3];
		panel_1.setLayout(null);
		
		JButton boton00 = new JButton("");
		boton00.setBounds(120, 44, 60, 60);
        botones[0][0] = boton00;
        panel.add(boton00);
        

        JButton boton01 = new JButton("");
        boton01.setBounds(190, 44, 60, 60);
        panel.add(boton01);
        botones[0][1] = boton01;


        JButton boton02 = new JButton("");
        boton02.setBounds(260, 44, 60, 60);
        panel.add(boton02);
        botones[0][2] = boton02;

        JButton boton10 = new JButton("");
        boton10.setBounds(120, 109, 60, 60);
        panel.add(boton10);
        botones[1][0] = boton10;

        JButton boton11 = new JButton("");
        boton11.setBounds(190, 109, 60, 60);
        panel.add(boton11);
        botones[1][1] = boton11;

        JButton boton12 = new JButton("");
        boton12.setBounds(260, 109, 60, 60);
        panel.add(boton12);
        botones[1][2] = boton12;
        
        JButton boton20 = new JButton("");
        boton20.setBounds(120, 177, 60, 60);
        panel.add(boton20);
        botones[2][0] = boton20;

        JButton boton21 = new JButton("");
        boton21.setBounds(190, 177, 60, 60);
        panel.add(boton21);
        botones[2][1] = boton21;

        JButton boton22 = new JButton();
        boton22.setBounds(260, 177, 60, 60);
        panel.add(boton22);
        botones[2][2] = boton22;
        
        
     
        
        for (int i = 0; i < 3; i++) {
          for (int j = 0; j < 3; j++) {
        	botones[i][j].addActionListener(new PageActionListener(i,j,juego));
		            }
		  }
        	
          
        
        
        
      
}	
}
