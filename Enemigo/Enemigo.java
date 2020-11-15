package Enemigo;

import java.util.Random;

import Logica.Entidad;

import Logica.Estado;
import Logica.PowerUp;
import PowerUp.Cuarentena;
import PowerUp.Curacion;
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
    	if(cargaViral <= 0) {
    		lanzarPowerUp();
    	}
    }
    
    public void aceptar (Visitor visitor) {
    	visitor.visitar(this);
    }
    
    public void accionar() {
    	System.out.println("enemigo acciona");
    }
    
    protected void lanzarPowerUp() {
		Random numAleatorio = new Random();
		int n = numAleatorio.nextInt(2) + 1;
		PowerUp powerup=null;
		switch(n) {
			case 1: 
				powerup= new Curacion(this.getPosicion().x,this.getPosicion().y);
				break;
			case 2:
				powerup= new Cuarentena(this.getPosicion().x,this.getPosicion().y);
				break;
				
		}
		if(powerup!=null) {
			juego.agregarObjetos(powerup);
		}
	}
    
    public abstract Enemigo clonar();
	
}
