package Lanzamiento;

import java.awt.Point;

import javax.swing.ImageIcon;

public class ArmaAliado extends Arma{
	
	public String ruta = "";
	
	public Lanzamiento crearLanzamiento(Point pos, int cargaViral) {
		LanzamientoAliado lanzamiento = new LanzamientoAliado(cargaViral, pos.x + 22, pos.y - 25);
		lanzamiento.getLabel().setIcon(new ImageIcon(getClass().getResource(ruta)));
		lanzamiento.getLabel().setBounds(lanzamiento.getPosicion().x, lanzamiento.getPosicion().y, 30, 30);
		System.out.println(ruta);
		return lanzamiento;
	}

	public void setImagenLanzamiento(String ruta) {
		this.ruta = ruta;
	}
	

	
}
