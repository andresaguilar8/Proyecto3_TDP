package Lanzamiento;

import Logica.Entidad;
import Visitor.Visitor;
import Visitor.VisitorLanzamientoAliado;

public class LanzamientoAliado extends Lanzamiento {

	public LanzamientoAliado(int cargaViral, int x, int y) {
		super(cargaViral, x, y);
		velocidad = 5;
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
	
	public void lanzar(Entidad e) {
		e.recibirCura(juego.getPersonaje().getPoderDeDesinfeccion());
		System.out.println("lanzamientoAliado lanzando: "+juego.getPersonaje().getPoderDeDesinfeccion()+" de danio");
	}

	public void accionar() {
		
	}

	public void reaparecer() {
		
	}

	public void parar() {
		
	}

	public void infectar(Entidad e) {
		
	}

}