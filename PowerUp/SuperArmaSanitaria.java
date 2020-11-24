package PowerUp;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.ImageIcon;

import Logica.Entidad;
import Logica.Entrada;
import Logica.Personaje;
import Logica.PowerUp;
import Visitor.VisitorSuperArmaSanitaria;

public class SuperArmaSanitaria extends PowerUp implements Runnable {

	protected Entry<Personaje, Integer> entry;
	protected int mejora;
	protected Map<Personaje, Integer> mapeo;
	
	public SuperArmaSanitaria(int x, int y) {
		super(x, y);
		this.label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/PowerUpCuracion.png")));
		visitor = new VisitorSuperArmaSanitaria(this);
		mapeo = new LinkedHashMap<Personaje, Integer>();
		mejora = 50;
	}
	
	public void realizarAccion() {
		(new Thread(this)).start();
	}
	
	public void run() {
		//if (juego.getListaEntidades().size() > 0)
			//for(Entidad e: juego.getListaEntidades())  
				//e.aceptar(visitor);
		for(Map.Entry<Personaje,Integer> entry: mapeo.entrySet()) {
			entry.getKey().setRutaLanzamiento("/Imagenes/superArma.gif");
		}
		try {
			Thread.sleep(4000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(Map.Entry<Personaje,Integer> entry: mapeo.entrySet()) {
			entry.getKey().setRutaLanzamiento("/Imagenes/LanzamientoPersonajeGif.gif");
			entry.getKey().setPoderDeDesinfeccion(entry.getKey().getPoderDeDesinfeccion() - mejora);
		}
	}
	
	public int getMejora() {
		return mejora;
	}
	
	public void agregarAMapeo(Personaje e) {
		mapeo.put(e, e.getPoderDeDesinfeccion());
	}
	
}
