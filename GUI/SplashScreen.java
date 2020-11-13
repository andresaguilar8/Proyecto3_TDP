package GUI;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

public class SplashScreen extends JDialog{

	private Image img;
	private JPanelConFondo panel;
	 
	public SplashScreen(long tiempo) {
		setSize(500, 500);
		inicializar();
		splash(tiempo);
	}
	
	private void inicializar() {
		panel = new JPanelConFondo(new ImageIcon(getClass().getResource("/Imagenes/BetaCaminaGif.gif")).getImage());
	}
	
	public void splash(long tiempo) {
		Thread hilo = new Thread(new Runnable() {

		public void run() {
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		});
		hilo.start();
	}
}
