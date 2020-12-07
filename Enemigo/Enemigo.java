package Enemigo;

import java.awt.Point;
import java.util.Random;
import Estado.Estado;
import Logica.Entidad;
import Logica.PowerUp;
import PowerUp.Cuarentena;
import PowerUp.Curacion;
import PowerUp.SuperArmaSanitaria;
import Visitor.Visitor;
import Visitor.VisitorEnemigo;

public abstract class Enemigo extends Entidad {

	protected int velocidad;
	public Estado estado;
	int poder;
	
	public Enemigo(int x, int y) {
		super(x, y);
		visitor = new VisitorEnemigo(this);
	}

	public void movilizar(int agregadoVelocidad) {
		this.setPosicion(this.getPosicion().x, this.getPosicion().y + estado.getVelocidad());
	}
	
	public void mover() {
		estado.movilizar();
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
    
    public int getPoder() {
    	return poder;
    }
    
    public void accionar() {
    	this.reaparecer();
    }
    
    protected void lanzarPowerUp() {
		Random numAleatorio = new Random();
		int n = numAleatorio.nextInt(6) + 1;
		PowerUp powerup = null;
		switch(n) {
			case 1: 
				powerup = new Curacion(this.getPosicion().x,this.getPosicion().y);
				break;
			case 2:
				powerup = new Cuarentena(this.getPosicion().x,this.getPosicion().y);
				break;
			case 3:
				powerup = new SuperArmaSanitaria(this.getPosicion().x,this.getPosicion().y);
				break;
				
		}
		if(powerup != null) 
			juego.agregarObjetos(powerup);
	}
    
    public void setEstado(Estado estado) {
		this.estado = estado;
	}
    
    public void reaparecer() {
    	Point lugar = this.juego.getMapa().posicionAleatoriaEnemigos();
		this.setPosicion(lugar.x, lugar.y);
    	this.juego.getMapa().ubicacionDefinitiva(this);
    }
    
    public Estado getEstado() {
    	return this.estado;
    }
    
    public abstract Enemigo clonar();
	
}