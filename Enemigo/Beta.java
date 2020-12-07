package Enemigo;

import javax.swing.ImageIcon;

import Estado.EnemigoNormal;
import Lanzamiento.Arma;
import Lanzamiento.ArmaEnemigo;
import Logica.Entidad;

public class Beta extends Enemigo {

	protected Arma arma;
	int contador;
	int poder;
	
	public Beta(int x, int y) {
		super(x, y);
		label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/BetaCaminaGif.gif")));
		label.setBounds(x, y, 90 , 90);
		arma = new ArmaEnemigo();
		cargaViral = 200;
		poder = 1;
		contador = 0;
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
			juego.agregarObjetos(arma.crearLanzamiento(this.getPosicion(), poder));
			contador = 0;
		}
    }

	public void infectar(Entidad e) {
		label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/BetaAtacaGif.gif")));
		e.recibirCargaViral(poder);
	}
	
	public int getPoder() {
		return this.poder;
	}
	
    public Enemigo clonar() {
		Enemigo clone = new Beta(0,0);
		return clone;
	}

	public void accionar() {
		super.accionar();
	}

	public void recibirCargaViral(int i) {
		
	}

}