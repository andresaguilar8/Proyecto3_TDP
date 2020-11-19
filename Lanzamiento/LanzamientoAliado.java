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
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void reaparecer(int xAux, int yAux) {
		// TODO Auto-generated method stub
		
	}
	public void recibirCargaViral(int i) {
		// TODO Auto-generated method stub
		
	}
	
	public void infectar(LanzamientoEnemigo e) {
		e.recibirCura(100);
	}
	
	public void infectar(Alpha a) {
		a.recibirCura(100);
		System.out.println("alpha recibiendo cura");
	}
	
	public void infectar(Beta b) {
		b.recibirCura(100);
		System.out.println("beta recibiendo cura");
	}
	
	public void lanzar(LanzamientoEnemigo l) {
	}
	
	@Override
	public void lanzar(Entidad e) {
		e.recibirCura(40);
		System.out.println("enemigo recibiendo cura");
		this.cargaViral = 0;
	}
	
	@Override
	public void curar(Entidad e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void infectar(Entidad e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accionar() {
		// TODO Auto-generated method stub
		
	}

}
