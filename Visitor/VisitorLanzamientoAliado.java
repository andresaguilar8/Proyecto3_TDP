package Visitor;

import Enemigo.Alpha;
import Enemigo.Beta;
import Enemigo.Enemigo;
import Lanzamiento.LanzamientoAliado;
import Lanzamiento.LanzamientoEnemigo;
import Logica.Entidad;
import Logica.Personaje;

public class VisitorLanzamientoAliado extends Visitor {

	public VisitorLanzamientoAliado(Entidad e) {
		miEntidad = e;
	}
	
	@Override
	public void visitar(Personaje e) {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

	}

	@Override
	public void visitar(LanzamientoEnemigo lanzamientoEnemigo) {
		// TODO Auto-generated method stub

	}

}
