package Logica;

import java.awt.Point;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Lanzamiento.Arma;
import Lanzamiento.ArmaAliado;
import Lanzamiento.LanzamientoAliado;
import Visitor.Visitor;
import Visitor.VisitorPersonaje;

public class Personaje extends Entidad {
	
	private int cargaViral;
	protected int desplazamientoX;
	protected int velocidad;
	protected Arma arma;
	protected volatile boolean disparar;
	protected int contador;

	public Personaje(int x, int y) {
		super(x, y);
		label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/personaje.png")));
		this.label.setSize(90, 90);
		cargaViral = 0;
		velocidad = 10;
		visitor = new VisitorPersonaje(this);
		arma = new ArmaAliado();
		disparar = false;
		contador = 0;
	}
	
	public int getCargaViral() {
		return cargaViral;
	} 

	public void recibirCargaViral(int carga) {
		cargaViral+=carga;
	}
	
	public void desinfectar(Entidad e) {
		//e.recibirCura(10);
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
        
//        this.label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/personaje.png")));
	}
	

	
	public void keyPressed(KeyEvent e) {
	    int key = e.getKeyCode();
	    switch (key){
	        case KeyEvent.VK_SPACE : 
	        	disparar = true;
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
        		disparar = false;
        		break;
			case KeyEvent.VK_LEFT : 
				desplazamientoX = 0;
				break;
			case KeyEvent.VK_RIGHT : 
				desplazamientoX = 0;
				break;	
        }
    }

	public void aceptar(Visitor visitor) {
		System.out.println("aceptando");
		visitor.visitar(this);
	}

	public void atacar(Entidad e) {
		contador++;
		if(contador >= 20 && disparar) {
			juego.agregarObjetos(arma.crearLanzamiento(this.getPosicion(), 20));
			contador = 0;
			System.out.println("jugador atacando");
		}
	}
	
	@Override
	public void reaparecer(int xAux, int yAux) {
		// TODO Auto-generated method stub
		
	}




}