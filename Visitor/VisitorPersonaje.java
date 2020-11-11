package Visitor;

import Enemigo.Alpha;
import Enemigo.Beta;
import Enemigo.Enemigo;
import Lanzamiento.LanzamientoAliado;
import Lanzamiento.LanzamientoEnemigo;
import Logica.Entidad;
import Logica.Personaje;

public class VisitorPersonaje extends Visitor {
	
	public VisitorPersonaje(Entidad e) {
		miEntidad = e;
	}

	public void visitar(Enemigo e) {
		
	}
	
	public void visitar(Alpha a) {
		
	}
	
	public void visitar(Beta b) {
		
	}

	public void visitar(Personaje e) {

	}

	public void visitar(LanzamientoAliado lanzamientoAliado) {
		
	}

	public void visitar(LanzamientoEnemigo lanzamientoEnemigo) {
		
	}


}
