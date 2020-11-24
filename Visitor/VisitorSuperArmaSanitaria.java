package Visitor;

import Enemigo.Alpha;
import Enemigo.Beta;
import Enemigo.Enemigo;
import Lanzamiento.LanzamientoAliado;
import Lanzamiento.LanzamientoEnemigo;
import Logica.Personaje;
import Logica.PowerUp;
import PowerUp.Cuarentena;
import PowerUp.SuperArmaSanitaria;

public class VisitorSuperArmaSanitaria extends Visitor{

	protected SuperArmaSanitaria power;
	
	public VisitorSuperArmaSanitaria(SuperArmaSanitaria superArma) {
		this.power = superArma;
	}

	public void visitar(Personaje e) {
		power.setCargaViral(0);
		power.agregarAMapeo(e);
		e.setPoderDeDesinfeccion(e.getPoderDeDesinfeccion() + power.getMejora());
		power.realizarAccion();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
	}

	public void visitar(Alpha a) {
		power.mover();
	}

	public void visitar(Beta b) {
		power.mover();
	}

	public void visitar(Enemigo enemigo) {
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