package Enemigo;

import javax.swing.ImageIcon;
import Estado.EnemigoNormal;
import Estado.EnemigoVeloz;
import Logica.Entidad;

public class Alpha extends Enemigo {
	
	public Alpha(int x, int y) {
		super(x, y);
		label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/AlphaCaminaGif.gif")));
		label.setBounds(x, y, 90, 90);
		cargaViral = 100;
		poder = 3;
		estado = new EnemigoNormal(this);
	}
	
	public void mover() {
        super.mover();
        label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/AlphaCaminaGif.gif")));
    }

	public void infectar(Entidad e) {
		label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/AlphaAtacaGif.gif")));
		e.recibirCargaViral(this.poder);
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

	public void accionar() {
		super.accionar();
	}
	
	public void recibirCargaViral(int i) {
		
	}
	
	public void lanzar(Entidad e) {
		
	}

}