package Estado;

import Enemigo.Enemigo;

public class EnemigoNormal extends EstadoEnemigo{

	public EnemigoNormal(Enemigo e) {
		super(e);
		this.velocidad = 2;
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