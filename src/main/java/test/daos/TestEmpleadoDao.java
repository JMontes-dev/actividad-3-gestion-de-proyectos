package test.daos;

import modelo.dao.DepartamentoDaoImplMy8Jpa;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8Jpa;
import modelo.entities.Departamento;
import modelo.entities.Empleado;
import modelo.entities.Perfil;

public class TestEmpleadoDao {
	
	private static EmpleadoDao empDao;
	private static DepartamentoDaoImplMy8Jpa depDao;
	private static PerfilDaoImplMy8Jpa perfDao;

	static {
	    empDao = new EmpleadoDaoImplMy8Jpa();
	    depDao = new DepartamentoDaoImplMy8Jpa();
	    perfDao = new PerfilDaoImplMy8Jpa();
	}

	public static void main(String[] args) {
		
		alta();
	//	modificar();
	//	eliminar();
	//	uno();
	//	todos();
		
		
		
	}
	
	private static void alta() {
		System.out.println("=== ALTA ===");
		
	    Departamento dep = DepartamentoDaoImplMy8Jpa.buscarUno(1);
	    Perfil perf = perfilDAO.buscarUno(2);
		
		Empleado emp = new Empleado(121, "Jorge", "Muñoz", 'H', "jmuñoz@gmail.com", "Abc1234", 40000, "2016-10-10", "1990-05-05", 
				"Financiero", "Operativo");
	//	Empleado emp2 = new Empleado(60, "Legal", "Sevilla");
		
	    System.out.println(dao.alta(emp));
	//    System.out.println(dao.alta(emp2));
	    
	    System.out.println(dao.buscarUno(121));
	    System.out.println(dao.buscarUno(120));
		
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
