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
			nuevo = enemigos[aux].clonar();
			Point lugar = posicionAleatoriaEnemigos();
			nuevo.setPosicion(lugar.x, lugar.y);
			ubicacionDefinitiva(nuevo);
			if(!hayColisionesConOtrosPersonajes(nuevo, entidades)) {
				listaEnemigos.addLast(nuevo);
				entidades.addLast(nuevo);
				System.out.println("no hay colisiones");
			}
			//else {
				//i--;
				//nuevo=null;
			}
//	}
//		for(int i=0; i<cantObstaculos-1; i++) {
//			aux=ran.nextInt(cantObstaculos-1);
//			GameObject nuevo;
//			nuevo=obstaculos[aux].clonar();
//			Point lugar=posicionAleatoriaObstaculos();
//			nuevo.setPos(lugar.x, lugar.y);
//			ubicacionDefinitiva(nuevo);
//			if(!hayColisionesConOtrosPersonajes(nuevo, entidades)) {
//				entidades.addLast(nuevo);
//			}
//			else {
//				i--;
//				nuevo=null;
			
		
		return entidades;
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
		System.out.println("rectangulo bounds: / x: "+nuevo.getLabel().getBounds().x+" y: "+nuevo.getLabel().getBounds().y);
		nuevo.setPosicion(rectangulo.x-rectangulo.width/2, (((int)(rectangulo.y/anchoColumna))*anchoColumna)-350);
	}
	
	public Point posicionAleatoriaEnemigos() {
		Random ranX = new Random();
		Random ranY = new Random();
		
		int x = ranX.nextInt(4);
		int y = ranY.nextInt(500);
		
		Point punto = new Point(x*100, y);
		
		return punto;
	}
	
	public boolean dentroDeGrilla(Entidad elem) {
		return elem.getPosicion().y>180 && elem.getPosicion().y<515 ;
	}
	
}
