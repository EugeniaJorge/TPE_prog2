package tpe_prog2.Estrategias;

import tpe_prog2.Carta;

public class EstrategiaAmbiciosa extends Estrategia {
	
	public EstrategiaAmbiciosa() {
	}

	@Override
	public String elegirAtributo(Carta carta) {
		return carta.buscarMejorAtributo();
	}

}
