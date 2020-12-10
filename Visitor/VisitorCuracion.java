package Visitor;

import Enemigo.Enemigo;
import Lanzamiento.LanzamientoAliado;
import Lanzamiento.LanzamientoEnemigo;
import Logica.Personaje;
import Logica.PowerUp;

public class VisitorCuracion extends Visitor {
	
	protected PowerUp powerUp;

	public VisitorCuracion(PowerUp p) {
		powerUp = p;
	}
	
	public void visitar(Personaje p) {
		p.setCargaViral(0);
		powerUp.setCargaViral(0);
	}

	public void visitar(Enemigo enemigo) {
		powerUp.mover();
	}

	public void visitar(LanzamientoAliado lanzamientoAliado) {
		powerUp.mover();
	}

	public void visitar(LanzamientoEnemigo lanzamientoEnemigo) {
		powerUp.mover();
	}

	public void visitar(PowerUp p) {
		powerUp.mover();
	}

}