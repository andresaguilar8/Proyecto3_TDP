package Visitor;

import Enemigo.Enemigo;
import Lanzamiento.LanzamientoAliado;
import Lanzamiento.LanzamientoEnemigo;
import Logica.Entidad;
import Logica.Personaje;
import Logica.PowerUp;

public class VisitorLanzamientoEnemigo extends Visitor {

	public VisitorLanzamientoEnemigo(Entidad e) {
		miEntidad = e;
	}
	
	public void visitar(Personaje e) {
		miEntidad.lanzar(e);
	}

	public void visitar(Enemigo enemigo) {
		miEntidad.mover();
	}

	public void visitar(LanzamientoAliado lanzamientoAliado) {
		
	}

	public void visitar(LanzamientoEnemigo lanzamientoEnemigo) {
		miEntidad.mover();
	}

	public void visitar(PowerUp p) {
		miEntidad.mover();
	}

}
