package tpe_prog2;


import tpe_prog2.Estrategias.Estrategia;

public class Jugador {
	private String nombre;
	private Mazo mazo;
	private boolean esMano;
	private Estrategia estrategia;
	
	public Jugador(String nombre, boolean esMano, Estrategia estrategia) {
		this.nombre = nombre;
		this.esMano= esMano;
		this.estrategia=estrategia;
		this.mazo = new Mazo("mazo de pepe");
	}

	public Estrategia getEstrategia() {
		return estrategia;
	}

	public void setEstrategia(Estrategia estrategia) {
		this.estrategia = estrategia;
	}

	public boolean isEsMano() {
		return esMano;
	}

	public void setEsMano(boolean esMano) {
		this.esMano = esMano;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void agregarCarta(Carta c1) {
		this.mazo.addCarta(c1);
	}

	
	public int cantidadCartas() {
		return mazo.cantidadCartas();
	}
	
	public Carta jugarCarta() {
		if(mazo!= null) {
			return mazo.jugarCarta();//borra y me devuelve el primero
		}else
			return null;
	}
	
	public String elegirAtributo(Carta c1) {
		return this.estrategia.elegirAtributo(c1);
	}
	
	public String toString() {
		return (getNombre()+" tiene "+ cantidadCartas()+" cartas");
	}

}
