package Logica;

import java.awt.Point;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Lanzamiento.Arma;
import Visitor.Visitor;
import Visitor.VisitorPersonaje;

public class Personaje extends Entidad {
	
	private int cargaViral;
	protected int desplazamientoX;
	protected int velocidad;
	protected Arma arma;

	public Personaje(int x, int y) {
		super(x, y);
		label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/personaje.png")));
		this.label.setSize(100, 100);
		cargaViral = 0;
		velocidad = 10;
		visitor = new VisitorPersonaje(this);
	}
	
	public int getCargaViral() {
		return cargaViral;
	} 

	public void aumentarCargaViral(int carga) {
		cargaViral+=carga;
	}
	
	public void desinfectar(Entidad e) {
		//e.recibirCura(10);
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public void moverDerecha() {
		System.out.println("jugador moviendo a derecha");
		this.label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Caminata derecha/caminataDerecha1.gif")));
		this.mover();
	}
	
	public void moverIzquierda() {
		System.out.println("jugador moviendo a izquierda");
		this.label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Caminata izquierda/caminataIzquierda1.gif")));
		this.mover();
	}
	
	public void mover() {
		System.out.println("jugador moviendo");
		Point pos = this.getPosicion();
		
		
        if (pos.x < 1) 
            pos.x = 1;
        
        if (pos.x > 400) 
            pos.x = 400;
        
        label.setLocation(pos.x + desplazamientoX, pos.y);
        
//        this.label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/personaje.png")));
	}
	
//	public void disparar() {
//		contador++;
//		if(contador>=arma.getCadencia() && disparar) {
//			DisparoJugador disparo= arma.crearDisparo(jugador.getPos());
//			juego.agregarEntidad(disparo);
//			contador=0;
//		}
//	}
	public void keyPressed(KeyEvent e) {
	    int key = e.getKeyCode();
	    switch (key){
	        //case KeyEvent.VK_SPACE :
	        	//disparar=true;
	        	//break;
			case KeyEvent.VK_LEFT : {
				desplazamientoX = - velocidad;
				this.moverIzquierda();
				break;
			}
			case KeyEvent.VK_RIGHT : {
				desplazamientoX = velocidad;
				this.moverDerecha();
				break;
			}
	    }
    }
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        System.out.println("asdsad: "+key);
        switch (key){
        	//case KeyEvent.VK_SPACE :
        		//disparar=false;
        		//break;
			case KeyEvent.VK_LEFT : 
				desplazamientoX = 0;
				break;
			case KeyEvent.VK_RIGHT : 
				desplazamientoX = 0;
				break;	
        }
        this.mover();
    }

	public void aceptar(Visitor visitor) {
		System.out.println("aceptando");
		visitor.visitar(this);
	}

	@Override
	public void atacar(Entidad e) {
		System.out.println("jugador atacando al enemigo");
	} 
}