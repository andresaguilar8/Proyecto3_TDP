package Estado;

import Enemigo.Enemigo;

public class EnemigoVeloz extends EstadoEnemigo {
	
	public EnemigoVeloz(Enemigo e) {
		super(e);
		this.velocidad = 4;
	}

	public void movilizar() {
		enemigo.movilizar(velocidad);
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

}