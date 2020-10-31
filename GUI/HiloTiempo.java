package GUI;

import Logica.Juego;

public class HiloTiempo extends Thread{
	private Juego juego;
	private volatile boolean hayJuego;
	
	public HiloTiempo(Juego juego) {
		this.juego = juego;
		hayJuego = true;
	}
	
	public void run() {
		while(hayJuego){
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
			
//			juego.inicializarPersonaje();
			juego.agregarEntidades();
			//juego.eliminarEntidades();
			juego.colisionar();
			//juego.verificarMapa();
		}
	}
	
	public void finalizar() {
		hayJuego = false;
	}
}