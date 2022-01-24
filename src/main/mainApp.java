package main;
import javax.swing.JOptionPane;

import java.util.ArrayList;
public class mainApp {
	
	
	public static void main(String[] args) {

		//Creamos las arrays necessarias para cada tipo de vehiculo y de personas
		ArrayList<Coche> arrayCoches = new ArrayList<>();
		ArrayList<Moto> arrayMotos = new ArrayList<>();
		ArrayList<Camion> arrayCamiones = new ArrayList<>();
		ArrayList<Titular> arrayTitulares = new ArrayList<>();
		ArrayList<Conductor> arrayConductores = new ArrayList<>();
		
		//Ejecutamos el menú y al finalizar su ejecución mostramos los objetos creados
		menuPrincipal(arrayCoches, arrayMotos, arrayCamiones, arrayTitulares, arrayConductores);//Ejecutamos el menú y como parametros le pasamos los arrays
		mostrarArrays(arrayCoches, arrayMotos, arrayCamiones, arrayTitulares, arrayConductores);
		
	}
	
	//Metodos de menú	
	public static void menuPrincipal(ArrayList<Coche> aCoch, ArrayList<Moto> am, ArrayList<Camion> aCam, ArrayList<Titular> aTit, ArrayList<Conductor> aCond) {
		
		int opcion = 0;
		
		//En el menú principal podemos escojer entre personas o vehiculos, dependiendo de la opcion escojida se ejecutarà su respectivo menú
		do {
			
			String opcionS = JOptionPane.showInputDialog("Selecciona una opción:\n1.Crear una persona\n2.Crear un vehiculo\n3.salir");
			opcion = Integer.parseInt(opcionS); 
			
			switch (opcion) {
				
				case 1:
					menuPersonas(aTit, aCond);
					break;
				case 2:
					menuVehiculos(aCoch, am, aCam, aTit, aCond);
					break;
				case 3:
					break;
				default:
					JOptionPane.showMessageDialog(null, "La opcion introducida no es correcta");
					break;
			}
			
		}while (opcion != 3);
		
	}
	
	public static void menuPersonas(ArrayList<Titular> aTit, ArrayList<Conductor> aCond) {
		
		int opcion = 0;
		
		//En el menú de personas podemos crear titulares y conductores
		do {
			
			String opcionS = JOptionPane.showInputDialog("Selecciona una opción:\n1.Crear un titular\n2.Crear un conductor\n3.salir");
			opcion = Integer.parseInt(opcionS);
			
			switch (opcion) {
				
				case 1:
					crearTitular(aTit);
					break;
				case 2:
					crearConductor(aCond);
					break;
				case 3:
					break;
				default:
					JOptionPane.showMessageDialog(null, "La opcion introducida no es correcta");
					break;
			}
			
		}while (opcion != 3);
		
	}
	
	public static void menuVehiculos(ArrayList<Coche> aCoch, ArrayList<Moto> am, ArrayList<Camion> aCam, ArrayList<Titular> aTit, ArrayList<Conductor> aCond) {
		
		int opcion = 0;
		
		//Menú para crear cada tipo de vehiculo
		do {
			
			String opcionS = JOptionPane.showInputDialog("Escoja una opción:\n1.Crear coche\n2.Crear moto\n3.Crear camion\n4.Salir");
			opcion = Integer.parseInt(opcionS);
			
			switch (opcion) {
		
			case 1:
					crearCoche(aCoch, aTit, aCond);
					break;
			case 2:
					crearMoto(am, aTit, aCond);
					break;
			case 3:
					crearCamion(aCam, aTit, aCond);
					break;
			case 4:
				break;
			default:
				break;
		
			} 

		}while(opcion != 4);
	}
	
