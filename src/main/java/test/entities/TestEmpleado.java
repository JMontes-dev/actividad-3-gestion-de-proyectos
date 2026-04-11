package test.entities;

import modelo.dao.DepartamentoDao;
import modelo.dao.DepartamentoDaoImplMy8Jpa;
import modelo.entities.Empleado;

public class TestEmpleado {
	
	private static Empleado empleado;
	
	static {
		empleado = new Empleado();
	}

	public static void main(String[] args) {
		
		salarioPorMeses();
		literal();
		nombreCompleto();

	}
	
	private static void nombreCompleto() {
		empleado.setNombre("Jordi");
		empleado.setApellidos("Wild");
		
		System.out.println("\n=== NOMBRE COMPLETO ===");
		
		System.out.println(empleado.nombreCompleto());
		

	}

	private static void literal() {
		empleado.setGenero('r');
		
		System.out.println("\n=== GÉNERO ===");
		
		System.out.println(empleado.literalGenero());
	}

	private static void salarioPorMeses() {
	empleado.setSalario(90000.00);
		
		System.out.println("\n=== SALARIO POR MESES ===");
		System.out.println("Salario Mensual ==> " + empleado.salarioMensual(1));
		System.out.println("Salario Trimestral ==> " + empleado.salarioMensual(3));
		
	}
	
	

}
