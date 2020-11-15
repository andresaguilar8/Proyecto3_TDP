package Visitor;

import Enemigo.Alpha;
import Enemigo.Beta;
import Enemigo.Enemigo;
import Lanzamiento.LanzamientoAliado;
import Lanzamiento.LanzamientoEnemigo;
import Logica.Personaje;
import Logica.PowerUp;

public class VisitorPowerUp extends Visitor {
	
	protected PowerUp powerUp;

	public VisitorPowerUp(PowerUp p) {
		powerUp = p;
	}
	
	@Override
	public void visitar(Personaje e) {
		powerUp.curar(e);
		System.out.println("personaje curado");
		powerUp.setCargaViral(0);
	}

	@Override
	public void visitar(Alpha a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Beta b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Enemigo enemigo) {
		// TODO Auto-generated method stub
		
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
