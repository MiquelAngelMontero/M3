package main;

public abstract class Persona {
	
	//Atributos
	protected String nombre;
	protected String apellido;
	protected String fechaNac;
	protected Carnet carnet;
	
	
	//Constructor (Aún que no se vaya a construir ningun vehiculo como tal, she ha de hacer el constructor 
	//para que los hijos de esta clase lo hereden)
	public Persona(String nombre, String apellido, String fechaNac, Carnet carnet) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = comprobarFecha(fechaNac);
		this.carnet = carnet;
	}
	
	//Metodos
	//Metodo para comprobar al fecha (se ejecuta en el constructor)
	public String comprobarFecha(String fecha) {
		
		//If para comprovar que se cumple la estructura de una fecha dd/mm/aaaa sino por defecto 
		//devolverá 00/00/0000
		if(fecha.matches("^[0-3][0-9]/[01][0-9]/[12][0-9]{3}$")) {
			
			return fecha;
			
		}else {
			
			return "00/00/0000";
		
		}
		
	}
	
	//Getter para poder obtener el carnet en la clase main
	public Carnet getCarnet() {
		return carnet;
	}

	public String getNombre() {
		return nombre;
	}
	 

	
}
