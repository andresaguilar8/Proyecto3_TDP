package Estado;

import Enemigo.Enemigo;

public abstract class EstadoEnemigo extends Estado {
	protected Enemigo enemigo;
	
	public EstadoEnemigo(Enemigo enemigo) {
		this.enemigo = enemigo;
	}
	
}
