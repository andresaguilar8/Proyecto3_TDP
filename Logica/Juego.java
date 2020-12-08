package Logica;

import java.awt.Rectangle;
import java.util.LinkedList;
import GUI.GUI;
import GUI.HiloTiempo;
import Mapa.Mapa;
import Mapa.Mapa1;

public class Juego {

	public GUI gui;
	public LinkedList<Entidad> listaEntidades, entidadesPendientes, entidadesAeliminar, listaLanzamientos, lanzamientosPendientes;
	public Mapa mapa;
	private HiloTiempo tiempo;
	protected Personaje personaje;
	
	public Juego(GUI gui) {
		this.gui = gui;
		this.mapa = new Mapa1(this);
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
		}
	}
	
	public void inicializarPersonaje() {
		personaje = new Personaje(200, 460);
		personaje.setJuego(this);
		gui.agregarEntidad(personaje.getLabel());
		listaEntidades.add(personaje);
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
	
	public void accionar() {
		this.colisionar();
		this.agregarEntidades();
		this.eliminarEntidades();
		this.colisionar();
		this.getPersonaje().mover();
		this.getPersonaje().lanzar(null);
		this.verificarMapa();
	}
	
	private void colisionar() {
		for(int i = 0; i < listaEntidades.size();i++) {
			boolean colisionan = false;
			Entidad e1 = listaEntidades.get(i);
			for(int j = 0; j < listaEntidades.size();j++) {
				Entidad e2 = listaEntidades.get(j);
				if(e1 != e2 && verificarColision(e1,e2)) {
					e1.colisionar(e2);
					colisionan = true;
				}				
			}
			
			if(!colisionan) {
				e1.mover();
			}
			
			if (e1.getPosicion().y > 550) {
				e1.accionar();
			}
		}
	}
	
	
	
	private boolean verificarColision(Entidad entidad_1, Entidad entidad_2) {
		//el rectangulo es mas chico que el tamanio real de la entidad para que las colisiones parezcan mas reales
		Rectangle r1= entidad_1.getLabel().getBounds();
		r1.height/=2.15;
		r1.width/=3;
		Rectangle r2= entidad_2.getLabel().getBounds();
		r2.height/=2.15;
		r2.width/=2;
		return r1.intersects(r2);
	}
	
	private void eliminarEntidades() {
		if (this.personaje.getCargaViral() >= 100) {
			entidadesAeliminar.add(personaje);
		}
		
		for(Entidad e: listaEntidades) { 
			if (e != personaje)
				if(e.getCargaViral() <= 0) {
					entidadesAeliminar.add(e);
				}
			}
		eliminarAux(entidadesAeliminar);
	}
	
	private void eliminarAux(LinkedList<Entidad> lista) {
		@SuppressWarnings("unchecked")
		LinkedList<Entidad> aux = (LinkedList<Entidad>) entidadesAeliminar.clone();
		entidadesAeliminar = new LinkedList<Entidad>();
		for(Entidad e: aux) {
			gui.eliminarEnemigo(e);
			mapa.eliminarEnemigo(e);
			listaEntidades.remove(e);
		}
		entidadesAeliminar.clear();
	}
	
	public Mapa getMapa() {
		return mapa;
	}

	public LinkedList<Entidad> getListaEntidades() {
		return listaEntidades;
	}
	
	public GUI getGUI() {
		return this.gui;
	}
	
	public LinkedList<Entidad> getListaEntidadesPendientes() {
		return entidadesPendientes;
	}
	
	public LinkedList<Entidad> getListaEntidadesAeliminar() {
		return entidadesAeliminar;
	}
	
	public Personaje getPersonaje() {
		return personaje;
	}

	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}
	
	public void limpiarLista() {
		for(Entidad e: listaEntidades)
			entidadesAeliminar.add(e);
	}
	
	public void setHilo(HiloTiempo hT) {
		this.tiempo = hT;
	}
	
	private void verificarMapa() {
		if(mapa.getListaEnemigos().size() == 0) { 
			mapa.mapaSiguiente();
			if(mapa == null) {
				limpiarLista();
				gui.ganar();
				tiempo.finalizar();
			}
		}
		if(this.personaje.getCargaViral() >= 100) {
			limpiarLista();
			gui.gameOver();
			tiempo.finalizar();
		}
	}
}
