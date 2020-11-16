package PowerUp;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.ImageIcon;

import Enemigo.Enemigo;
import Logica.Entidad;
import Logica.PowerUp;
import Visitor.VisitorCuarentena;
import Visitor.VisitorPowerUp;

public class Cuarentena extends PowerUp implements Runnable {
	
	protected Map<Enemigo, Integer> mapeo;
	
	public Cuarentena(int x, int y) {
		super(x, y);
		label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/PowerUpCuarentena.png")));
		label.setBounds(x, y, 50, 50);
		visitor = new VisitorCuarentena(this);
		mapeo = new LinkedHashMap<Enemigo, Integer>();
	}

	public void run() {
		
		for(Entidad e: juego.getMapa().getListaEnemigos()) { 
			e.aceptar(visitor);
		}
		
		try {
			Thread.sleep(2000);
		}
		catch(InterruptedException e1) {
			e1.printStackTrace();
		}
		for (Map.Entry<Enemigo, Integer> entry: mapeo.entrySet()) {
			entry.getKey().setVelocidad(entry.getValue());
		}
	}
	
	public void realizarAccion() {
		(new Thread(this)).start();
	}

	public void agregarAMapeo(Enemigo e) {
		mapeo.put(e, e.getVelocidad());
	}
}
