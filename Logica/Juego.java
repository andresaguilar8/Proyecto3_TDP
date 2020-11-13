package Logica;

import java.awt.Point;
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
	public LinkedList<Entidad> listaEntidades, entidadesPendientes, entidadesAeliminar, listaLanzamientos, lanzamientosPendientes;
	public Mapa mapa;
	private HiloTiempo tiempo;
	protected Personaje personaje;
	
	public Juego(GUI gui) {
		this.gui = gui;
		this.mapa = new MapaUno(this);
		listaEntidades= new LinkedList<Entidad>();
		entidadesPendientes = new LinkedList<Entidad>();
		entidadesAeliminar = new LinkedList<Entidad>();
		lanzamientosPendientes = new LinkedList<Entidad>();
		listaLanzamientos = new LinkedList<Entidad>();
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
			listaEntidades.addLast(e);
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
		colisionarConPersonaje();
		colisionarEnemigosConLanzamientos();
	}
	
	private void colisionarConPersonaje() {
		int xAux, yAux;
		boolean collidedGeneral = false;
		for (int i = 0; i < listaEntidades.size(); i++) {
			Entidad entidad_1 = listaEntidades.get(i);
				if(verificarColision(entidad_1,personaje)) {
					entidad_1.colisionar(personaje);
					collidedGeneral=true;
				}				
				
			if(!collidedGeneral) {
				entidad_1.mover();
			}
			if (entidad_1.getPosicion().y > 480 ) {
				//System.out.println("paso los 480");
				Point posicion = this.mapa.posicionAleatoriaEnemigos();
				entidad_1.reaparecer(posicion.x, posicion.y);
			}
			collidedGeneral = false;
		}
	}
	
	private void colisionarEnemigosConLanzamientos() {

		for(int i = 0; i < listaEntidades.size(); i++) {	
			boolean collidedGeneral = false;
			Entidad entidad_1 = listaEntidades.get(i);
			for(int j = 0; j < listaEntidades.size(); j++) {
				Entidad entidad_2 = listaEntidades.get(j);
				if(entidad_1 != entidad_2 && verificarColision(entidad_1 ,entidad_2)) {
					entidad_1.colisionar(entidad_2);
					collidedGeneral = true;
				}	
				if (entidad_1.getPosicion().y > 550) {
					System.out.println("entidad paso los 500 de y");
					entidad_1.accionar();
				}
			}
			if(!collidedGeneral) {
				entidad_1.mover();
			}
		}
			
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
	
	public void eliminarEntidades() {
		//if (this.personaje.getCargaViral() >= 100) {
			//entidadesAeliminar.add(personaje);
		//}
		
		for(Entidad e: listaEntidades) {     
			if(e.getCargaViral() <= 0) {
				entidadesAeliminar.add(e);
			}
		}
		//si la posicion es por debajo del personaje debo eliminar la entidad.
		// metodo "accionar" que accione de acuerdo, si es un "enemigo" deberia re-aparecer.
		eliminarAux(entidadesAeliminar);
	}
	
	private void eliminarAux(LinkedList<Entidad> lista) {
		LinkedList<Entidad> aux= (LinkedList<Entidad>) entidadesAeliminar.clone();
		entidadesAeliminar = new LinkedList<Entidad>();
		for(Entidad e: aux) {
			gui.eliminarEnemigo(e);
			mapa.eliminarEnemigo(e);
			listaEntidades.remove(e);
		}
		entidadesAeliminar.clear();
	}
	
	public LinkedList<Entidad> getListaEntidades() {
		for (Entidad e: listaEntidades)
			System.out.println("Lista entidades: "+e);
		return listaEntidades;
	}
	
	public LinkedList<Entidad> getListaEntidadesPendientes() {
		for (Entidad e: entidadesPendientes)
			System.out.println("Lista entidades pendientes: "+e);
		return entidadesPendientes;
	}
	
	public LinkedList<Entidad> getListaEntidadesAeliminar() {
		for (Entidad e: entidadesAeliminar)
			System.out.println("Lista entidades a eliminar: "+e);
		return entidadesAeliminar;
	}
	
	public Entidad getPersonaje() {
		return personaje;
	}
	
}
