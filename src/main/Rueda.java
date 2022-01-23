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
	//Comprovar diametro de la rueda (se ejecuta en el constructor)
	public double comprobarDiametro(double d) {
		//Hacemos un if que defina el diametro de cada rueda entre 0.4 y 4 (si no por defecto devolverá 1)
		if(diametro >= 0.4 || diametro <= 4) {
			return diametro;
		}else {
			return 1;
		}
		
	}
	
	//Comprovar rueda delantera o trasera (se ejecuta en el constructor)
	public String comprovarRueda(char chardt) {
		
		//Transforma el caracter a String para evitar errores al esctibir la posición
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

	@Override
	public String toString() {
		return "Diametro: " + diametro + ", Marca:" + marca;
	}

	
}
