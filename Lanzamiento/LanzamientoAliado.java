package Lanzamiento;

import java.awt.event.KeyEvent;

import Logica.Entidad;
import Visitor.Visitor;
import Visitor.VisitorLanzamientoAliado;

public class LanzamientoAliado extends Lanzamiento{

	public LanzamientoAliado(int cargaViral, int x, int y) {
		super(cargaViral, x, y);
		velocidad = 2;
		this.label.setSize(4, 4);
		this.visitor = new VisitorLanzamientoAliado(this);
		cargaViral = 100;
	}
	
	@Override
	public void aceptar(Visitor visitor) {
		visitor.visitar(this);
		
	}

	@Override
	public void mover() {
		this.setPosicion(this.getPosicion().x, this.getPosicion().y - velocidad);
		
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
		e.recibirCura(20);
		System.out.println("enemigo recibiendo cura");
		this.cargaViral = 0;
	}

	@Override
	public void curar(Entidad e) {
		// TODO Auto-generated method stub
		
	}

}
