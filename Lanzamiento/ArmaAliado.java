package Lanzamiento;

import java.awt.Point;

import javax.swing.ImageIcon;

public class ArmaAliado extends Arma{

	public Lanzamiento crearLanzamiento(Point pos, int cargaViral) {
		LanzamientoAliado lanzamiento = new LanzamientoAliado(cargaViral, pos.x + 22, pos.y - 25);
		lanzamiento.getLabel().setIcon(new ImageIcon(getClass().getResource("/Imagenes/LanzamientoPersonajeGif.gif")));
		lanzamiento.getLabel().setBounds(lanzamiento.getPosicion().x, lanzamiento.getPosicion().y, 30, 30);
		return lanzamiento;
	}
}