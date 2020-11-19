package Estado;

import Logica.Personaje;

public abstract class EstadoPersonaje extends Estado {
	protected Personaje personaje;
	
	public EstadoPersonaje(Personaje a) {
		personaje=a;
	}
	
	public abstract void aumentarCura(int d);
	public abstract void atacar();
	public abstract void parar();

}