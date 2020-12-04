package Mapa;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import Enemigo.Enemigo;
import Logica.Entidad;
import Logica.Juego;

public abstract class Mapa {

	public Juego juego;
	protected int cantEnemigos, distribucion, cantFilas, cantColumnas, altoFila, anchoColumna, hGrilla, wGrilla;
	protected LinkedList<Entidad> listaEnemigos;
	protected Enemigo[] enemigos;
	
	public Mapa(Juego juego) {
		this.juego = juego;
		listaEnemigos = new LinkedList<Entidad>();
		hGrilla = 600;
		wGrilla = 500;
		cantColumnas = 8;
		anchoColumna = (wGrilla/cantColumnas);
	}
	
	public LinkedList<Entidad> crearEntidades() {
		LinkedList<Entidad> entidades = new LinkedList<Entidad>();
		Random ran = new Random(2);
		int aux;
		for(int i = 0; i < cantEnemigos; i++) {
			aux = ran.nextInt(2);
			Entidad nuevo;
			nuevo = enemigos[0].clonar();
			Point lugar = posicionAleatoriaEnemigos();
			nuevo.setPosicion(lugar.x, lugar.y);
			ubicacionDefinitiva(nuevo);
			if(!hayColisionesConOtrosPersonajes(nuevo, entidades)) {
				listaEnemigos.addLast(nuevo);
				entidades.addLast(nuevo);
				System.out.println("no hay colisiones");
			}
		}
		return entidades;
	}
	
	public void mapaSiguiente() {
		juego.iniciarEntidades();
		juego.inicializarPersonaje();
	}
	
	public boolean hayColisionesConOtrosPersonajes(Entidad nuevo, LinkedList<Entidad> lista) {	
		boolean colisionan = false;
		Iterator<Entidad> it = lista.iterator();
		Rectangle rNuevo = nuevo.getLabel().getBounds();
		rNuevo.height = 30;
		rNuevo.width = 80;
		Rectangle rIterador = new Rectangle();
		while(it.hasNext() && !colisionan) {
			Entidad aux = it.next();
			rIterador = aux.getLabel().getBounds();
			rIterador.height = 20; 
			rIterador.width = 80;
			if(nuevo != aux) 
				if(rNuevo.intersects(rIterador)) 
					colisionan = true;
		}
		return colisionan;
	}
	
	public void ubicacionDefinitiva(Entidad nuevo) {
		Rectangle rectangulo = nuevo.getLabel().getBounds();
		//System.out.println("rectangulo bounds: / x: "+nuevo.getLabel().getBounds().x+" y: "+nuevo.getLabel().getBounds().y);
		nuevo.setPosicion(rectangulo.x-rectangulo.width/2+60, (((int)(rectangulo.y/anchoColumna))*anchoColumna)-470);
	}
	
	public Point posicionAleatoriaEnemigos() {
		Random ranX = new Random();
		Random ranY = new Random();
		
		int x = ranX.nextInt(5);
		int y = ranY.nextInt(500);
		
		Point punto = new Point(x*100, y);
		
		return punto;
	}
	
	public boolean dentroDeGrilla(Entidad elem) {
		return elem.getPosicion().y > 180 && elem.getPosicion().y < 515 ;
	}
	
	public void eliminarEnemigo(Entidad aEliminar) {
		listaEnemigos.remove(aEliminar);
	}

	public LinkedList<Entidad> getListaEnemigos() {
		return listaEnemigos;
	}
	
}
