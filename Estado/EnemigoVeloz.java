package Estado;

import Enemigo.Enemigo;

public class EnemigoVeloz extends EstadoEnemigo {
	
	public EnemigoVeloz(Enemigo e) {
		super(e);
	}

	@Override
	public void movilizar() {
		enemigo.movilizar(10);
		
	}

}