package Logica;

import java.awt.event.KeyEvent;

import Visitor.Visitor;
import Visitor.VisitorPowerUp;

public class PowerUp extends Entidad {
	
	

	public PowerUp(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		label.setBounds(x, y, 70, 70);
		cargaViral = 10;
		visitor = new VisitorPowerUp(this);
		velocidad = 4;
	}

	@Override
	public void aceptar(Visitor visitor) {
		visitor.visitar(this);
	}

	@Override
	public void mover() {
		this.setPosicion(this.getPosicion().x, this.getPosicion().y + velocidad);
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
	public void reaparecer(int xAux, int yAux) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recibirCargaViral(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void infectar(Entidad e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lanzar(Entidad e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void curar(Entidad e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accionar() {
		mover();
	}

}
