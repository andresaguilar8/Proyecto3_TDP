package Enemigo;

import javax.swing.ImageIcon;

import Logica.Entidad;

public class Alpha extends Enemigo {

	public Alpha(int x, int y) {
		super(x, y);
		label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/AlphaExplotaGif.gif")));
		label.setBounds(x, y, 117, 110);
	}
	
	public void mover() {
        super.mover();
        label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/AlphaCaminaGif.gif")));
    }

    public void atacar(Entidad e) {
        label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/AlfaAtacaGif.gif")));
    }

    public void parar() {
        label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/AlfaParado.png")));
    }

	public Enemigo clonar() {
		Enemigo clone = new Alpha(0,0);
		return clone;
	}

}
