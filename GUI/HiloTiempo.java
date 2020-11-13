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
			
			juego.agregarEntidades();
			juego.eliminarEntidades();
			juego.colisionar();
			juego.getPersonaje().mover();
			juego.getPersonaje().lanzar(null);

			//juego.getListaEntidades();
			//juego.getListaEntidadesAeliminar();
			//juego.getListaEntidadesPendientes();
			//juego.verificarMapa();
		}
	}
	
	public void finalizar() {
		hayJuego = false;
	}
}