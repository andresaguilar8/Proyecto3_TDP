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
		label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/BetaAtacaGif.gif")));
		System.out.println("beta infectando");
		e.recibirCargaViral(poder);
	}
	
    public void parar() {
        label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/BetaParado.png")));
    }

    public Enemigo clonar() {
		Enemigo clone = new Beta(0,0);
		return clone;
	}

	public void reaparecer() {
		super.reaparecer();
	}

	public void recibirCargaViral(int i) {
		
	}

	public void accionar() {
		this.reaparecer();
	}

}