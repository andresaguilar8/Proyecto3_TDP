package PowerUp;

import javax.swing.ImageIcon;
import Logica.Personaje;
import Logica.PowerUp;
import Visitor.VisitorSuperArmaSanitaria;

public class SuperArmaSanitaria extends PowerUp implements Runnable {

	protected int mejora;
	protected Personaje personaje;
	
	public SuperArmaSanitaria(int x, int y) {
		super(x, y);
		this.label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/SuperArmaSanitaria.gif")));
		visitor = new VisitorSuperArmaSanitaria(this);
		mejora = 50;
	}
	
	public void realizarAccion() {
		(new Thread(this)).start();
	}
	
	public void run() {
		personaje.setRutaLanzamiento("/Imagenes/superArma.gif");
		personaje.setPoderDeDesinfeccion(personaje.getPoderDeDesinfeccion() + this.getMejora());
		try {
			Thread.sleep(4000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		personaje.setPoderDeDesinfeccion(personaje.getPoderDeDesinfeccion() - this.getMejora());
		personaje.setRutaLanzamiento("/Imagenes/LanzamientoPersonajeGif.gif");
	}
	
	public int getMejora() {
		return mejora;
	}
	
	public void declararPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}
	
}
