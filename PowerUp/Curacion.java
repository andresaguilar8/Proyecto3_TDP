package PowerUp;

import javax.swing.ImageIcon;

import Logica.PowerUp;

public class Curacion extends PowerUp implements Runnable {

	public Curacion(int x, int y) {
		super(x, y);
		label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/PowerUpCuracion.png")));
		label.setBounds(50, 50, 50, 50);
	}

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
		}
		catch(InterruptedException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public void realizarAccion() {
		(new Thread(this)).start();
	}

}
