package Lanzamiento;

import java.awt.event.KeyEvent;

import Enemigo.Alpha;
import Enemigo.Beta;
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
	
	public void aceptar(Visitor visitor) {
		visitor.visitar(this);
	}

	public void mover() {
		this.setPosicion(this.getPosicion().x, this.getPosicion().y - velocidad);
	}

	public void keyPressed(KeyEvent arg0) {
		
	}

	public void keyReleased(KeyEvent arg0) {
		
	}

	public void reaparecer(int xAux, int yAux) {
		
	}
	
	public void recibirCargaViral(int i) {
		
	}
	
	public void infectar(LanzamientoEnemigo e) {
	}
	
	public void infectar(Alpha a) {
	}
	
	public void infectar(Beta b) {
	}
	
	public void lanzar(LanzamientoEnemigo l) {
		
	}
	
	public void lanzar(Entidad e) {
		e.recibirCura(juego.getPersonaje().getPoderDeDesinfeccion());
		System.out.println("enemigo recibiendo cura");
		this.cargaViral = 0;
	}
	
	public void curar(Entidad e) {
		
	}

	public void infectar(Entidad e) {
		
	}

	public void accionar() {
		
	}

	@Override
	public void reaparecer() {
		// TODO Auto-generated method stub
		
	}

}