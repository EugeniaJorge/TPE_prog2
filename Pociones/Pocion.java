package tpe_prog2.Pociones;

import tpe_prog2.Atributo;


public abstract class Pocion {
	private String nombre;
	
	public Pocion(String nombre) {
		this.nombre = nombre;
	}
	public abstract int aplicarEfecto(Atributo a1);

	public String getNombre() {
		return nombre;
	}

}
