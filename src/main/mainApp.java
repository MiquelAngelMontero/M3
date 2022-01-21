package main;
import javax.swing.JOptionPane;

import java.util.ArrayList;
public class mainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Coche> arrayCoches = new ArrayList<>();
		ArrayList<Moto> arrayMotos = new ArrayList<>();
		
		menu(arrayCoches, arrayMotos);
		System.out.println(arrayCoches.get(0).toString());

	}
	
	//Metodo menú
	public static void menu(ArrayList<Coche> ac, ArrayList<Moto> am) {
		
		int opcion = 0;
		
		
		do {
			
			String opcionS = JOptionPane.showInputDialog("Escoja una opción:\n1.Crear coche\n2.Crear moto\n3.Salir");
			opcion = Integer.parseInt(opcionS);
			
			switch (opcion) {
		
			case 1:
				crearCoche(ac);
				break;
			case 2:
				crearMoto(am);
				break;
			case 3:
				break;
			default:
				break;
		
			}
			
		}while(opcion != 3);
	}
	
	//Metodo para crear coche
	public static void crearCoche(ArrayList<Coche> aCoche) {
		
		String matricula = JOptionPane.showInputDialog("Inserta la matricula del vehiculo");
		String marca = JOptionPane.showInputDialog("Inserta la marca del vehiculo");
		String color = JOptionPane.showInputDialog("Inserta el color del vehiculo");
		
		JOptionPane.showMessageDialog(null, "Inserta los valores de las ruedas delanteras");
		Rueda rd = crearRueda('d');
		
		JOptionPane.showMessageDialog(null, "Inserta los valores de las ruedas traseras");
		Rueda rt = crearRueda('t');
		
		Coche c = new Coche(matricula, marca, rt, rd, color);
		aCoche.add(c);
		
	}
	
	//Metodo para crear moto
	public static void crearMoto(ArrayList<Moto> aMoto) {
		
		String matricula = JOptionPane.showInputDialog("Inserta la matricula del vehiculo");
		String marca = JOptionPane.showInputDialog("Inserta la marca del vehiculo");
		String color = JOptionPane.showInputDialog("Inserta el color del vehiculo");
		
		JOptionPane.showMessageDialog(null, "Inserta el valor de la rueda delantera");
		Rueda rd = crearRueda('d');
		
		JOptionPane.showMessageDialog(null, "Inserta el valor de la rueda trasera");
		Rueda rt = crearRueda('t');
		
		Moto m = new Moto(matricula, marca, rt, rd, color);
		aMoto.add(m);
		
	}
	
	//Metodo para crear una rueda
	public static Rueda crearRueda(char dT) {
		
		String marca = JOptionPane.showInputDialog("Inserta la marca de la rueda");
		String diametroS = JOptionPane.showInputDialog("Inserta el diametre de la roda");
		double diametro = Double.parseDouble(diametroS);
		
		Rueda r = new Rueda(diametro, marca, dT);
		
		return r;
		
		
	}
	
}
