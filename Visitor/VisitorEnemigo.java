package Visitor;

import Enemigo.Alpha;
import Enemigo.Beta;
import Enemigo.Enemigo;
import Logica.Entidad;
import Logica.Personaje;

public class VisitorEnemigo extends Visitor {

	public VisitorEnemigo(Entidad e) {
		miEntidad = e;
	}
	
	@Override
	public void visitar(Personaje p) 
	{
		//this.entidad.atacar(p);
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
	
//	public void visitar(Premio b) 
//	{
//		entidad.atacar(b);
//	}
	
}
