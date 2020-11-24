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
	
	public void visitar(Personaje e) {

	}

	public void visitar(Alpha a) {
		miEntidad.lanzar(a);
		a.recibirCura(100);
		System.out.println("Alpha recibiendo cura");
	}

	public void visitar(Beta b) {
		miEntidad.lanzar(b);
		b.recibirCura(100);
		System.out.println("Beta recibiendo cura");
	}

	public void visitar(Enemigo enemigo) {
		miEntidad.lanzar(enemigo);
		System.out.println("VisitorLanzamientoAliado visita Enemigo");
	}

	public void visitar(LanzamientoAliado lanzamientoAliado) {
		
	}

	public void visitar(LanzamientoEnemigo lanzamientoEnemigo) {
		miEntidad.lanzar(lanzamientoEnemigo);
	}

	public void visitar(PowerUp p) {
		
	}

}
