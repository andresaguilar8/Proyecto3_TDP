package Lanzamiento;

import java.awt.Point;

public abstract class Arma {

	public abstract Lanzamiento crearLanzamiento(Point pos, int cargaViral);
	public abstract void setImagenLanzamiento(String ruta);

}
