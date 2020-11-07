package Visitor;

import Enemigo.Alpha;
import Enemigo.Beta;
import Enemigo.Enemigo;
import Logica.Entidad;
import Logica.Personaje;

public abstract class Visitor {	
	
	protected Entidad miEntidad;
	
	public abstract void visitar(Personaje e);
	
	public abstract void visitar(Alpha a);
	
	public abstract void visitar(Beta b);

	public abstract void visitar(Enemigo enemigo);
	
	//public void visitar(Proyectil p) {}
	
	//public void visitar(Premio p) {}
	
}
