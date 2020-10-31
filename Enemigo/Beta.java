package Enemigo;

import javax.swing.ImageIcon;

import Logica.Entidad;

public class Beta extends Enemigo {

	public Beta(int x, int y) {
		super(x, y);
		label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/AlphaExplotaGif.gif")));
		label.setBounds(x, y, 117 , 110);
	}

	public void mover() {
        super.mover();
        label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/BetaCaminaGif.gif")));
//        label.setBounds(110 , 110);
    }

    public void atacar(Entidad e) {
        label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/BetaAtacaGif.gif")));
    }

    public void parar() {
        label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/BetaParado.png")));
    }

    public Enemigo clonar() {
		Enemigo clone = new Beta(0,0);
		return clone;
	}
}
