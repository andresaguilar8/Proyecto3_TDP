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
		miEntidad.setCargaViral(0);
		miEntidad.lanzar(enemigo);
	}

	public void visitar(LanzamientoAliado lanzamientoAliado) {
		
	}

	public void visitar(LanzamientoEnemigo lanzamientoEnemigo) {
		miEntidad.lanzar(lanzamientoEnemigo);
		this.miEntidad.setCargaViral(0);
	}

	public void visitar(PowerUp p) {
		miEntidad.mover();
	}

}
