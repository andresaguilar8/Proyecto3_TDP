package Mapa;

import Enemigo.Alpha;
import Enemigo.Beta;
import Enemigo.Enemigo;
import Logica.Juego;

public class MapaUno extends Mapa{

	public MapaUno(Juego juego) {
		super(juego);
		cantEnemigos = 5;
		enemigos = new Enemigo[cantEnemigos];
		enemigos[0] = new Alpha(0,0);
		enemigos[1] = new Beta(0,0);
//		distribucion = 1500;
	}

}
