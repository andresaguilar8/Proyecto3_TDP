package Mapa;

import Enemigo.Alpha;
import Enemigo.Beta;
import Enemigo.Enemigo;
import Logica.Juego;

public class Mapa1 extends Mapa{

	public Mapa1(Juego juego) {
		super(juego);
		cantEnemigos = 7;
		enemigos = new Enemigo[cantEnemigos];
		enemigos[0] = new Alpha(0,0);
		enemigos[1] = new Beta(0,0);
		this.juego.getGUI().setMapaUno();
	}
	      
	public void mapaSiguiente() {
		juego.limpiarLista();
		juego.setMapa(new Mapa2(juego));
		super.mapaSiguiente();
	}

}
