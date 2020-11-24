package Enemigo;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import Estado.EnemigoNormal;
import Estado.EnemigoVeloz;
import Estado.EstadoEnemigo;
import Lanzamiento.LanzamientoEnemigo;
import Logica.Entidad;
import Visitor.Visitor;
import Visitor.VisitorPersonaje;

public class Alpha extends Enemigo {
	
	

	public Alpha(int x, int y) {
		super(x, y);
		label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/AlphaCaminaGif.gif")));
		label.setBounds(x, y, 117, 110);
		cargaViral = 100;
		estado = new EnemigoNormal(this);
	}
	
	public void mover() {
        super.mover();
        label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/AlphaCaminaGif.gif")));
    }

	public void infectar(Entidad e) {
		System.out.println("alpha infecta");
		label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/AlphaAtacaGif.gif")));
	}
	
    public void atacar(Entidad e) {
        label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/AlphaAtacaGif.gif")));
    }

    public void parar() {
        label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/AlfaParado.png")));
    }

	public Enemigo clonar() {
		Enemigo clone = new Alpha(0,0);
		return clone;
	}
	
	public void recibirCura(int cura) {
		super.recibirCura(cura);
		if(cargaViral <= 20) {
    		this.setEstado(new EnemigoVeloz(this));
    	}
	}

	public void keyPressed(KeyEvent arg0) {
		
	}

	public void keyReleased(KeyEvent arg0) {
		
	}

	public void reaparecer(int xAux, int yAux) {
		
	}

	public void recibirCargaViral(int i) {
		
	}



	public void lanzar(Entidad e) {
		
	}

	public void curar(Entidad e) {
		
	}

	public void accionar() {
		super.accionar();
	}

}
