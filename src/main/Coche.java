package main;

public class Coche extends Vehiculo {
	
	//En esta clase solo necessitamos un constructor porque todo lo demàs esta implementado en la clase Vehiculo
	public Coche(String matricula, String marca, Rueda trasera, Rueda delantera, String color) {
		super(matricula, marca, trasera, delantera, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Coche [matricula=" + matricula + ", marca=" + marca + ", trasera=" + trasera + ", delantera="
				+ delantera + ", color=" + color + "]";
	}
	
	
	
}
