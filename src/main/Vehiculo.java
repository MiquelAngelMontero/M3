package main;
public abstract class Vehiculo implements Matriculable {
	
	//Atributos
	protected String matricula;
	protected String marca;
	protected Rueda trasera;
	protected Rueda delantera;
	protected String color;
	protected Titular titular;
	protected Persona[] persona;
	
	//Constructor (Aún que no se vaya a construir ningun vehiculo como tal, she ha de hacer el constructor 
	//para que los hijos de esta clase lo hereden)
	public Vehiculo(String matricula, String marca, Rueda trasera, Rueda delantera, String color, Titular titular) {
		this.matricula = matricula;
		this.marca = marca;
		this.trasera = trasera;
		this.delantera = delantera;
		this.color = color;
		this.titular = titular;
	}
	
	//Metodos
	//Metodo para comprobar la matricula
	@Override
	public String comptrobarMatricula() {

		//Comprovamos que la matricula cumple las condiciones del enunciado (4 numeros y 2 o 3 letras)
		if ((matricula.toUpperCase().matches("^[0-9]{4}[A-Z]{3}$")) || (matricula.toUpperCase().matches("^[0-9]{4}[A-Z]{2}$"))) {
			
			return "matricula";
			
		}else {
			
			return "0000AAA";
			
		}
		
	}
	
	//Setter para poder assignar una array en el main
	public void setPersona(Persona[] persona) {
		this.persona = persona;
	}
	
}
