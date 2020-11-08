package Lanzamiento;

import java.awt.event.KeyEvent;

import Logica.Entidad;
import Logica.Personaje;
import Visitor.Visitor;
import Visitor.VisitorLanzamientoEnemigo;

public class LanzamientoEnemigo extends Lanzamiento {

	public LanzamientoEnemigo(int cargaViral, int x, int y) {
		super(cargaViral, x, y);
		velocidad = 2;
		this.label.setSize(4, 4);
		this.visitor = new VisitorLanzamientoEnemigo(this);
		cargaViral = 10;
	}

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
	public void atacar(Entidad p) {
//		p.recibirCargaViral(10);
//		this.setCargaViral(0);
//		System.out.println("lanzamiento generando carga viral");
	}

	@Override
	public void reaparecer(int xAux, int yAux) {
		
		
	}

	@Override
	public void recibirCargaViral(int i) {
		// TODO Auto-generated method stub
		
	}

	public void infectar(Entidad e) {
		e.recibirCargaViral(10);
		this.setCargaViral(0);
		System.out.println("carga viral del jugador: "+e.getCargaViral());
	}

	public void lanzar(Entidad e) {
		e.recibirCargaViral(10);
		System.out.println("lanzamiento enemigo infectando al personaje");
		this.cargaViral = 0;
	}

	@Override
	public void curar(Entidad e) {
		// TODO Auto-generated method stub
		
	}
	

}
