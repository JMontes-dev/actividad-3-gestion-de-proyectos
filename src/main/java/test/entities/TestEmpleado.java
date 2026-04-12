package test.entities;

import modelo.dao.DepartamentoDao;
import modelo.dao.DepartamentoDaoImplMy8Jpa;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8Jpa;
import modelo.entities.Empleado;

public class TestEmpleado {
	
	private static EmpleadoDao empleadoDao;
	
	static {
		empleadoDao = new EmpleadoDaoImplMy8Jpa();
	}

	public static void main(String[] args) {
		
		nombreCompleto();
		literal();
		salarioPorMeses();
		

	}
	
	private static void nombreCompleto() {

		System.out.println("\n=== NOMBRE COMPLETO ===");
		
		System.out.println(empleadoDao.buscarUno(100).nombreCompleto());
		

	}

	private static void literal() {
		
		System.out.println("\n=== GÉNERO ===");
		
		System.out.println(empleadoDao.buscarUno(100).literalGenero());
	}

	private static void salarioPorMeses() {

		
		System.out.println("\n=== SALARIO POR MESES ===");
		System.out.println("Salario Mensual ==> " + empleadoDao.buscarUno(100).salarioMensual(1));
		System.out.println("Salario Trimestral ==> " + empleadoDao.buscarUno(100).salarioMensual(3));
		
	}
	
	

}
