package main;
import javax.swing.JOptionPane;

import java.util.ArrayList;
public class mainApp {

	public static void main(String[] args) {
		ArrayList<Coche> arrayCoches = new ArrayList<>();
		ArrayList<Moto> arrayMotos = new ArrayList<>();
		ArrayList<Camion> arrayCamiones = new ArrayList<>();
		
		Titular t1 = crearTitular();
		menu(arrayCoches, arrayMotos, arrayCamiones, t1);
		String respuesta = JOptionPane.showInputDialog("El tiutlar serà el conductor del vehiculo? (S/N)");
		respuesta = respuesta.toUpperCase();
		
		if (respuesta.equals("N")) {
			crearConductor();
		}
		
		
	}
	
	//Metodo menú
	public static void menu(ArrayList<Coche> aCoch, ArrayList<Moto> am, ArrayList<Camion> aCam, Titular t) {
		
		int opcion = 0;
		
		
		do {
			
			String opcionS = JOptionPane.showInputDialog("Escoja una opción:\n1.Crear coche\n2.Crear moto\n3.Crear camion4.Salir");
			opcion = Integer.parseInt(opcionS);
			
			switch (opcion) {
		
			case 1:
				if(validarPermiso(t.getCarnet(), 'B')) {
					crearCoche(aCoch);
				}else {
					JOptionPane.showMessageDialog(null, "El carnet del titular no es suficiente");
					opcion = 4;
					break;
				}
			case 2:
				if(validarPermiso(t.getCarnet(), 'A')) {
					crearMoto(am);
				}else {
					JOptionPane.showMessageDialog(null, "El carnet del titular no es suficiente");
					opcion = 4;
					break;
				}
			case 3:
				if(validarPermiso(t.getCarnet(), 'C')) {
					crearCamion(aCam);
				}else {
					JOptionPane.showMessageDialog(null, "El carnet del titular no es suficiente");
					opcion = 4;
					break;
				}
			case 4:
				break;
			default:
				break;
		
			}
			
		}while(opcion != 4);
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
	
	//Metodo para crear camion
	public static void crearCamion(ArrayList<Camion> aCamion) {
		
		String matricula = JOptionPane.showInputDialog("Inserta la matricula del vehiculo");
		String marca = JOptionPane.showInputDialog("Inserta la marca del vehiculo");
		String color = JOptionPane.showInputDialog("Inserta el color del vehiculo");
		
		JOptionPane.showMessageDialog(null, "Inserta los valores de las ruedas delanteras");
		Rueda rd = crearRueda('d');
		
		JOptionPane.showMessageDialog(null, "Inserta los valores de las ruedas traseras");
		Rueda rt = crearRueda('t');
		
		Camion c = new Camion(matricula, marca, rt, rd, color);
		aCamion.add(c);
		
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
	
	//Metodo para crear un titular
	public static Titular crearTitular() {
		
		boolean garajePropio = false, seguro = false;
		
		String nombre = JOptionPane.showInputDialog("Inserta el nombre del titular");
		String apellido = JOptionPane.showInputDialog("Inserta el apellido del titular");
		String fechaNac = JOptionPane.showInputDialog("Inserta la fecha de nacimiento del titular");
		
		String idS = JOptionPane.showInputDialog("Inserta el id del carnet del titular");
		int id = Integer.parseInt(idS);
		String licS = JOptionPane.showInputDialog("Inserta el tipo de licencia del titular (A,B,C,D)");
		char lic = licS.charAt(0);
		
		String nomCom = nombre+" "+apellido;
		
		String fechaCad = JOptionPane.showInputDialog("Inserta la fecha de caducidad del carnet del titular");
		
		String res1 = JOptionPane.showInputDialog("Inserta si el titular tiene garaje propio (S/N)");
		res1 = res1.toUpperCase();
		
		if (res1.equals("S")) {
			garajePropio = true;
		}
		
		String res2 = JOptionPane.showInputDialog("Inserta si el titular tiene seguro (S/N)");
		res2 = res2.toUpperCase();
		
		if (res2.equals("S")) {
			garajePropio = true;
		}
		
		Carnet c = new Carnet(id, lic, nomCom, fechaCad);
		Titular t = new Titular(nombre, apellido, fechaNac, c, garajePropio, seguro);
		
		return t;
		
	}
	
	//Metodo que comprueba el tipo de carnet
	public static boolean validarPermiso(Carnet c, char carnetNec) {
		
		if (c.getTipoLicencia() >= carnetNec) {
			return true;
		}else {
			return false;
		}
		
	}
	
	//Metodo para crear un titular
	public static Conductor crearConductor() {
		
		String nombre = JOptionPane.showInputDialog("Inserta el nombre del conductor");
		String apellido = JOptionPane.showInputDialog("Inserta el apellido del conductor");
		String fechaNac = JOptionPane.showInputDialog("Inserta la fecha de nacimiento del conductor");
		
		String idS = JOptionPane.showInputDialog("Inserta el id del carnet del conductor");
		int id = Integer.parseInt(idS);
		String licS = JOptionPane.showInputDialog("Inserta el tipo de licencia del conductor (A,B,C,D)");
		char lic = licS.charAt(0);
		
		String nomCom = nombre+" "+apellido;
		
		String fechaCad = JOptionPane.showInputDialog("Inserta la fecha de caducidad del carnet del conductor");
		
		
		Carnet c = new Carnet(id, lic, nomCom, fechaCad);
		Conductor cond = new Conductor(nombre, apellido, fechaNac, c);
		
		return cond;
		
	}
	
}
