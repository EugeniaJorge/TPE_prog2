package tpe_prog2;

import java.util.ArrayList;
import java.util.Collections;

import tpe_prog2.Pociones.Pocion;

public class Mazo {
	private String nombre;
	private ArrayList<Carta>cartas;
	private ArrayList<Pocion> pociones;
	
	public Mazo(String nombre) {
		this.nombre=nombre;
		cartas = new ArrayList<Carta>();
		pociones = new ArrayList<Pocion>();
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Carta> getCartas() {
		return new ArrayList<Carta>(cartas);
	}
	public void setCartas(ArrayList<Carta> cartas) {
		this.cartas = new ArrayList<Carta>(cartas);
	}
	public void addCarta(Carta c1) {
		if(this.cantidadCartas()>0) {
			Carta carta1 = cartas.get(0);
			if(carta1.esIgual(c1)){
				this.cartas.add(c1);	
			}
		}
		else{
			this.cartas.add(c1);
		}
	}

	/*public void verificarMazo() {
		if(this.cantidadCartas()>0) {
			Carta carta1 = cartas.get(0);
			for (int i = 0; i < cantidadCartas(); i++) {
					Carta carta = cartas.get(i);
					if (!carta1.esIgual(carta)) {
						this.cartas.remove(carta);
					}
			}
		}
	}*/
	
	public void repartirCartas(Jugador j1, Jugador j2) {
		int i = 0;
		while (i<cantidadCartas()) {
			Carta c1 = getCartas().get(i);
			if(i<cantidadPociones()) {
				Pocion p1 = getPociones().get(i);
				c1.setPocion(p1);
			}
			j1.agregarCarta(c1);
			i++;
			if(cantidadCartas()>i) {
				Carta c2 = getCartas().get(i);	
				if(i<cantidadPociones()) {
					Pocion p2 = getPociones().get(i);
					c2.setPocion(p2);
				}
				j2.agregarCarta(c2);
			}
			i++;
		}
	}
	
	public ArrayList<Pocion> getPociones() {
		return new ArrayList<Pocion>(pociones);
	}

	public int cantidadPociones() {
		return this.pociones.size();
	}
	public void agregarPocion(Pocion p1) {
		this.pociones.add(p1);
	}
	public void mezclarPociones() {
		Collections.shuffle(pociones);
	}
	public void mezclarCartas() {
		Collections.shuffle(cartas);
	}
	public int cantidadCartas() {
		return this.cartas.size();
	}
	public Carta jugarCarta() {
		return this.cartas.remove(0);
	}
}
