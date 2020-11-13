package tpe_prog2.Pociones;

import tpe_prog2.Atributo;

public class PocionSelectiva extends Pocion {
	private String atributo;
	private int valor;
	
	public PocionSelectiva(String nombre, String atributo, int valor) {
		super(nombre);
		this.atributo=atributo;
		this.valor=valor;
	}

	@Override
	public int aplicarEfecto(Atributo a1) {
		if(a1.getNombre().equals(atributo)){
	        return (int) a1.getValor()+ a1.getValor()*valor/100;
		}
		return a1.getValor();
	}

}
