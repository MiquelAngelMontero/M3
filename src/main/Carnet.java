package main;

public class Carnet {
	
	//Atributos
	private int id;
	private char tipoLicencia;
	private String nombreCompleto;
	private String fechaCad;
	
	//Constructor
	public Carnet(int id, char tipoLicencia, String nombreCompleto, String fechaCad) {
		this.id = id;
		this.tipoLicencia = validarCarnet(tipoLicencia);
		this.nombreCompleto = nombreCompleto;
		this.fechaCad = fechaCad;
	}
	
	//Metodos
	//Metodo para comprobar el formato de la fecha
	public String comprobarFecha(String fecha) {
		
		if(fecha.matches("^[0-3][0-9]/[01][0-9]/[12][0-9]{3}$")) {
			
			return fecha;
			
		}else {
			
			return "00/00/0000";
		
		}
		
	}
	
	//Metodo para comprobar el carnet
	public char validarCarnet(char carnet) {
		
		carnet = Character.toUpperCase(carnet);
		
		if (carnet >= 'A' && carnet <= 'D') {
			
			return carnet;
			
		}else {
			return 'A';
		}
		
	}

	public char getTipoLicencia() {
		return tipoLicencia;
	}	

}
