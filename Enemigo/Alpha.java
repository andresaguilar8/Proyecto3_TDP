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
		visitor = new VisitorPersonaje(this);
		cargaViral = 100;
		estado = new EnemigoNormal(this);
	}
	
	public void mover() {
        super.mover();
        label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/AlphaCaminaGif.gif")));
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

	@Override
	public void keyPressed(KeyEvent arg0) {
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void reaparecer(int xAux, int yAux) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recibirCargaViral(int cura) {
		super.recibirCura(cura);
		if(cargaViral <=20) {
    		this.setEstado(new EnemigoVeloz(this));
    	}
	}

	@Override
	public void infectar(Entidad e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lanzar(Entidad e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void curar(Entidad e) {
		// TODO Auto-generated method stub
		
	}

	public void accionar() {
		super.accionar();
	}

	



}
