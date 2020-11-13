package tpe_prog2;

import java.util.ArrayList;

import tpe_prog2.Pociones.Pocion;

public class Carta {
	private String nombre;
	private ArrayList<Atributo>atributos;
	private Pocion pocion;
	//private boolean seAplicoPocion;
	
	
	public Carta(String nombre) {
		this.nombre = nombre;
		atributos = new ArrayList<Atributo>();
		//this.seAplicoPocion = false;
	}
	
	public Pocion getPocion() {
		return pocion;
	}

	public void setPocion(Pocion pocion) {
		this.pocion = pocion;
	}

	public void addAtributo(Atributo atributo) {
		atributos.add(atributo);
	}
	
	public void setAtributo(ArrayList<Atributo> atributos) {
		if (this.atributos.isEmpty()) {
			this.atributos = new ArrayList<Atributo>(atributos);
		}
	}
	
	public ArrayList<Atributo> getAtributos() {
		return new ArrayList<Atributo>(atributos);
	}

	public boolean esIgual(Carta carta) {
		if (this.atributos.size() != carta.getAtributos().size()) {
			return false;
		} else {
			for (int i = 0; i < this.atributos.size() ; i++) {
				if (!this.atributos.contains(carta.getAtributos().get(i))) {
					return false;
				}
			}
			return true;
		}
	}
	
	public int resultado(String s1,Carta c2) {
		return this.getValorAtributo(s1)-c2.getValorAtributo(s1);
		
		/*if(this.getAtributo(i).compareTo(c2.getAtributo(i))>0) {
			return 1;
		}
		else if(this.getAtributo(i).compareTo(c2.getAtributo(i))==0) {
			return 0;
		}
		else {
			return -1;
		}*/
	}
	
	public String buscarAtributo(String a1) {
		for(int i=0;i<this.atributos.size();i++) {
			if(atributos.get(i).getNombre().equals(a1)) {
				return atributos.get(i).getNombre();
			}
		}
		return null;
	}
	
	public String buscarMejorAtributo() {
		int cantidad=0;
		String nombreAtributo = null;
		for(int i=0;i<this.atributos.size();i++) {
			if(atributos.get(i).getValor()>cantidad) {
				cantidad=atributos.get(i).getValor();
				nombreAtributo = atributos.get(i).getNombre();
			}
		}
		return nombreAtributo;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString() {
		return nombre;
	}
	/*public void agregarPocion(String nombreAtributo) {
		if(!this.seAplicoPocion) {
			Atributo aux= this.getAtributo(nombreAtributo);
            int valor = this.pocion.aplicarPocion(nombreAtributo,aux.getValor());
			//this.pocion.aplicarPocion(this.getAtributo(nombreAtributo));
			this.setSeAplicoPocion(true);
		}

	}*/
	
	public boolean tienePocion() {
		return this.pocion != null;
	}

	/*public boolean isSeAplicoPocion() {
		return seAplicoPocion;
	}

	public void setSeAplicoPocion(boolean seAplicoPocion) {
		this.seAplicoPocion = seAplicoPocion;
	}*/

	public void setAtributos(ArrayList<Atributo> atributos) {
		this.atributos = atributos;
	}
	public boolean tieneAtributo(String a1) {
		for(int i = 0; i<this.atributos.size();i++) {
			if(atributos.get(i).getNombre().equals(a1)) {
				return true;
			}
		}
		return false;
	}
	public Atributo getAtributo(String s1) {
		for(int i = 0; i<this.atributos.size();i++) {
			if(atributos.get(i).getNombre().equals(s1)) {
				Atributo a1 = atributos.get(i);
				return a1;
			}
		}
		return null;
	}
	
	public int getValorAtributo(String s1) {
		Atributo a1 = this.getAtributo(s1);
        if(this.tienePocion()){
            return this.pocion.aplicarEfecto(a1);
        }else{
            return a1.getValor();
        }
	}
}
