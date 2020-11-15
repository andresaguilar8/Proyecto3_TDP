package Visitor;

import Enemigo.Alpha;
import Enemigo.Beta;
import Enemigo.Enemigo;
import Lanzamiento.LanzamientoAliado;
import Lanzamiento.LanzamientoEnemigo;
import Logica.Personaje;
import Logica.PowerUp;
import PowerUp.Cuarentena;

public class VisitorCuarentena extends Visitor {
	
	protected Cuarentena power;
	
	public VisitorCuarentena(Cuarentena cuarentena) {
		this.power = cuarentena;
	}

	@Override
	public void visitar(Personaje e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Alpha a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Beta b) {
		// TODO Auto-generated method stub
		
	}

	public void visitar(Enemigo enemigo) {
		power.agregarAMapeo(enemigo);
		enemigo.setVelocidad(0);
	}

	@Override
	public void visitar(LanzamientoAliado lanzamientoAliado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(LanzamientoEnemigo lanzamientoEnemigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(PowerUp p) {
		// TODO Auto-generated method stub
		
	}

}
