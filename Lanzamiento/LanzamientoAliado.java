package Lanzamiento;

import Logica.Entidad;
import Visitor.Visitor;
import Visitor.VisitorLanzamientoAliado;

public class LanzamientoAliado extends Lanzamiento {

	public LanzamientoAliado(int cargaViral, int x, int y) {
		super(cargaViral, x, y);
		velocidad = 10;
		this.label.setSize(4, 4);
		this.visitor = new VisitorLanzamientoAliado(this);
	}
	
	public void aceptar(Visitor visitor) {
		visitor.visitar(this);
	}

	public void mover() {
		this.setPosicion(this.getPosicion().x, this.getPosicion().y - velocidad);
	}

	public void reaparecer(int xAux, int yAux) {
		
	}
	
	public void recibirCargaViral(int i) {
		
	}
	
	public void lanzar(LanzamientoEnemigo l) {
		
	}
	
	public void lanzar(Entidad e) {
		this.cargaViral = 0;
		e.recibirCura(juego.getPersonaje().getPoderDeDesinfeccion());
		System.out.println("enemigo recibiendo: "+juego.getPersonaje().getPoderDeDesinfeccion()+" de danio");
	}
	
	public void curar(Entidad e) {
		
	}

	public void infectar(Entidad e) {
		
	}

	public void accionar() {
		
	}

	public void reaparecer() {
		
	}

}