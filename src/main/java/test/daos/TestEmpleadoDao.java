package test.daos;

import java.time.LocalDate;

import modelo.dao.DepartamentoDao;
import modelo.dao.DepartamentoDaoImplMy8Jpa;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8Jpa;
import modelo.dao.PerfilDao;
import modelo.dao.PerfilDaoImplMy8Jpa;
import modelo.entities.Departamento;
import modelo.entities.Empleado;
import modelo.entities.Perfil;

public class TestEmpleadoDao {
	
	private static EmpleadoDao empDao;
	private static DepartamentoDao depDao;
	private static PerfilDao perfDao;

	static {
	    empDao = new EmpleadoDaoImplMy8Jpa();
	    depDao = new DepartamentoDaoImplMy8Jpa();
	    perfDao = new PerfilDaoImplMy8Jpa();
	}

	public static void main(String[] args) {
		
	//	alta();
	//	modificar();
	//	eliminar();
	//	uno();
	//	todos();
		porDepartamento();
		porGenero();
		porApellido();
		salarioTotal();
		totalPorDepartamento();
		
		
		
	}
	

	private static void alta() {
		System.out.println("\n=== ALTA ===");
		
		Empleado emp = new Empleado(0, "Jorge", "Muñoz", 'H', "jmuñoz@gmail.com", "Abc1234", 40000, 
			    			LocalDate.of(2016, 10, 10), LocalDate.of(1990, 5, 5), 
			    			depDao.buscarUno(20), perfDao.buscarUno(3));
		
		Empleado emp2 = new Empleado(0, "Marie", "Smith", 'M', "mariesmth@gmail.com", "Mmm4321", 80000, 
							LocalDate.of(2012, 3, 2), LocalDate.of(1988, 8, 4), 
							depDao.buscarUno(10), perfDao.buscarUno(1));
		
	    System.out.println(empDao.alta(emp));
	    System.out.println(empDao.alta(emp2));
	    
	    System.out.println(empDao.buscarUno(121));
	    System.out.println(empDao.buscarUno(122));
		
	}
	
	private static void modificar() {
		System.out.println("\n=== MODIFICAR ===");
		
		 Empleado entity2 = empDao.buscarUno(121);
		 entity2.setApellidos("Hernández");
		 
		 System.out.println(empDao.buscarUno(121));
		 System.out.println(empDao.modificar(entity2));
		 
		 
		 
		 Empleado entity = empDao.buscarUno(122);
		 entity.setSalario(85000);
		 
		 System.out.println(empDao.buscarUno(122));
		 System.out.println(empDao.modificar(entity));
	}
	
	private static void eliminar() {
		System.out.println("\n=== ELIMINAR ===");
	
		switch(empDao.eliminar(122)) {
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
		
		System.out.println(empDao.buscarUno(121));
	}

	
	private static void todos() {
		System.out.println("\n=== TODOS ===");
		
		for (Empleado ele: empDao.buscarTodos())
			System.out.println(ele);
	}
	
	private static void porDepartamento() {
		System.out.println("\n=== EMPLEADOS POR DEPARTAMENTO ===");
		
		for (Empleado ele: empDao.empleadosByDepartamento(10))
			System.out.println(ele);
	}
	
	private static void porGenero() {
		System.out.println("\n=== EMPLEADOS POR GÉNERO ===");
		
		for (Empleado ele: empDao.empleadosByGenero('h'))
			System.out.println(ele);
	}
	
	private static void porApellido() {
		System.out.println("\n=== EMPLEADOS POR APELLIDO ===");
		
		for (Empleado ele: empDao.empleadosByApellido("koo"))
			System.out.println(ele);
	}
	

	private static void salarioTotal() {
		System.out.println("\n=== SALARIO TOTAL ===");
		
		System.out.println(empDao.salarioTotal());
	}
	
	private static void totalPorDepartamento() {
		System.out.println("\n=== SALARIO TOTAL POR DEPARTAMENTO ===");
		
		System.out.println(empDao.salarioTotal(10));
	}

}
