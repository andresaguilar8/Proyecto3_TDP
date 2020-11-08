package Visitor;

import Enemigo.Alpha;
import Enemigo.Beta;
import Enemigo.Enemigo;
import Lanzamiento.LanzamientoAliado;
import Lanzamiento.LanzamientoEnemigo;
import Logica.Entidad;
import Logica.Personaje;

public class VisitorEnemigo extends Visitor {

	public VisitorEnemigo(Entidad e) {
		miEntidad = e;
	}
	
	@Override
	public void visitar(Personaje p) {
		miEntidad.infectar(p);
		System.out.println("enemigo infectando al personaje");
	}

	@Override
	public void visitar(Alpha a) 
	{
		
	}
	
	public void visitar(Beta b) 
	{
		
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
	

	
}
