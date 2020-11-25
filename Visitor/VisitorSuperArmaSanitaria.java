package Visitor;

import Enemigo.Enemigo;
import Lanzamiento.LanzamientoAliado;
import Lanzamiento.LanzamientoEnemigo;
import Logica.Personaje;
import Logica.PowerUp;
import PowerUp.SuperArmaSanitaria;

public class VisitorSuperArmaSanitaria extends Visitor{

	protected SuperArmaSanitaria power;
	
	public VisitorSuperArmaSanitaria(SuperArmaSanitaria superArma) {
		this.power = superArma;
	}

	public void visitar(Personaje e) {
		power.setCargaViral(0);
		power.declararPersonaje(e);
		power.realizarAccion();
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