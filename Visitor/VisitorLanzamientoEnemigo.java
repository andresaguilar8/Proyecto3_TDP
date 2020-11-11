package Visitor;

import Enemigo.Alpha;
import Enemigo.Beta;
import Enemigo.Enemigo;
import Lanzamiento.LanzamientoAliado;
import Lanzamiento.LanzamientoEnemigo;
import Logica.Entidad;
import Logica.Personaje;

public class VisitorLanzamientoEnemigo extends Visitor {

	public VisitorLanzamientoEnemigo(Entidad e) {
		miEntidad = e;
	}
	
	@Override
	public void visitar(Personaje e) {
		miEntidad.lanzar(e);
		System.out.println("enemigo infectando al jugador");
	}

	@Override
	public void visitar(Alpha a) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitar(Beta b) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitar(Enemigo enemigo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitar(LanzamientoAliado lanzamientoAliado) {
		miEntidad.recibirCura(100);
	}

	@Override
	public void visitar(LanzamientoEnemigo lanzamientoEnemigo) {
		// TODO Auto-generated method stub

	}

}
