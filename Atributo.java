package tpe_prog2;

public class Atributo{
	private int valor;
	private String nombre;
	
	public Atributo(String nombre, int valor) {
		this.valor=valor;
		this.nombre=nombre;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public boolean equals(Object a1) {
		try {
			Atributo atributo = (Atributo)a1;
			return (this.nombre.equals(atributo.getNombre()));
		}catch(Exception e) {
			return false;
		}
	}
	public String toString() {
		return nombre + " " +valor;
	}
	/*public int compareTo(Atributo a1) {
		return this.getValor()-a1.getValor();
	}*/
}
