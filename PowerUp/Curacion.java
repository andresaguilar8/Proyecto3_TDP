package PowerUp;

import javax.swing.ImageIcon;

import Logica.PowerUp;

public class Curacion extends PowerUp {

	public Curacion(int x, int y) {
		super(x, y);
		label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/corazonGif.gif")));
		label.setBounds(x, y, 90 , 90);
	}
		
	public void realizarAccion() {
		juego.getPersonaje().setCargaViral(0);
	}

}
