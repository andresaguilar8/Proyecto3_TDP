package Visitor;

import Enemigo.Alpha;
import Enemigo.Beta;
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

	public void visitar(Alpha a) {

	}

	public void visitar(Beta b) {

	}

	public void visitar(Enemigo enemigo) {
		miEntidad.mover();
	}

	public void visitar(LanzamientoAliado lanzamientoAliado) {
		miEntidad.recibirCura(100);
	}

	public void visitar(LanzamientoEnemigo lanzamientoEnemigo) {
		miEntidad.mover();
	}

	public void visitar(PowerUp p) {
		
	}

}
