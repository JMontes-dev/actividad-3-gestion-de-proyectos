package principales;

import java.util.Scanner;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jpa;
import modelo.entities.Cliente;

public class GestionClientes {

	public static void main(String[] args) {

		menuGestionClintes();
		

	}
	
	public static void menuGestionClintes() {
		
		ClienteDao dao = new ClienteDaoImplMy8Jpa();
		
		Scanner scanner = new Scanner(System.in);
		
		int opcion = 0;
		
		do {
			System.out.println("\n=== MENÚ ===");
			System.out.println("1. Alta del Cliente");
			System.out.println("2. Buscar un Cliente");
			System.out.println("3. Mostrar Todos");
			System.out.println("4. Eliminar un cliente");
			System.out.println("5. Salir");
			
			opcion = scanner.nextInt();
			
			
			 switch(opcion) {
			 			 
			 	case 1:
			 		System.out.println("Introduce los Siguientes Datos: ");
			 	    scanner.nextLine(); // Limpiar búfer

			 	    System.out.print("CIF (Obligatorio): ");
			 	    String cif = scanner.nextLine();
			 	    
			 	    System.out.print("Nombre (Obligatorio): ");
			 	    String nombre = scanner.nextLine();
			 	    
			 	    System.out.print("Apellidos (Obligatorio): ");
			 	    String apellidos = scanner.nextLine();

			 	    System.out.print("Domicilio: ");
			 	    String domicilio = scanner.nextLine();

			 	    System.out.print("Facturación Anual: ");
			 	    double facturacion = scanner.nextDouble();

			 	    System.out.print("Número de Empleados: ");
			 	    int numEmpleados = scanner.nextInt();


			 	    Cliente c = new Cliente(cif, nombre, apellidos, domicilio, facturacion, numEmpleados);
			 	    if (dao.alta(c) == 1) {
			 	        System.out.println("Cliente guardado exitosamente");
			 	    } else {
			 	        System.out.println("Error al guardar Cliente. Comprueba si el CIF ya existe.");
			 	    } 	    
				break;
				 
			    case 2:
				    System.out.println("Introduce el Cif del Cliente que quieres buscar: ");
				    cif = scanner.next();
				    
				    Cliente cliente = dao.buscarUno(cif); 
				    
				    if (cliente != null) {
				    	System.out.println(cliente);
				    	
				    } else {
				    	System.out.println("El Cif del Cliente no existe");
				    	}
			    break;
			    
			    case 3:
			    	System.out.println("=== CLIENTES ===");
					for (Cliente cli: dao.buscarTodos())
						System.out.println(cli);
			    break;
			    
			    case 4:
			    	System.out.println("Introduce el Cif del Cliente que quieres eliminar: ");
			    	cif = scanner.next();
				   
					switch(dao.eliminar(cif)) {
					case 1: System.out.println("Eliminado Correctamente"); 
					break;
					case 0: System.out.println("El cliente a Eliminar NO existe"); 
					break;
					case -1: System.out.println("No se ha podido Eliminar");
					break;
					}
				    
			    break;
			 }

			 
		} while (opcion != 5);
		

		    
		    
		   	 
		
	
		
	}

}
