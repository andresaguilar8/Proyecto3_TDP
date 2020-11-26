package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Logica.Entidad;
import Logica.Juego;

public class GUI extends JFrame {

	protected JPanel contentPane;
	protected JLabel etiquetaGradoDeInfeccion, gameOver, ganar;
	protected JPanelConFondo panelActual;
	protected Juego juego;
	protected HiloTiempo tiempo;
	public static Dimension size = new Dimension(1250, 790);


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//SplashScreen splash = new SplashScreen(2000);w
					//splash.setVisible(true);
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public GUI() {

		setearConsideracionesGUI();
		inicializarJuegoGraficamente();
		
		juego = new Juego(this);
		tiempo = new HiloTiempo(juego);
		juego.setTiempo(tiempo);
		tiempo.start();
		
//		int numEntero = juego.getPersonaje().getCargaViral();   
//	    String numCadena = numEntero+"asas";
//		etiquetaGradoDeInfeccion = new JLabel(numCadena);
//		etiquetaGradoDeInfeccion.setBounds(500, 100, 500, 500);
//		panelJuego.add(etiquetaGradoDeInfeccion);
		
		
		iniciarKeyListener();
		
	}
	public void setearConsideracionesGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 500, 600);
		this.setResizable(false);
	}
	
	public void inicializarJuegoGraficamente() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Color.black);
		setContentPane(contentPane);
		
		//panelJuego = new JPanelConFondo(new ImageIcon(getClass().getResource("/Imagenes/mapa_!.jpeg")).getImage());
		//panelJuego.setBounds(500, 100, 500, 600);
		//contentPane.add(panelJuego);
		repaint();
//		panelJuego.paint(getGraphics());
	}
	
	public void gameOver() {
		gameOver = new JLabel();
		gameOver.setBounds(0,0,1280,720);
		gameOver.setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/gameOver.jpg")));
		terminarJuego(gameOver);
	}
	
	public void agregarEntidad(JLabel nuevo) {
		this.getPanelActual().add(nuevo);
		nuevo.setLocation(nuevo.getBounds().getLocation());
		repaint();
	}
	
	private Container getPanelActual() {
		return panelActual;
	}

	private void terminarJuego(JLabel label) {
		JButton volverAJugar = new JButton();
		volverAJugar.setBounds(140, 150, 230, 36);
		volverAJugar.setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/VolverAJugar.png")));
		volverAJugar.setOpaque(false);
		volverAJugar.setBackground(new Color(0, 0, 0));
		volverAJugar.setBorderPainted(false);
		volverAJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repaint();
				setearConsideracionesGUI();
				inicializarJuegoGraficamente();
				juego = new Juego(GUI.this);
				tiempo = new HiloTiempo(juego);
				juego.setHilo(tiempo);
				tiempo.start();
				setVisible(true);
				requestFocus();
			}
		});
		
		JButton salir = new JButton();
		salir.setBounds(210, 190, 61, 29);
		salir.setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/Salir.png")));
		salir.setOpaque(false);
		salir.setBackground(new Color(0,0,0));
		salir.setBorderPainted(false);
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();				
			}
		});
		
		contentPane.removeAll();
		contentPane.add(label);
		contentPane.add(volverAJugar);
		contentPane.add(salir);
		this.repaint();
	}
	
	public void ganar() {
		ganar = new JLabel();
		ganar.setBounds(0,0,1280,720);
		ganar.setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/win.png")));
		terminarJuego(ganar);
	}
	
	private void iniciarKeyListener() {
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				juego.getPersonaje().keyPressed(arg0);
			}
        	public void keyReleased(KeyEvent arg0) {
            	juego.getPersonaje().keyReleased(arg0);
			 }
		});
	}
		
	public void eliminarEnemigo(Entidad aEliminar) {
		panelActual.remove(aEliminar.getLabel());
		repaint();
	}


	public void setPanelActual(JPanelConFondo panelActual) {
		this.panelActual = (JPanelConFondo) panelActual;
		this.setVisible(true);
	}
	
	
}
		
