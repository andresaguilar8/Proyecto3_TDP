package Lanzamiento;

import Logica.Entidad;
import Visitor.Visitor;
import Visitor.VisitorLanzamientoEnemigo;

public class LanzamientoEnemigo extends Lanzamiento {

	public LanzamientoEnemigo(int cargaViral, int x, int y) {
		super(cargaViral, x, y);
		velocidad = 2;
		this.label.setSize(4, 4);
		this.visitor = new VisitorLanzamientoEnemigo(this);
	}

	public void aceptar(Visitor visitor) {
		visitor.visitar(this);		
	}

	public void mover() {
		this.setPosicion(this.getPosicion().x, this.getPosicion().y + velocidad);
	}

	public void lanzar(Entidad e) {
		e.recibirCargaViral(cargaViral);
		this.cargaViral = 0;
	}
	
	public void recibirCargaViral(int i) {
		
	}

	public void infectar(Entidad e) {
		
	}
	
	public void accionar() {
		this.setCargaViral(0);
	}

	public void reaparecer() {
		
	}

}