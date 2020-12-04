package Visitor;

import Enemigo.Enemigo;
import Lanzamiento.LanzamientoAliado;
import Lanzamiento.LanzamientoEnemigo;
import Logica.Entidad;
import Logica.Personaje;
import Logica.PowerUp;

public class VisitorPersonaje extends Visitor {
	
	public VisitorPersonaje(Entidad e) {
		miEntidad = e;
	}

	public void visitar(Enemigo e) {
		//e.infectar(miEntidad);
	}

	public void visitar(Personaje e) {

	}

	public void visitar(LanzamientoAliado lanzamientoAliado) {
		
	}

	public void visitar(LanzamientoEnemigo lanzamientoEnemigo) {
		
	}

	public void visitar(PowerUp p) {
		
	}


}
