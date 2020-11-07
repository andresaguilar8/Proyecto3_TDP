package Visitor;

import Enemigo.Alpha;
import Enemigo.Beta;
import Enemigo.Enemigo;
import Logica.Entidad;
import Logica.Personaje;

public class VisitorPersonaje extends Visitor {
	
	public VisitorPersonaje(Entidad e) {
		miEntidad = e;
	}

	@Override
	public void visitar(Enemigo e) {
		miEntidad.atacar(e);
	}
	
	public void visitar(Alpha a) {
		miEntidad.atacar(a);
	}
	
	public void visitar(Beta b) {
		miEntidad.atacar(b);
	}

	@Override
	public void visitar(Personaje e) {
		
	}


}