	//Metodo para crear coche
	public static void crearCoche(ArrayList<Coche> aCoche, ArrayList<Titular> aTit, ArrayList<Conductor> aCond) {
		
		//Este metodo pide la información necessaria de un coche, después crea un objeto coche y lo assigna 
		//a la array pasada por parametro (se usa el metodo crearRueda() para crear las ruadas del vehiculo).
		//Adremàs assignaremos un titular al vehiculo y tantos conductores como queramos (siempre que el conductor tenga el carnet necessario).
		
		int correcto = 0;
		Titular t = null;
		ArrayList<Persona> alp = new ArrayList<>();
		
		//Pedimos los datos del vehiculo
		String matricula = JOptionPane.showInputDialog("Inserta la matricula del vehiculo");
		String marca = JOptionPane.showInputDialog("Inserta la marca del vehiculo");
		String color = JOptionPane.showInputDialog("Inserta el color del vehiculo");
		
		JOptionPane.showMessageDialog(null, "Inserta los valores de las ruedas delanteras");
		Rueda rd = crearRueda('d');
		
		JOptionPane.showMessageDialog(null, "Inserta los valores de las ruedas traseras");
		Rueda rt = crearRueda('t');
		
		//Comprovamos si el titular existe y los assignamos al vehiculo
		do {
			String titular = JOptionPane.showInputDialog("Inserta el nombre del titular del vehiculo");
			
			for (int i=0; i<aTit.size();i++) {
				
				if (titular.equals(aTit.get(i).getNombre())) {
					t = aTit.get(i);
					correcto = 1;
				}
				
			}
			
			if (correcto == 0) {
				JOptionPane.showMessageDialog(null, "El nombre del titular no es correcto");
			}
		
		}while(correcto != 1);
		
		//Preguntamos si queremos crear conductores
		String res = JOptionPane.showInputDialog("Quiere añadir otro conductor al vehiculo?(S/N)");
		res = res.toUpperCase();
		
		//Si la respuesta es afirmativa entraremos en un bucle de creación de conductores
		if(res.equals("S")) {
			
			correcto = 0;
			String numCondS = JOptionPane.showInputDialog("Quantos conductores vas a añadir?");
			int numCond = Integer.parseInt(numCondS), cont = 0;
			
			do {
				
				do {
					correcto = 0;
					String cond = JOptionPane.showInputDialog("Inserta el nombre del conductor del vehiculo");
										
					for (int i=0; i<aCond.size();i++) {
						
						if ((cond.equals(aCond.get(i).getNombre())) && (validarPermiso(aCond.get(i).getCarnet(), 'B'))) {
							alp.add(aCond.get(i));
							correcto = 1;
						}
						
					}
					
					if (correcto == 0) {
						JOptionPane.showMessageDialog(null, "El nombre del titular no es correcto o su carnet no le permite conducir el vehiculo");
					}
					
				}while (correcto != 1);
				
				cont++;
				
			}while(cont != numCond);
			
		}
		
		//Creamos un coche con los datos introducidos y los introduzco en la array
		Coche c = new Coche(matricula, marca, rt, rd, color, t);
		
		Persona[] aP = new Persona[alp.size()];
		
		aP = alp.toArray(aP);
		
		c.setPersona(aP);
		
		aCoche.add(c);			
	}
	
	//Metodo para crear camion
	public static void crearCamion(ArrayList<Camion> aCamion, ArrayList<Titular> aTit, ArrayList<Conductor> aCond) {
		
		//Este mètodo realiza lo mismo que el metodo anterior pero con el vehiculo de tipo camion
		
		int correcto = 0;
		Titular t = null;
		ArrayList<Persona> alp = new ArrayList<>();
		
		String matricula = JOptionPane.showInputDialog("Inserta la matricula del vehiculo");
		String marca = JOptionPane.showInputDialog("Inserta la marca del vehiculo");
		String color = JOptionPane.showInputDialog("Inserta el color del vehiculo");
		
		JOptionPane.showMessageDialog(null, "Inserta los valores de las ruedas delanteras");
		Rueda rd = crearRueda('d');
		
		JOptionPane.showMessageDialog(null, "Inserta los valores de las ruedas traseras");
		Rueda rt = crearRueda('t');
		
		do {
			String titular = JOptionPane.showInputDialog("Inserta el nombre del titular del vehiculo");
			
			for (int i=0; i<aTit.size();i++) {
				
				if (titular.equals(aTit.get(i).getNombre())) {
					t = aTit.get(i);
					correcto = 1;
				}
				
			}
			
			if (correcto == 0) {
				JOptionPane.showMessageDialog(null, "El nombre del titular no es correcto");
			}
		
		}while(correcto != 1);
		
		String res = JOptionPane.showInputDialog("Quiere añadir otro conductor al vehiculo?(S/N)");
		res = res.toUpperCase();
		
		if(res.equals("S")) {
			
			correcto = 0;
			String numCondS = JOptionPane.showInputDialog("Quantos conductores vas a añadir?");
			int numCond = Integer.parseInt(numCondS), cont = 0;
			
			do {
				
				do {
					correcto = 0;
					String cond = JOptionPane.showInputDialog("Inserta el nombre del conductor del vehiculo");
										
					for (int i=0; i<aCond.size();i++) {
						
						if ((cond.equals(aCond.get(i).getNombre())) && (validarPermiso(aCond.get(i).getCarnet(), 'B'))) {
							alp.add(aCond.get(i));
							correcto = 1;
						}
						
					}
					
					if (correcto == 0) {
						JOptionPane.showMessageDialog(null, "El nombre del titular no es correcto");
					}
					
				}while (correcto != 1);
				
				cont++;
				
			}while(cont != numCond);
			
		}
		
		
		Camion c = new Camion(matricula, marca, rt, rd, color, t);
		
		Persona[] aP = new Persona[alp.size()];
		
		aP = alp.toArray(aP);
		
		c.setPersona(aP);
		
		aCamion.add(c);		
		
	}
	
