package Logica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Personaje extends Entidad {
	
	private int cargaViral;

	public Personaje(int x, int y) {
		super(x, y);
		label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/personaje.png")));
		this.label.setSize(100, 100);
		cargaViral = 0;
	}
	
	public int getCargaViral() {
		return cargaViral;
	}

	public void aumentarCargaViral(int carga) {
		cargaViral+=carga;
	}
	
	public void desinfectar(Entidad e) {
		//e.recibirCura(10);
	}

	public void mover() {
		
	}
	
	public void setLabel(JLabel label) {
		this.label = label;
	}
	
}
