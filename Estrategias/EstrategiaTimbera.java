package tpe_prog2.Estrategias;

import tpe_prog2.Carta;

public class EstrategiaTimbera extends Estrategia {

	public EstrategiaTimbera() {

	}
	public String elegirAtributo(Carta carta) {
		int i = (int) (Math.random()*carta.getAtributos().size());
		return carta.getAtributos().get(i).getNombre();
	}
}
