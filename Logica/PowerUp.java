package Logica;

import Visitor.Visitor;
import Visitor.VisitorCuracion;

public class PowerUp extends Entidad {

	public PowerUp(int x, int y) {
		super(x, y);
		label.setBounds(x, y, 40, 40);
		cargaViral = 10;
		visitor = new VisitorCuracion(this);
		velocidad = 10;
		alto = 40;
		ancho = 40;
	}

	public void aceptar(Visitor visitor) {
		visitor.visitar(this);
	}

	public void mover() {
		this.setPosicion(this.getPosicion().x, this.getPosicion().y + velocidad);
	}

	public void accionar() {
		this.setCargaViral(0);
	}
	
	public void recibirCargaViral(int i) {
		
	}

	public void infectar(Entidad e) {
		
	}

	public void lanzar(Entidad e) {
		
	}

}