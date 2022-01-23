package main;

public class Camion extends Vehiculo {
	
	public Camion(String matricula, String marca, Rueda trasera, Rueda delantera, String color, Titular titular) {
		super(matricula, marca, trasera, delantera, color, titular);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Matricula:" + matricula + ", Marca:" + marca + ", Rueda trasera:" + trasera.toString() + ", Rueda delantera:"
				+ delantera.toString() + ", Color" + color;
	}
}
