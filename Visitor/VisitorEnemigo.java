package Visitor;

import Enemigo.Enemigo;
import Lanzamiento.LanzamientoAliado;
import Lanzamiento.LanzamientoEnemigo;
import Logica.Entidad;
import Logica.Personaje;
import Logica.PowerUp;

public class VisitorEnemigo extends Visitor {

	public VisitorEnemigo(Entidad e) {
		miEntidad = e;
	}
	
	public void visitar(Personaje p) {
		miEntidad.infectar(p);
		System.out.println("enemigo infectando pj");
	}

	public void visitar(Enemigo enemigo) {
		miEntidad.mover();
	}

	public void visitar(LanzamientoAliado lanzamientoAliado) {
		System.out.println("HOLAAA");
//		miEntidad.setCargaViral();
	}

	public void visitar(LanzamientoEnemigo lanzamientoEnemigo) {
		miEntidad.mover();
	}

	public void visitar(PowerUp p) {
		miEntidad.mover();
	}
	
}