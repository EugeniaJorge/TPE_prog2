package tpe_prog2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import tpe_prog2.Estrategias.Estrategia;
import tpe_prog2.Estrategias.EstrategiaAmbiciosa;
import tpe_prog2.Estrategias.EstrategiaObstinada;
//import tpe_prog2.Estrategias.EstrategiaTimbera;
import tpe_prog2.Pociones.Pocion;
import tpe_prog2.Pociones.PocionCompuesta;
import tpe_prog2.Pociones.PocionFija;
import tpe_prog2.Pociones.PocionGeneral;
import tpe_prog2.Pociones.PocionSelectiva;

public class Main {
	public static void main(String[] args) {
		Estrategia e1= new EstrategiaObstinada("fuerza");
		//Estrategia e2 = new EstrategiaTimbera();
		Estrategia e3 = new EstrategiaAmbiciosa();
		
		
		Jugador euge = new Jugador("Euge",true,e1);
		Jugador andres = new Jugador("Andres", false, e3);
		
		Pocion p1 = new PocionSelectiva("Selectiva Fuerza","fuerza", 35);
		Pocion p2 = new PocionSelectiva("Selectiva Peso","peso", 43);
		Pocion p3 = new PocionFija("Numero Magico", 23);
		Pocion p4 = new PocionFija("Quiero vale 4", 4);
		Pocion p5 = new PocionGeneral("Fortalecedora", 20);
		Pocion p6 = new PocionGeneral("Fortalecedora Plus", 50);
		Pocion p7 = new PocionCompuesta("Cocktail",p1,p5);
		Pocion p8 = new PocionGeneral("Kriptonita",-25);
		Pocion p9 = new PocionCompuesta("Cocktail Dos",p7,p8);//35%(fuerza), 20%, -25%
		Pocion p10 = new PocionGeneral("Reductor de plomo",-55);
		Pocion p11 = new PocionGeneral("Fortalecedora1", 29);
		Pocion p12 = new PocionSelectiva("Selectiva Altura","altura", 50);
		Pocion p13 = new PocionSelectiva("Selectiva Peleas ganadas","peleas ganadas", 35);
		Pocion p14 = new PocionFija("Numero fijo", 850);
		Pocion p15 = new PocionGeneral("Fortalecedora2", 10);
		Pocion p16 = new PocionGeneral("Disminucion Plus", -150);
		
		Mazo mazo = cargarMazo(".\\src\\tpe_prog2\\superheroes.json");
		
		mazo.agregarPocion(p1);
		mazo.agregarPocion(p2);
		mazo.agregarPocion(p3);
		mazo.agregarPocion(p4);
		mazo.agregarPocion(p5);
		mazo.agregarPocion(p6);
		mazo.agregarPocion(p7);
		mazo.agregarPocion(p8);
		mazo.agregarPocion(p9);
		mazo.agregarPocion(p10);
		mazo.agregarPocion(p11);
		mazo.agregarPocion(p12);
		mazo.agregarPocion(p13);
		mazo.agregarPocion(p14);
		mazo.agregarPocion(p15);
		mazo.agregarPocion(p16);

		Juego juego = new Juego(mazo,euge, andres,200);
		juego.jugar();
		
		for(int i=0;i<juego.getHistorial().size();i++) {
			System.out.println(juego.getHistorial().get(i));
		}
	}
		public static Mazo cargarMazo(String jsonFile) {
		Mazo mazo1 = new Mazo("Superheroes");
		 //URL url = getClass().getResource(jsonFile);
		 File jsonInputFile = new File(jsonFile);
		 InputStream is;
		 try {
			 is = new FileInputStream(jsonInputFile);
			 // Creo el objeto JsonReader de Json.
			 JsonReader reader = Json.createReader(is);
			 // Obtenemos el JsonObject a partir del JsonReader.
			 JsonArray cartas = (JsonArray)reader.readObject().getJsonArray("cartas");
		 for (JsonObject carta : cartas.getValuesAs(JsonObject.class)) {
			 String nombreCarta = carta.getString("nombre");
			 Carta carta1 = new Carta(nombreCarta);
			 JsonObject atributos = (JsonObject)carta.getJsonObject("atributos");
			 for (String nombreAtributo:atributos.keySet()) {
				 int valorAtributo = atributos.getInt(nombreAtributo);
				 Atributo at1 = new Atributo (nombreAtributo,valorAtributo);
				 carta1.addAtributo(at1);
			 }
			 mazo1.addCarta(carta1);
		 }
		 reader.close();
		 return mazo1;
		 } catch (FileNotFoundException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 return null;
		 }
	}
}
