package Logica;

import java.awt.Point;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;

import Enemigo.Alpha;
import Visitor.Visitor;

public abstract class Entidad  {

	protected JLabel label;
	protected int cargaViral;
	protected Juego juego;
	protected Visitor visitor;
	
	public Entidad(int x, int y) {
		label = new JLabel();
		setPosicion(x,y);	
	}
	
	public JLabel getLabel() {
		return label;
	}
		
	public void setPosicion(int x, int y) {
		label.setLocation(x, y);
	}
	
	
	public Point getPosicion() {
		return label.getLocation();
	}
	
	public int getCargaViral() {
		return cargaViral;
	}

	public void setCargaViral(int cargaViral) {
		this.cargaViral = cargaViral;
	}

	public void recibirCura(int cura) {
		
	}
	
	public void setJuego(Juego juego) {
		this.juego = juego;
	}
	
	public void colisionar(Entidad e) {
		e.aceptar(visitor);
	}
	
	public abstract void aceptar(Visitor visitor);
	
	public abstract void mover();

	public abstract void keyPressed(KeyEvent arg0);

	public abstract void keyReleased(KeyEvent arg0);

	public abstract void atacar(Entidad e);

	public abstract void reaparecer(int xAux, int yAux);

	public abstract void recibirCargaViral(int i);

	public abstract void infectar(Entidad e);

	public abstract void lanzar(Entidad e);

	public abstract void curar(Entidad e);


}
