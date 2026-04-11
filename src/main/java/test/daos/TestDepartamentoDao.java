package test.daos;

import modelo.dao.DepartamentoDao;
import modelo.dao.DepartamentoDaoImplMy8Jpa;
import modelo.entities.Departamento;

public class TestDepartamentoDao {
	
	private static DepartamentoDao dao;
	
	static {
		dao = new DepartamentoDaoImplMy8Jpa();
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
		
		Departamento dep = new Departamento(50, "Marketing", "Sevilla");
		Departamento dep2 = new Departamento(60, "Legal", "Sevilla");
		
	    System.out.println(dao.alta(dep));
	    System.out.println(dao.alta(dep2));
	    
	    System.out.println(dao.buscarUno(50));
	    System.out.println(dao.buscarUno(60));
		
	}
	
	private static void modificar() {
		 Departamento entity = dao.buscarUno(60);
		 entity.setNombre("Diseño");
		 
		 System.out.println(dao.buscarUno(60));
		
	}
	
	private static void eliminar() {
		System.out.println("=== ELIMINAR ===");
	
		switch(dao.eliminar(50)) {
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
		
		System.out.println(dao.buscarUno(60));
	}

	private static void todos() {
		System.out.println("=== TODOS ===");
		
		for (Departamento ele: dao.buscarTodos())
			System.out.println(ele);
	}


}
