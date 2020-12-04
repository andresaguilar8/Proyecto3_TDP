package Mapa;

import javax.swing.ImageIcon;
import Enemigo.Alpha;
import Enemigo.Beta;
import Enemigo.Enemigo;
import GUI.JPanelConFondo;
import Logica.Juego;

public class Mapa1 extends Mapa{

	public Mapa1(Juego juego) {
		super(juego);
		cantEnemigos = 10;
		enemigos = new Enemigo[cantEnemigos];
		enemigos[0] = new Alpha(0,0);
		enemigos[1] = new Beta(0,0);
		JPanelConFondo nivel_1 = new JPanelConFondo(new ImageIcon(getClass().getResource("/Imagenes/mapa_1.jpeg")).getImage());
		nivel_1.setBounds(500, 100, 500, 600);
		this.juego.getGUI().getContentPane().add(nivel_1);
		this.juego.getGUI().setPanelActual(nivel_1);
	}
	
	public void mapaSiguiente() {
		juego.limpiarLista();
		juego.setMapa(new Mapa2(juego));
		super.mapaSiguiente();
	}

}
