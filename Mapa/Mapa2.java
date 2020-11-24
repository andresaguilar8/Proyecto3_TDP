package Mapa;

import Enemigo.Alpha;
import Enemigo.Beta;
import Enemigo.Enemigo;
import Logica.Juego;

public class Mapa2 extends Mapa{
	
	public Mapa2(Juego juego) {
		super(juego);
		cantEnemigos = 20;
		enemigos = new Enemigo[cantEnemigos];
		enemigos[0] = new Alpha(0,0);
		enemigos[1] = new Beta(0,0);
	}

}