package Logica;

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
		for (int i = 0; i < listaEntidades.size(); i++) {
			Entidad entidad = listaEntidades.get(i);
			entidad.mover();
		}
	}
	
}
