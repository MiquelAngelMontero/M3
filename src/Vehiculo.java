
public abstract class Vehiculo implements Matriculable {
	
	//Atributos
	protected String matricula;
	protected String marca;
	protected Rueda trasera;
	protected Rueda delantera;
	protected String color;
	
	//Constructor
	public Vehiculo(String matricula, String marca, Rueda trasera, Rueda delantera, String color) {
		this.matricula = matricula;
		this.marca = marca;
		this.trasera = trasera;
		this.delantera = delantera;
		this.color = color;
	}
	
	//Metodos
	//Metodo para comprobar la matricula
	@Override
	public String comptrobarMatricula() {
		// TODO Auto-generated method stub
		
		if ((matricula.toUpperCase().matches("^[0-9]{4}[A-Z]{3}$")) || (matricula.toUpperCase().matches("^[0-9]{4}[A-Z]{2}$"))) {
			
			return "matricula";
			
		}else {
			
			return "0000AAA";
			
		}
		
	}

}
