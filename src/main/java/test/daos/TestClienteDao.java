package test.daos;



import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jpa;
import modelo.entities.Cliente;



public class TestClienteDao {
	
	private static ClienteDao cdao;
	
	static {
		cdao = new ClienteDaoImplMy8Jpa();
	}

	public static void main(String[] args) {
		
		uno();
		todos();
		alta();
		modificar();
		eliminar();
		
		
		
	}
	
	private static void alta() {
		System.out.println("\n=== ALTA ===");
		
		Cliente cliente = new Cliente("C11111111", "Juan", "Montes Daza", "Baleares", 1500000, 500);
		Cliente cliente2 = new Cliente("C22222222", "James", "Wild", "Barcelona", 900000, 80);
		
	    System.out.println(cdao.alta(cliente));
	    System.out.println(cdao.alta(cliente2));
	    System.out.println((cliente2));
		
	}
	
	private static void modificar() {
		System.out.println("\n=== MODIFICAR ===");
		
		 Cliente cli = cdao.buscarUno("A11111112");
		 cli.setNombre("Raúl");
		 System.out.println(cdao.modificar(cli));
		
	}

	private static void eliminar() {
		System.out.println("\n=== ELIMINAR ===");
	
		switch(cdao.eliminar("C22222222")) {
		case 1: System.out.println("Eliminado Correctamente"); 
		break;
		case 0: System.out.println("El cliente a Eliminar NO existe"); 
		break;
		case -1: System.out.println("No se ha podido Eliminar");
		break;
		}
		
	}

	private static void uno() {
		System.out.println("\n=== UNO ===");
		
		System.out.println(cdao.buscarUno("A11111111"));
	//	System.out.println(cdao.buscarUno("A22222222"));
	//	System.out.println(cdao.buscarUno("C11111111"));
	//	System.out.println(cdao.buscarUno("C22222222"));
		
	}
	
	private static void todos() {
		System.out.println("\n=== TODOS ===");
		
		for (Cliente cli: cdao.buscarTodos())
			System.out.println(cli);
	}
}
