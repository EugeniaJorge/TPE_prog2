package tpe_prog2.Pociones;

import tpe_prog2.Atributo;

public class PocionCompuesta extends Pocion {
	private Pocion pocion1;
	private Pocion pocion2;
	

	public PocionCompuesta(String nombre, Pocion pocion1, Pocion pocion2) {
		super(nombre);
		this.pocion1 = pocion1;
		this.pocion2 = pocion2;
	}
	@Override
	public int aplicarEfecto(Atributo a1) {
		Atributo aux = a1;
		aux.setValor(pocion1.aplicarEfecto(a1));
		return pocion2.aplicarEfecto(aux);
	}

}
