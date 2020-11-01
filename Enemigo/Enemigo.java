package Enemigo;

import Logica.Entidad;
import Logica.Estado;
import Logica.Strategy;

public abstract class Enemigo extends Entidad{

	protected int velocidad;
	protected Strategy estrategia;
	protected Estado estado;
	
	public Enemigo(int x, int y) {
		super(x, y);
		velocidad = 1;
	}

	public void mover() {
		this.setPosicion(this.getPosicion().x, this.getPosicion().y + velocidad);
		if(this.getPosicion().x<-10) {
//			this.setVida(0);
//			juego.disminuirVida(1);
		}
	}
	
    public void parar() {
        this.setPosicion(this.getPosicion().x,  this.getPosicion().y);
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void recibirCura(int cura) {
    	cargaViral-=cura;
    }
    
    public abstract Enemigo clonar();
	
}
