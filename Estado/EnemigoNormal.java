package Estado;

import Enemigo.Enemigo;

public class EnemigoNormal extends EstadoEnemigo{

	public EnemigoNormal(Enemigo e) {
		super(e);
	}

	@Override
	public void movilizar() {
		enemigo.movilizar(0);
		
	}	

}