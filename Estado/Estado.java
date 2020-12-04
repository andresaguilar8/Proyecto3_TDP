package Estado;

public abstract class Estado {
	
	public int velocidad;
	
	public abstract void movilizar();

	public abstract int getVelocidad();

	public abstract void setVelocidad(int velocidad);

}
