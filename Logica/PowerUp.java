package Logica;

import java.awt.event.KeyEvent;

import Visitor.Visitor;
import Visitor.VisitorCuracion;

public class PowerUp extends Entidad {

	public PowerUp(int x, int y) {
		super(x, y);
		label.setBounds(x, y, 70, 70);
		cargaViral = 10;
		visitor = new VisitorCuracion(this);
		velocidad = 4;
	}

	public void aceptar(Visitor visitor) {
		visitor.visitar(this);
	}

	public void mover() {
		this.setPosicion(this.getPosicion().x, this.getPosicion().y + velocidad);
	}

	public void keyPressed(KeyEvent arg0) {
		
	}

	public void keyReleased(KeyEvent arg0) {
		
	}

	public void reaparecer(int xAux, int yAux) {
		
	}

	public void recibirCargaViral(int i) {
		
	}

	public void infectar(Entidad e) {
		
	}

	public void lanzar(Entidad e) {
		
	}

	public void curar(Entidad e) {
		
	}

	public void accionar() {
		this.setCargaViral(0);
	}

	@Override
	public void reaparecer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void parar() {
		// TODO Auto-generated method stub
		
	}

}
