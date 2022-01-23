package main;

public class Moto extends Vehiculo {

	//En esta clase solo necessitamos un constructor porque todo lo demàs esta implementado en la clase Vehiculo
	public Moto(String matricula, String marca, Rueda trasera, Rueda delantera, String color, Titular titular) {
		super(matricula, marca, trasera, delantera, color, titular);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public String toString() {
		return "Matricula:" + matricula + ", Marca:" + marca + ", Rueda trasera:" + trasera.toString() + ", Rueda delantera:"
				+ delantera.toString() + ", Color" + color;
	}
}
