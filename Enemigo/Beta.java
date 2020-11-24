package Enemigo;

import java.awt.Point;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import Estado.EnemigoNormal;
import Lanzamiento.Arma;
import Lanzamiento.ArmaEnemigo;
import Lanzamiento.LanzamientoEnemigo;
import Logica.Entidad;
import Visitor.Visitor;
import Visitor.VisitorEnemigo;
import Visitor.VisitorPersonaje;

public class Beta extends Enemigo {

	protected Arma arma;
	int contador;
	
	public Beta(int x, int y) {
		super(x, y);
		label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/BetaCaminaGif.gif")));
		label.setBounds(x, y, 90 , 90);
		arma = new ArmaEnemigo();
		cargaViral = 100;
		contador = 0;
		velocidad = 1;
		estado = new EnemigoNormal(this);
	}

	public void mover() {
        super.movilizar(0);
        label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/BetaCaminaGif.gif")));
        lanzar(this.juego.getPersonaje());
	}

    public void lanzar(Entidad e) {
        label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/BetaCaminaGif.gif")));
        
        contador++;
		if(contador >= 70) {
			juego.agregarObjetos(arma.crearLanzamiento(this.getPosicion(), cargaViral));
			contador = 0;
		}
    }

	public void infectar(Entidad e) {
		label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/AlphaAtacaGif.gif")));
		System.out.println("beta infectando");
		e.recibirCargaViral(1);
	}
	
    public void parar() {
        label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/BetaParado.png")));
    }

    public Enemigo clonar() {
		Enemigo clone = new Beta(0,0);
		return clone;
	}

	public void keyPressed(KeyEvent arg0) {
		
	}

	public void keyReleased(KeyEvent arg0) {
		
	}

	public void reaparecer() {
		Point posicion = this.juego.getMapa().posicionAleatoriaEnemigos();
		this.setPosicion(posicion.x, posicion.y);
	}

	public void recibirCargaViral(int i) {
		
	}


	public void curar(Entidad e) {
		
	}

	public void accionar() {
		this.reaparecer();
	}

	public void reaparecer(int xAux, int yAux) {
		
	}



}
