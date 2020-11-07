package Lanzamiento;

import java.awt.event.KeyEvent;

import Logica.Entidad;
import Visitor.Visitor;
import Visitor.VisitorLanzamientoEnemigo;

public class LanzamientoEnemigo extends Lanzamiento {

	public LanzamientoEnemigo(int cargaViral, int x, int y) {
		super(cargaViral, x, y);
		velocidad = 3;
		this.visitor = new VisitorLanzamientoEnemigo(this);
	}

	@Override
	public void aceptar(Visitor visitor) {
		visitor.visitar(this);
		
	}

	public void mover() {
		this.setPosicion(this.getPosicion().x, this.getPosicion().y + velocidad);
//		if(this.getPosicion().x > 1200 || this.getPosicion().y < 0)
//			this.vida=0;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atacar(Entidad e) {
		// TODO Auto-generated method stub
		
	}

}
