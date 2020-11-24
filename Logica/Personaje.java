package Logica;

import java.awt.Point;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Lanzamiento.Arma;
import Lanzamiento.ArmaAliado;
import Lanzamiento.LanzamientoAliado;
import Lanzamiento.LanzamientoEnemigo;
import Visitor.Visitor;
import Visitor.VisitorPersonaje;

public class Personaje extends Entidad {
	
	private int cargaViral;
	protected int desplazamientoX;
	protected int velocidad;
	protected Arma arma;
	protected volatile boolean curar;
	protected int contador;
	protected int poderDeDesinfeccion;
	protected volatile String rutaLanzamiento;

	public Personaje(int x, int y) {
		super(x, y);
		label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/personaje.png")));
		this.label.setSize(90, 90);
		cargaViral = 1;
		velocidad = 5;
		visitor = new VisitorPersonaje(this);
		arma = new ArmaAliado();
		curar = false;
		contador = 0;
		poderDeDesinfeccion = 100;
		rutaLanzamiento = "/Imagenes/LanzamientoPersonajeGif.gif";
	}
	
	public int getCargaViral() {
		return cargaViral;
	} 
	
	public void setRutaLanzamiento(String rutaLanzamiento) {
		this.rutaLanzamiento = rutaLanzamiento;
	}
	
	public void recibirCargaViral(int carga) {
		cargaViral += carga;
	}
	
	public void setPoderDeDesinfeccion(int valor) {
		this.poderDeDesinfeccion = valor;
	}
	
	public int getPoderDeDesinfeccion() {
		return poderDeDesinfeccion;
	}
	
	public void desinfectar(Entidad e) {
		//e.recibirCura(10);
	}
	
	public ArmaAliado getArma() {
		return (ArmaAliado) arma;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public void moverDerecha() {
		this.label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Caminata derecha/caminataDerecha1.gif")));
		this.mover();
	}
	
	public void moverIzquierda() {
		this.label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Caminata izquierda/caminataIzquierda1.gif")));
		this.mover();
	}
	
	public void mover() {
		Point pos = this.getPosicion();
		
		
        if (pos.x < 1) 
            pos.x = 1;
        
        if (pos.x > 400) 
            pos.x = 400;
        
        label.setLocation(pos.x + desplazamientoX, pos.y);
	}
	


	public void aceptar(Visitor visitor) {
		visitor.visitar(this);
	}

	public void lanzar(Entidad e) {
		contador++;
		if(contador >= 20 && curar) {
			arma.setImagenLanzamiento(rutaLanzamiento);
			juego.agregarObjetos(arma.crearLanzamiento(this.getPosicion(), poderDeDesinfeccion));
			contador = 0;
			System.out.println("poder del jugador:"+this.getPoderDeDesinfeccion());
		}
	}
	
	@Override
	public void reaparecer(int xAux, int yAux) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void infectar(Entidad e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void curar(Entidad e) {
		// TODO Auto-generated method stub
		
	}

	
	public void keyPressed(KeyEvent e) {
	    int key = e.getKeyCode();
	    switch (key){
	        case KeyEvent.VK_SPACE : 
	        	curar = true;
	        	break;
			case KeyEvent.VK_LEFT : 
				desplazamientoX = - velocidad;
				break;
			case KeyEvent.VK_RIGHT : 
				desplazamientoX = velocidad;
				break;
		}
    }
	
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key){
        	case KeyEvent.VK_SPACE :
        		curar = false;
        		break;
			case KeyEvent.VK_LEFT : 
				desplazamientoX = 0;
				break;
			case KeyEvent.VK_RIGHT : 
				desplazamientoX = 0;
				break;	
        }
    }

	public void accionar() {
		
	}





}