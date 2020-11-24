package Visitor;

import java.awt.event.KeyEvent;

import Enemigo.Alpha;
import Enemigo.Beta;
import Enemigo.Enemigo;
import Lanzamiento.LanzamientoAliado;
import Lanzamiento.LanzamientoEnemigo;
import Logica.Entidad;
import Logica.Personaje;
import Logica.PowerUp;

	public class VisitorPowerUp extends Visitor {
	protected PowerUp powerUp;

	public VisitorPowerUp(PowerUp p) {
		powerUp = p;
	}
	
	public void visitar(Personaje e) {
		powerUp.curar(e);
		System.out.println("personaje curado");
		powerUp.setCargaViral(0);
	}

	public void visitar(Alpha a) {
		miEntidad.mover();
	}

	public void visitar(Beta b) {
		miEntidad.mover();
	}

	public void visitar(Enemigo enemigo) {
		miEntidad.mover();
	}

	public void visitar(LanzamientoAliado lanzamientoAliado) {
		
	}

	public void visitar(LanzamientoEnemigo lanzamientoEnemigo) {
		
	}

	public void visitar(PowerUp p) {
		miEntidad.mover();
	}

	

}
