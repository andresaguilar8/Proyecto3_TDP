package Visitor;

import Enemigo.Alpha;
import Enemigo.Beta;
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
	
	@Override
	public void visitar(Personaje e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitar(Alpha a) {
		miEntidad.lanzar(a);
		a.recibirCura(100);
		System.out.println("Alpha recibiendo cura");
	}

	@Override
	public void visitar(Beta b) {
		miEntidad.lanzar(b);
		b.recibirCura(100);
		System.out.println("Beta recibiendo cura");
	}

	@Override
	public void visitar(Enemigo enemigo) {
		miEntidad.lanzar(enemigo);
		System.out.println("Visitar Enemigo enemigo");
		// TODO Auto-generated method stub

	}

	@Override
	public void visitar(LanzamientoAliado lanzamientoAliado) {
		
	}

	@Override
	public void visitar(LanzamientoEnemigo lanzamientoEnemigo) {
		System.out.println("asasasas");
		miEntidad.lanzar(lanzamientoEnemigo);
	}

	@Override
	public void visitar(PowerUp p) {
		// TODO Auto-generated method stub
		
	}

}
