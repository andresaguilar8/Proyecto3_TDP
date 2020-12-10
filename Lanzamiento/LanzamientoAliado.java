package Lanzamiento;

import Logica.Entidad;
import Visitor.Visitor;
import Visitor.VisitorLanzamientoAliado;

public class LanzamientoAliado extends Lanzamiento {

	public LanzamientoAliado(int cargaViral, int x, int y) {
		super(cargaViral, x, y);
		velocidad = 5;
		this.label.setSize(4, 4);
		ancho = 25;
		alto = 7;
		this.visitor = new VisitorLanzamientoAliado(this);
	}
	
	public void aceptar(Visitor visitor) {
		visitor.visitar(this);
	}

	public void mover() {
		this.setPosicion(this.getPosicion().x, this.getPosicion().y - velocidad);
	}

	public void lanzar(Entidad e) {
		e.recibirCura(juego.getPersonaje().getPoderDeDesinfeccion());
		this.cargaViral = 0;
	}
	
	public void recibirCargaViral(int i) {
		
	}
	
	public void accionar() {
		
	}

	public void infectar(Entidad e) {
		
	}

}