package Visitor;

import Enemigo.Enemigo;
import Lanzamiento.LanzamientoAliado;
import Lanzamiento.LanzamientoEnemigo;
import Logica.Entidad;
import Logica.Personaje;
import Logica.PowerUp;

public class VisitorLanzamientoAliado extends Visitor {

	public VisitorLanzamientoAliado(Entidad e) {
		miEntidad = e;
	}
	
	public void visitar(Personaje e) {

	}

	public void visitar(Enemigo enemigo) {
		miEntidad.lanzar(enemigo);
		System.out.println("VisitorLanzamientoAliado visita Enemigo");
	}

	public void visitar(LanzamientoAliado lanzamientoAliado) {
		miEntidad.mover();
	}

	public void visitar(LanzamientoEnemigo lanzamientoEnemigo) {
		miEntidad.lanzar(lanzamientoEnemigo);
	}

	public void visitar(PowerUp p) {
		miEntidad.mover();
	}

}
