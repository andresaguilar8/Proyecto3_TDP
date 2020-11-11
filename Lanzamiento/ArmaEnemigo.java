package Lanzamiento;

import java.awt.Point;

import javax.swing.ImageIcon;

public class ArmaEnemigo extends Arma {

	public Lanzamiento crearLanzamiento(Point pos, int cargaViral) {
		LanzamientoEnemigo lanzamiento = new LanzamientoEnemigo(cargaViral, pos.x + 28, pos.y+ 80);
		lanzamiento.getLabel().setIcon(new ImageIcon(getClass().getResource("/Imagenes/LanzamientoEnemigoGif.gif")));
		lanzamiento.getLabel().setBounds(lanzamiento.getPosicion().x, lanzamiento.getPosicion().y, 30, 30);
		return lanzamiento;
	}
}