	//Metodo para crear moto
	public static void crearMoto(ArrayList<Moto> aMoto, ArrayList<Titular> aTit, ArrayList<Conductor> aCond) {
		
		//Este mètodo realiza lo mismo que el metodo anterior pero con el vehiculo de tipo camion
		int correcto = 0;
		Titular t = null;
		ArrayList<Persona> alp = new ArrayList<>();
		
		String matricula = JOptionPane.showInputDialog("Inserta la matricula del vehiculo");
		String marca = JOptionPane.showInputDialog("Inserta la marca del vehiculo");
		String color = JOptionPane.showInputDialog("Inserta el color del vehiculo");
		
		JOptionPane.showMessageDialog(null, "Inserta los valores de las ruedas delanteras");
		Rueda rd = crearRueda('d');
		
		JOptionPane.showMessageDialog(null, "Inserta los valores de las ruedas traseras");
		Rueda rt = crearRueda('t');
		
		do {
			String titular = JOptionPane.showInputDialog("Inserta el nombre del titular del vehiculo");
			
			for (int i=0; i<aTit.size();i++) {
				
				if (titular.equals(aTit.get(i).getNombre())) {
					t = aTit.get(i);
					correcto = 1;
				}
				
			}
			
			if (correcto == 0) {
				JOptionPane.showMessageDialog(null, "El nombre del titular no es correcto");
			}
		
		}while(correcto != 1);
		
		String res = JOptionPane.showInputDialog("Quiere añadir otro conductor al vehiculo?(S/N)");
		res = res.toUpperCase();
		
		if(res.equals("S")) {
			
			correcto = 0;
			String numCondS = JOptionPane.showInputDialog("Quantos conductores vas a añadir?");
			int numCond = Integer.parseInt(numCondS), cont = 0;
			
			do {
				
				do {
					correcto = 0;
					String cond = JOptionPane.showInputDialog("Inserta el nombre del conductor del vehiculo");
										
					for (int i=0; i<aCond.size();i++) {
						
						if ((cond.equals(aCond.get(i).getNombre())) && (validarPermiso(aCond.get(i).getCarnet(), 'B'))) {
							alp.add(aCond.get(i));
							correcto = 1;
						}
						
					}
					
					if (correcto == 0) {
						JOptionPane.showMessageDialog(null, "El nombre del titular no es correcto");
					}
					
				}while (correcto != 1);
				
				cont++;
				
			}while(cont != numCond);
			
		}
		
		
		Moto c = new Moto(matricula, marca, rt, rd, color, t);
		
		Persona[] aP = new Persona[alp.size()];
		
		aP = alp.toArray(aP);
		
		c.setPersona(aP);
		
		aMoto.add(c);	
		
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
	public static void crearTitular(ArrayList<Titular> aTit) {
		
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
		
		aTit.add(t);
		
	}
	
	//Metodo que comprueba el tipo de carnet
	public static boolean validarPermiso(Carnet c, char carnetNec) {
		
		if (c.getTipoLicencia() >= carnetNec) { //Este if compara el carnet pasado por parametro con la variable global que contiene el carnet necessario para conducir el vehiculo
			return true;
		}else {
			return false;
		}
		
	}
	
	//Metodo para crear un conductor
	public static void crearConductor(ArrayList<Conductor> aCond) {
		
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
		
		aCond.add(cond);
		
	}
	
	//Mostramos todos los arrays de objetos
	public static void mostrarArrays(ArrayList<Coche> aCoch, ArrayList<Moto> am, ArrayList<Camion> aCam, ArrayList<Titular> aTit, ArrayList<Conductor> aCond) {
		
		System.out.println("Vehiculos:\n");
		System.out.println("Coches:\n");
		
		//Mostramos cada array usando un for con el metodo toString
		for(int i=0; i<aCoch.size(); i++) {
			
			System.out.println(aCoch.get(i).toString()); 
			
		}
				
		System.out.println("Motos:\n");
		
		for(int i=0; i<am.size(); i++) {
			
			System.out.println(am.get(i).toString()); 
			
		}
		
		System.out.println("Camiones:\n");
		
		for(int i=0; i<aCam.size(); i++) {
			
			System.out.println(aCam.get(i).toString()); 
			
		}
		
		System.out.println("Titulares:\n");
		
		for(int i=0; i<aTit.size(); i++) {
			
			System.out.println(aTit.get(i).toString()); 
			
		}
		
		System.out.println("Conductores:\n");
		
		for(int i=0; i<aCond.size(); i++) {
			
			System.out.println(aCond.get(i).toString()); 
			
		}
	}
	
}
