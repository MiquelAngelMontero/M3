package main;

public class Conductor extends Persona {
	
	//En esta clase solo necessitamos un constructor porque todo lo demàs esta implementado en la clase Vehiculo
	public Conductor(String nombre, String apellido, String fechaNac, Carnet carnet) {
		super(nombre, apellido, fechaNac, carnet);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Nombre: " + nombre + ", Apellido: "
				+ apellido + ", Fecha de nacimiento: " + fechaNac + ", Carnet: " + carnet.toString();
	}
	
}
