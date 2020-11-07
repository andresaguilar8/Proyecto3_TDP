package Enemigo;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import Lanzamiento.Arma;
import Lanzamiento.ArmaEnemigo;
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
		label.setBounds(x, y, 117 , 110);
		arma = new ArmaEnemigo();
		contador = 0;
		velocidad = 1;
	}

	public void mover() {
        super.mover();
        label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/BetaCaminaGif.gif")));
	}

    public void atacar(Entidad e) {
        label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/AlphaAtacaGif.gif")));
        
        contador++;
		if(contador == 70) {
			juego.agregarObjetos(arma.crearLanzamiento(this.getPosicion(), cargaViral));
			contador = 0;
		}
    }

    public void parar() {
        label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/BetaParado.png")));
    }

    public Enemigo clonar() {
		Enemigo clone = new Beta(0,0);
		return clone;
	}

	
    @Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
