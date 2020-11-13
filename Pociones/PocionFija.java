package tpe_prog2.Pociones;

import tpe_prog2.Atributo;

public class PocionFija extends Pocion {
	private int valor;
	
	public PocionFija(String nombre, int valor) {
		super(nombre);
		this.valor = valor;
	}

	@Override
	public int aplicarEfecto(Atributo a1) {
		return valor;
	}

}
