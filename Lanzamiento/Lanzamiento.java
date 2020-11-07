package Lanzamiento;

import Logica.Entidad;

public abstract class Lanzamiento extends Entidad{

	int velocidad;
	
	public Lanzamiento(int cargaViral, int x, int y) {
		super(x, y);
		this.cargaViral = cargaViral;
	}

}
