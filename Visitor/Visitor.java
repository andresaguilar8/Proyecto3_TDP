package Visitor;

import Enemigo.Enemigo;
import Lanzamiento.LanzamientoAliado;
import Lanzamiento.LanzamientoEnemigo;
import Logica.Entidad;
import Logica.Personaje;
import Logica.PowerUp;

public abstract class Visitor {	
	
	protected Entidad miEntidad;
	
	public abstract void visitar(Personaje e);

	public abstract void visitar(Enemigo enemigo);

	public abstract void visitar(LanzamientoAliado lanzamientoAliado);

	public abstract void visitar(LanzamientoEnemigo lanzamientoEnemigo);
	
	public abstract void visitar(PowerUp p);
	
}
