package Enemigo;

import javax.swing.ImageIcon;
import Estado.EnemigoNormal;
import Estado.EnemigoVeloz;
import Logica.Entidad;

public class Alpha extends Enemigo {
	
	public Alpha(int x, int y) {
		super(x, y);
		label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/AlphaCaminaGif.gif")));
		label.setBounds(x, y, 117, 110);
		cargaViral = 100;
		poder = 3;
		estado = new EnemigoNormal(this);
	}
	
	public void mover() {
        super.mover();
        label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/AlphaCaminaGif.gif")));
    }

	public void infectar(Entidad e) {
		System.out.println("alpha infecta");
		label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/AlphaAtacaGif.gif")));
		e.recibirCargaViral(poder);
		
	}
	
    public void atacar(Entidad e) {
        label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/AlphaAtacaGif.gif")));
    }

    public void parar() {
        label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/AlfaParado.png")));
    }

    public int getPoder() {
    	return this.poder;
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

	public void recibirCargaViral(int i) {
		
	}
	
	public void reaparecer() {
		super.reaparecer();
	}

	public void lanzar(Entidad e) {
		
	}

	public void accionar() {
		this.reaparecer();
	}

}