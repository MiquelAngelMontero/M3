package main;

public class Titular extends Persona {
	
	//Atributo
	private boolean garajePropio;
	private boolean seguro;
	
	
	//Constructor heredado de la clase Persona pero con sus dos atributos extras añadidos
	public Titular(String nombre, String apellido, String fechaNac, Carnet carnet, boolean garajePropio, boolean seguro) {
		super(nombre, apellido, fechaNac, carnet);
		// TODO Auto-generated constructor stub
		this.garajePropio = garajePropio;
		this.seguro = seguro;
	}
	
	//Añadimos el toString para que se pueda mostrar en el main
	@Override
	public String toString() {
		return "Garaje Propio: " + garajePropio + ", Seguro: " + seguro + ", Nombre: " + nombre + ", Apellido: "
				+ apellido + ", Fecha de nacimiento: " + fechaNac + ", Carnet: " + carnet.toString();
	}
	
}
