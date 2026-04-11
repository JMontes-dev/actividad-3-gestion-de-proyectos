package test.daos;

import modelo.dao.PerfilDao;
import modelo.dao.PerfilDaoImplMy8Jpa;
import modelo.entities.Perfil;

public class TestPerfilDao {
	
	private static PerfilDao dao;
	
	static {
		dao = new PerfilDaoImplMy8Jpa();
	}

	public static void main(String[] args) {
		
		alta();
		modificar();
		eliminar();
		uno();
		todos();
		
		
		
	}
	
	private static void alta() {
		System.out.println("=== ALTA ===");
		
		Perfil perf = new Perfil(5, "QA Tester", 110);
		Perfil perf2 = new Perfil(6, "Administrativo", 90);
		
	    System.out.println(dao.alta(perf));
	    System.out.println(dao.alta(perf2));
	    
	    System.out.println(dao.buscarUno(5));
	    System.out.println(dao.buscarUno(6));
		
	}
	
	private static void modificar() {
		 Perfil entity = dao.buscarUno(6);
		 entity.setNombre("Consultor");
		 
		 System.out.println(dao.buscarUno(6));
		 System.out.println(dao.modificar(entity));
		
	}
	
	private static void eliminar() {
		System.out.println("=== ELIMINAR ===");
	
		switch(dao.eliminar(5)) {
		case 1: System.out.println("Eliminado Correctamente"); 
		break;
		case 0: System.out.println("El cliente a Eliminar NO existe"); 
		break;
		case -1: System.out.println("No se ha podido Eliminar");
		break;
		}
		
	}

	private static void uno() {
		System.out.println("=== UNO ===");
		
		System.out.println(dao.buscarUno(4));
	}

	private static void todos() {
		System.out.println("=== TODOS ===");
		
		for (Perfil ele: dao.buscarTodos())
			System.out.println(ele);
	}


}
