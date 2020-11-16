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
		
	}

	public void visitar(Beta b) {
		
	}

	public void visitar(Enemigo enemigo) {
		
	}

	public void visitar(LanzamientoAliado lanzamientoAliado) {
		
	}

	public void visitar(LanzamientoEnemigo lanzamientoEnemigo) {
		
	}

	public void visitar(PowerUp p) {
		
	}
	
}