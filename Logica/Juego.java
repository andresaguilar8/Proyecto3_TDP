package Logica;

import java.awt.Rectangle;
import java.util.LinkedList;

import javax.swing.JLabel;

import Enemigo.Alpha;
import GUI.GUI;
import GUI.HiloTiempo;
import Mapa.Mapa;
import Mapa.MapaUno;

public class Juego {

	public GUI gui;
	public LinkedList<Entidad> listaEntidades, entidadesPendientes;
	public Mapa mapa;
	private HiloTiempo tiempo;
	protected Personaje personaje;
	
	public Juego(GUI gui) {
		this.gui = gui;
		this.mapa = new MapaUno(this);
		listaEntidades= new LinkedList<Entidad>();
		entidadesPendientes = new LinkedList<Entidad>();
		iniciarEntidades();
		inicializarPersonaje();
	}
	
	public void iniciarEntidades() {
		listaEntidades = this.mapa.crearEntidades();
		for(Entidad e: listaEntidades) {
			e.setJuego(this);
			gui.agregarEntidad(e.getLabel());
			System.out.println("iniciar entidades de juego");
		}
	}
	
	public void inicializarPersonaje() {
		personaje = new Personaje(200, 460);
		personaje.setJuego(this);
		gui.agregarEntidad(personaje.getLabel());
		System.out.println("inicializar personaje");
		//listaEntidades.add(personaje);
	}
	
	
	public void agregarEntidades() {
		for(Entidad e: entidadesPendientes) {
			//listaEntidades.addLast(e);
			gui.agregarEntidad(e.getLabel());
		}
		entidadesPendientes.clear();
	}
	
	public void agregarObjetos(Entidad e) {
		entidadesPendientes.addLast(e);
		e.setJuego(this);
	}
	
	public void setTiempo(HiloTiempo tiempo) {
		this.tiempo = tiempo;
	}
	
	public void colisionar() {
		boolean collidedGeneral = false;
		for (int i = 0; i < listaEntidades.size(); i++) {
			Entidad entidad_1 = listaEntidades.get(i);
			
				if (colisionanEnColumna(entidad_1, personaje)) {
					entidad_1.colisionar(personaje);
					System.out.println("se intersectan en columna");
//					entidad_1.atacar(personaje);
				}
				else
					if (verificarColision(entidad_1, personaje)) {
						entidad_1.colisionar(personaje);
						collidedGeneral = true;
						System.out.println("se intersectan");
					}
						
					if (!collidedGeneral)
						entidad_1.mover();
					collidedGeneral = false;
			}
			
			for (int j = 0; j < entidadesPendientes.size(); j++) {
				Entidad entidad = entidadesPendientes.get(j);
//				entidad.mover();
				//if (verificarColision(entidad, personaje)) {
					//entidad.colisionar(personaje);
					//System.out.println("entidad pendiente colisiono con el jugador");
				//}

			}
			
				
//			if (verificarColision(entidad_1, personaje)) {
//						entidad_1.colisionar(personaje);
//						//personaje.colisionar(entidad_1);
//						collidedGeneral = true;
//			}	
						
			//System.out.println(listaEntidades.size());
//			if(!collidedGeneral) {
//				entidad_1.mover();
//			}
			
		}
	

	private boolean colisionanEnColumna(Entidad entidad_1, Entidad entidad_2) {
		Rectangle r1 = entidad_1.getLabel().getBounds();
		Rectangle r2 = entidad_2.getLabel().getBounds();
		r1.height += 500;
		if (r1.intersects(r2)) {
			System.out.println("se intersectan");
			return true;
		}
		else
			return false;
	}
	
	private boolean verificarColision(Entidad entidad_1, Entidad entidad_2) {
		//el rectangulo es mas chico que el tamanio real de la entidad para que las colisiones parezcan mas reales
		Rectangle r1= entidad_1.getLabel().getBounds();
		r1.height/=2.15;
		r1.width/=2;
		Rectangle r2= entidad_2.getLabel().getBounds();
		r2.height/=2.15;
		r2.width/=2;
		return r1.intersects(r2);
	}
	
	public Entidad getPersonaje() {
		return personaje;
	}
	
}
