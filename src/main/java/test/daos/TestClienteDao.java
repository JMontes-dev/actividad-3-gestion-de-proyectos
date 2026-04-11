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
		
		//uno();
		//alta();
		//eliminar();
		//todos();
		
	}
	
	private static void todos() {
		for (Cliente cli: cdao.findAll())
			System.out.println(cli);
	}

	private static void eliminar() {
	
		switch(cdao.eliminar("C22222222")) {
		case 1: System.out.println("Eliminado Correctamente"); 
		break;
		case 0: System.out.println("El cliente a Eliminar NO existe"); 
		break;
		case -1: System.out.println("No se ha podido Eliminar");
		break;
		}
		
	}

	private static void alta() {
		Cliente cliente = new Cliente("C11111111", "Juan", "Montes Daza", "Baleares", 1500000, 500);
		Cliente cliente2 = new Cliente("C22222222", "James", "Wild", "Barcelona", 900000, 80);
		 
		
	}

	private static void uno() {
		System.out.println(cdao.buscarUno("A11111111"));
		System.out.println(cdao.buscarUno("A22222222"));
		System.out.println(cdao.buscarUno("C11111111"));
		System.out.println(cdao.buscarUno("C22222222"));
		
		
	}
}
