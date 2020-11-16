package Logica;

import java.util.Map;

public class Entrada<Personaje, Integer> implements Map.Entry<Personaje, Integer> {

	protected Personaje key;
	protected Integer value;
	
	public Entrada() {
		
	}
	
	public Entrada(Personaje key, Integer value) {
		this.key = key;
		this.value = value;
	}
	
	public Personaje getKey() {
		return key;
	}
	
	public Integer setValue(Integer value) {
		Integer valorViejo = this.value;
		this.value = value;
		return valorViejo;
	}

	public Integer getValue() {
		return value;
	}


	
}
