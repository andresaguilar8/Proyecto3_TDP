package Visitor;

import Enemigo.Enemigo;
import Lanzamiento.LanzamientoAliado;
import Lanzamiento.LanzamientoEnemigo;
import Logica.Personaje;
import Logica.PowerUp;
import PowerUp.Cuarentena;

public class VisitorCuarentena extends Visitor {
	
	protected Cuarentena power;
	
	public VisitorCuarentena(Cuarentena cuarentena) {
		this.power = cuarentena;
	}

	public void visitar(Personaje e) {
		power.setCargaViral(0);
		power.realizarAccion();
	}

	public void visitar(Enemigo enemigo) {
		power.agregarAMapeo(enemigo);
		enemigo.getEstado().setVelocidad(0);
		power.mover();
	}

	public void visitar(LanzamientoAliado lanzamientoAliado) {
		power.mover();
	}

	public void visitar(LanzamientoEnemigo lanzamientoEnemigo) {
		power.mover();
	}

	public void visitar(PowerUp p) {
		power.mover();
	}

}
