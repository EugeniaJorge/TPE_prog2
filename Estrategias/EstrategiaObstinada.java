package tpe_prog2.Estrategias;

import tpe_prog2.Carta;

public class EstrategiaObstinada extends Estrategia {
	private String nombreAtributo;
	
	public EstrategiaObstinada(String nombreAtributo) {
		this.nombreAtributo=nombreAtributo;
	}
	
	@Override
	public String elegirAtributo(Carta carta) {
		return carta.buscarAtributo(nombreAtributo);
	}

}
