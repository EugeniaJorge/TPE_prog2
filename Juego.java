package tpe_prog2;

import java.util.ArrayList;

public class Juego {
	private Mazo mazo;
	private Jugador j1;
	private Jugador j2;
	private int rondas;
	private ArrayList<String>historial;
	
	public Juego(Mazo mazo, Jugador j1, Jugador j2, int rondas) {
		this.mazo = mazo;
		this.j1 = j1;
		this.j2 = j2;
		this.rondas = rondas;
		historial=new ArrayList<>();
	}

	public Mazo getMazo() {
		return mazo;
	}

	public void setMazo(Mazo mazo) {
		this.mazo = mazo;
	}

	public Jugador getJ1() {
		return j1;
	}

	public void setJ1(Jugador j1) {
		this.j1 = j1;
	}

	public Jugador getJ2() {
		return j2;
	}

	public void setJ2(Jugador j2) {
		this.j2 = j2;
	}
	
	public void jugar() {
		int ronda = 0;
		mazo.mezclarCartas();
		mazo.mezclarPociones();
		mazo.repartirCartas( j1, j2);
		while (j1.cantidadCartas() > 0 && j2.cantidadCartas() > 0 && ronda < rondas) {
			historial.add("-------------RONDA-" +(ronda+1)+ "------------------");
			ronda();
			ronda++;
		}
		historial.add(gano());
	}
	
	private void ronda() {
		Jugador mano;
		Jugador contra;
		if(j1.isEsMano()) {
			mano=j1;
			contra=j2;			
		}else {
			mano=j2;
			contra=j1;
		}
		Carta cartaJ1 = mano.jugarCarta();
		Carta cartaJ2 = contra.jugarCarta();
		String nombreAtributo = mano.elegirAtributo(cartaJ1);
		historial.add("El jugador "+ mano.getNombre()+" selecciona competir por el atributo "+ nombreAtributo);
		historial.add("La carta de "+ mano.getNombre()+ " es "+ cartaJ1.toString()+" con " + cartaJ1.getAtributo(nombreAtributo).toString());
		if(cartaJ1.tienePocion()) {
			historial.add("Se aplica la pocima "+ cartaJ1.getPocion().getNombre()+ ", Valor resultante: "+cartaJ1.getValorAtributo(nombreAtributo));
		}
		historial.add("La carta de "+ contra.getNombre()+ " es "+ cartaJ2.toString()+" con " + cartaJ2.getAtributo(nombreAtributo).toString());
		if(cartaJ2.tienePocion()) {
			historial.add("Se aplica la pocima "+ cartaJ2.getPocion().getNombre()+ ", Valor resultante: "+cartaJ2.getValorAtributo(nombreAtributo));
		}
		if (cartaJ1.resultado(nombreAtributo, cartaJ2)>0) {
			mano.agregarCarta(cartaJ1);
			mano.agregarCarta(cartaJ2);
			historial.add("Gana: "+ mano.getNombre());
			historial.add(mano.toString()+" "+contra.toString());
		} else if(cartaJ1.resultado(nombreAtributo,cartaJ2)<0) {
			contra.agregarCarta(cartaJ1);
			contra.agregarCarta(cartaJ2);
			historial.add("Gana: "+ contra.getNombre());
			historial.add(mano.toString()+" "+contra.toString());
			mano.setEsMano(false);
			contra.setEsMano(true);
		} else {
			mano.agregarCarta(cartaJ1);
			contra.agregarCarta(cartaJ2);
			historial.add("empate");
			historial.add(mano.toString()+" "+contra.toString());
		}
	}

	public String gano() {
		if (j1.cantidadCartas()>j2.cantidadCartas()) {
			return ("GANO jugador "+ j1.getNombre());
		}
		else if (j1.cantidadCartas()<j2.cantidadCartas()) {
			return ("GANO jugador "+j2.getNombre());
		}else {
			return ("Empate");
		}
	}

	public ArrayList<String> getHistorial() {
		return new ArrayList<String> (historial);
	}

}
