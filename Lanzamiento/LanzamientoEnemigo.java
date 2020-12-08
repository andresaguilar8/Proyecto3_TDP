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

	public void recibirCargaViral(int i) {
		
	}

	public void infectar(Entidad e) {
		
	}

	public void lanzar(Entidad e) {
		e.recibirCargaViral(7);
		System.out.println("lanzamiento enemigo infectando al personaje");
		this.cargaViral = 0;
	}

	public void accionar() {
		this.setCargaViral(0);
	}

	public void reaparecer() {
		
	}

	@Override
	public void parar() {
		// TODO Auto-generated method stub
		
	}

}