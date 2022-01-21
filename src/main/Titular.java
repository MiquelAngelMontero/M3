package main;

public class Titular extends Persona {
	
	//Atributo
	private boolean garajePropio;
	private boolean seguro;
	
	
	//Constructor
	public Titular(String nombre, String apellido, String fechaNac, Carnet carnet, boolean garajePropio, boolean seguro) {
		super(nombre, apellido, fechaNac, carnet);
		// TODO Auto-generated constructor stub
		this.garajePropio = garajePropio;
		this.seguro = seguro;
	}
	
}
