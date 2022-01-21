package main;

public abstract class Persona {
	
	//Atributos
	protected String nombre;
	protected String apellido;
	protected String fechaNac;
	protected Carnet carnet;
	
	
	//Constructor
	public Persona(String nombre, String apellido, String fechaNac, Carnet carnet) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
		this.carnet = carnet;
	}
	
	//Metodos
	//Metodo para comprobar al fecha
	public String comprobarFecha(String fecha) {
		
		if(fecha.matches("^[0-3][0-9]/[01][0-9]/[12][0-9]{3}$")) {
			
			return fecha;
			
		}else {
			
			return "00/00/0000";
		
		}
		
	}

	public Carnet getCarnet() {
		return carnet;
	}
	 
	
}
