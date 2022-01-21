package main;

public class Rueda {
	
	//Atributos
	private double diametro;
	private String marca;
	private String delTras;
	
	//Constructores
	public Rueda(double diametro, String marca, char delTras) {
		this.diametro = comprobarDiametro(diametro);
		this.marca = marca;
		this.delTras = comprovarRueda(delTras);
	}
	
	//Metodos
	//Comprovar diametro de la rueda
	public double comprobarDiametro(double d) {
		
		if(diametro >= 0.4 || diametro <= 4) {
			return diametro;
		}else {
			return 1;
		}
		
	}
	
	//Comprovar rueda delantera o trasera
	public String comprovarRueda(char chardt) {
		
		chardt = Character.toLowerCase(chardt);
		
		if(chardt == 'd') {
			return "Delantera";
		}else if(chardt == 't') {
			return "Trasera";
		}else {
			System.out.println("La posición de la rueda introducida no es correcta (por defecto se assignará delantera)");
			return "Delantera";
		}
		
	}
	
}
