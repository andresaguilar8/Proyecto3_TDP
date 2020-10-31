package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Juego;

public class GUI extends JFrame {

	protected JPanel contentPane;
	protected JPanelConFondo panelJuego;
	protected Juego juego;
	protected HiloTiempo tiempo;
	public static Dimension size = new Dimension(1250, 790);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 500, 600);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelJuego = new JPanelConFondo(new ImageIcon(getClass().getResource("/Imagenes/fondo_prueba.png")).getImage());
		contentPane.add(panelJuego);
		juego = new Juego(this);
		tiempo = new HiloTiempo(juego);
		juego.setTiempo(tiempo);
		tiempo.start();
		
	}
	
	public void agregarEntidad(JLabel nuevo) {
		panelJuego.add(nuevo);
		nuevo.setLocation(nuevo.getBounds().getLocation());
//		contentPane.setComponentZOrder(nuevo, 0);
		repaint();
	}

}
