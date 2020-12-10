package Mapa;

import javax.swing.ImageIcon;
import Enemigo.Alpha;
import Enemigo.Beta;
import Enemigo.Enemigo;
import GUI.JPanelConFondo;
import Logica.Juego;

public class Mapa2 extends Mapa{
	
	public Mapa2(Juego juego) {
		super(juego);
		cantEnemigos = 20;
		enemigos = new Enemigo[cantEnemigos];
		enemigos[0] = new Alpha(0,0);
		enemigos[1] = new Beta(0,0);
		this.juego.getGUI().getContentPane().removeAll();
		JPanelConFondo nivel_2 = new JPanelConFondo(new ImageIcon(getClass().getResource("/Imagenes/mapa_2.jpg")).getImage());
		nivel_2.setBounds(500, 100, 500, 600);
		this.juego.getGUI().getContentPane().add(nivel_2);
		this.juego.getGUI().setPanelActual(nivel_2);
	}

	public void mapaSiguiente() {
		juego.limpiarLista();
		juego.setMapa(null);
	}
	
}
