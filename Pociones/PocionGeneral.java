package tpe_prog2.Pociones;

import tpe_prog2.Atributo;

public class PocionGeneral extends Pocion {
	private int valor;
	
	public PocionGeneral(String nombre, int valor) {
		super(nombre);
		this.valor = valor;
	}

	@Override
	public int aplicarEfecto(Atributo a1) {
		if(this.valor<-100) {
			this.valor = -100;
		}
	    return (int) (a1.getValor()+ a1.getValor()*valor/100);
	}

}
