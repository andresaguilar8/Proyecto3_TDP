package GUI;

import Logica.Juego;

public class HiloTiempo extends Thread {
	
	private Juego juego;
	private volatile boolean hayJuego;
	
	public HiloTiempo(Juego juego) {
		this.juego = juego;
		this.hayJuego = true;
	}
	
	public void run() {
		while(hayJuego){
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
			
			juego.accionar();
		}
	}
	
	public void finalizar() {
		this.hayJuego = false;
	}
}