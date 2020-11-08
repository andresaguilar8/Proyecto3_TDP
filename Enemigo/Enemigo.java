package Enemigo;

import Logica.Entidad;

import Logica.Estado;
import Visitor.Visitor;
import Visitor.VisitorEnemigo;

public abstract class Enemigo extends Entidad{

	protected int velocidad;
	protected Estado estado;
	
	public Enemigo(int x, int y) {
		super(x, y);
		velocidad = 1;
		visitor = new VisitorEnemigo(this);
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
    	cargaViral -= cura;
    }
    
    public void aceptar (Visitor visitor) {
    	visitor.visitar(this);
    }
    
    public abstract Enemigo clonar();
	
}
