package Logica;

import Enemigo.Enemigo;

public abstract class EstadoEnemigo extends Estado {
	
	protected Enemigo enemigo;
	
	public EstadoEnemigo(Enemigo e) {
		enemigo = e;
	}

}
