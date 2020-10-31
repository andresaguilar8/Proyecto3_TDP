package Logica;

import java.awt.Point;

import javax.swing.JLabel;

public abstract class Entidad  {

	protected JLabel label;
	protected int cargaViral;
	protected Juego juego;
	
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
	
	public abstract void mover();
}
