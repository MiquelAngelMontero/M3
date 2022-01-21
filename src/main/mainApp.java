package main;
import javax.swing.JOptionPane;

import java.util.ArrayList;
public class mainApp {
	
	static char carnetNec = 0;
	
	public static void main(String[] args) {

		//Creamos las arrays necessarias para cada tipo de vehiculo
		ArrayList<Coche> arrayCoches = new ArrayList<>();
		ArrayList<Moto> arrayMotos = new ArrayList<>();
		ArrayList<Camion> arrayCamiones = new ArrayList<>();
		
		//Creamos un titular con el metodo crear titular
		Titular t1 = crearTitular();
		menu(arrayCoches, arrayMotos, arrayCamiones, t1);//Ejecutamos el menú y como parametros le pasamos los arrays y el titular creado anteriormente
		
		String respuesta = JOptionPane.showInputDialog("El tiutlar serà el conductor del vehiculo? (S/N)");//Al acabar la ejecucion del menú y haber creado el vehiculo
		respuesta = respuesta.toUpperCase();															   //preguntamos al usuario si va a ser el conductor del vehiculo
																										   //para crear un conductor o no.
		//Deoendiendo de la respuesta se crea el conductor o no
		if (respuesta.equals("N")) {
			Conductor c1 = crearConductor();
			//Si el conductor es creado tambien se comprueba si tiene licencia suficiente para usar el vehiculo
			if (c1.getCarnet().getTipoLicencia() < carnetNec) {
				JOptionPane.showMessageDialog(null, "El conductor no tiene el permiso suficiente para conducir el vehiculo");
			}
		}
		
		
	}
	
	//Metodo menú
	public static void menu(ArrayList<Coche> aCoch, ArrayList<Moto> am, ArrayList<Camion> aCam, Titular t) {
		
		int opcion = 0;
		
		//El metodo menú consiste en un switch dentro de un while, el while acabara quando se seleccione una opción
		do {
			
			String opcionS = JOptionPane.showInputDialog("Escoja una opción:\n1.Crear coche\n2.Crear moto\n3.Crear camion\n4.Salir");
			opcion = Integer.parseInt(opcionS);
			
			switch (opcion) {
		
			case 1:
				carnetNec = 'B';							//Cada caso del switch assigna el carnet mínimo necesario para llevar el vehiculo de esa opción.
				if(validarPermiso(t.getCarnet())) {			//Seguidamente llama al metodo validar permiso el qual comprueva si el conductor puede llevar el vehiculo.
					crearCoche(aCoch);						//Si es así se crea el vehiculo y se sale del bucle, si no es así se sale del bucle directamente.
					opcion = 4;
					break;
				}else {
					JOptionPane.showMessageDialog(null, "El carnet del titular no es suficiente");
					opcion = 4;
					break;
				}
			case 2:
				carnetNec = 'A';
				if(validarPermiso(t.getCarnet())) {;
					crearMoto(am);
					opcion = 4;
					break;
				}else {
					JOptionPane.showMessageDialog(null, "El carnet del titular no es suficiente");
					opcion = 4;
					break;
				}
			case 3:
				carnetNec = 'C';
				if(validarPermiso(t.getCarnet())) {
					crearCamion(aCam);
					opcion = 4;
					break;
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
		
		//Este metodo pide la información necessaria de un coche, después crea un objeto coche y lo assigna 
		//a la array pasada por parametro (se usa el metodo crearRueda() para crear las ruadas del vehiculo)
		
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
		
		//Este metodo pide la información necessaria de un camion, después crea un objeto camion y lo assigna 
		//a la array pasada por parametro (se usa el metodo crearRueda() para crear las ruadas del vehiculo)
		
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
		
		//Este metodo pide la información necessaria de una moto, después crea un objeto moto y lo assigna 
		//a la array pasada por parametro (se usa el metodo crearRueda() para crear las ruadas del vehiculo)
		
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
		
		//Este metodo pregunta todos los datos necessarios para crear una rueda, crea el objeto rueda y lo devuleve con un return
		
		String marca = JOptionPane.showInputDialog("Inserta la marca de la rueda");
		String diametroS = JOptionPane.showInputDialog("Inserta el diametre de la roda");
		double diametro = Double.parseDouble(diametroS);
		
		Rueda r = new Rueda(diametro, marca, dT);
		
		return r;
		
		
	}
	
	//Metodo para crear un titular
	public static Titular crearTitular() {
		
		//Este metodo obtiene los datos necessarios para crear un carnet, un titular y assignarle el carnet creado a ese titular
		
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
	public static boolean validarPermiso(Carnet c) {
		
		if (c.getTipoLicencia() >= carnetNec) { //Este if compara el carnet pasado por parametro con la variable global que contiene el carnet necessario para conducir el vehiculo
			return true;
		}else {
			return false;
		}
		
	}
	
	//Metodo para crear un titular
	public static Conductor crearConductor() {
		
		//Metodo similar al de titular pero con los atributos necessarios para un conductor
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
