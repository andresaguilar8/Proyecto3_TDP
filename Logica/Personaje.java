package Logica;

import java.awt.Point;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Personaje extends Entidad {
	
	private int cargaViral;
	protected int desplazamientoX;
	protected int velocidad;

	public Personaje(int x, int y) {
		super(x, y);
		label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/personaje.png")));
		this.label.setSize(100, 100);
		cargaViral = 0;
		velocidad = 10;
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

	
	public void mover() {
		System.out.println("jugador moviendo");
		Point pos = this.getPosicion();
		label.setLocation(pos.x + desplazamientoX, pos.y);
        if (pos.x < 1) 
            pos.x = 1;
        
        if (pos.x > 500) 
            pos.x = 500;
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
			case KeyEvent.VK_LEFT : 
				desplazamientoX = - velocidad;
				break;
			case KeyEvent.VK_RIGHT : 
				desplazamientoX = velocidad;
				break;
	    }
	    this.mover();
    }
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        System.out.println("key: "+key);
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
}
