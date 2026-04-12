package test.daos;

import java.time.LocalDate;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jpa;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8Jpa;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8Jpa;

import modelo.entities.Empleado;
import modelo.entities.Proyecto;


public class TestProyectoDao {
	
	private static EmpleadoDao empDao;
	private static ProyectoDao proDao;
	private static ClienteDao cliDao;


	static {
	    empDao = new EmpleadoDaoImplMy8Jpa();
	    proDao = new ProyectoDaoImplMy8Jpa();
	    cliDao = new ClienteDaoImplMy8Jpa();

	}

	public static void main(String[] args) {
		
		alta();
		modificar();
		eliminar();
		uno();
		todos();
		porEstado();
		porCif();
		porJefeEstado();
		importeProyectosTerminados();
		margenBrutoTerminados();
		porcentageMargenTerminados();
		diasATerminProyecto();
		
		
	}
	

	private static void alta() {
		System.out.println("\n=== ALTA ===");
		
		Proyecto pro = new Proyecto("FOR2021003", "Ciberseguridad básica para empleados", 
				LocalDate.of(2021, 10, 30), LocalDate.of(2021, 11, 30), LocalDate.of(2021, 11, 30), 
				60000, 30000, 33000, "ACTIVO", empDao.buscarUno(114), cliDao.buscarUno("B33333333"));
		
		Proyecto pro2 = new Proyecto("FOR2022001", "Gestión del Tiempo y Productividad", 
				LocalDate.of(2022, 1, 4), LocalDate.of(2022, 2, 28), LocalDate.of(2022, 2, 28), 
				25000, 10000, 10000, "ACTIVO", empDao.buscarUno(114), cliDao.buscarUno("A22222222"));
		
		Proyecto pro3 = new Proyecto("FOR2026001", "Administración de Bases de Datos", 
				LocalDate.of(2026, 4, 12), LocalDate.of(2026, 4, 30), null, 
				80000, 38000, 0.0, "ACTIVO", empDao.buscarUno(114), cliDao.buscarUno("A11111112"));
		
	   	System.out.println(proDao.alta(pro));
	   	System.out.println(proDao.alta(pro2));
	    System.out.println(proDao.alta(pro3));
	    
	    System.out.println(proDao.buscarUno("FOR2021003"));
	    System.out.println(proDao.buscarUno("FOR2022001"));
	    System.out.println(proDao.buscarUno("FOR2026001"));
		
	}
	
	private static void modificar() {
		System.out.println("\n=== MODIFICAR ===");
		
		 Proyecto entity = proDao.buscarUno("FOR2021003");
		 entity.setEstado("TERMINADO");
		 
		 System.out.println(proDao.buscarUno("FOR2022001"));
		 System.out.println(proDao.modificar(entity));
		 
		 
		 Proyecto entity2 = proDao.buscarUno("FOR2021003");
		 entity2.setCosteReal(33500);
		 
		 System.out.println(proDao.buscarUno("FOR2021003"));
		 System.out.println(proDao.modificar(entity2));
		 
		 
	}
	
	private static void eliminar() {
		System.out.println("\n=== ELIMINAR ===");
	
		switch(proDao.eliminar("FOR2022001")) {
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
		
		System.out.println(proDao.buscarUno("FOR2020001"));
	}

	
	private static void todos() {
		System.out.println("\n=== TODOS ===");
		
		for (Proyecto ele: proDao.buscarTodos())
			System.out.println(ele);
	}
	
	
	private static void porEstado() {
		System.out.println("\n=== PROYECTOS POR ESTADO ===");
		
		for (Proyecto ele: proDao.proyectosByEstado("TERMINADO"))
			System.out.println(ele);
	}
	
	
	private static void porCif() {
		System.out.println("\n=== PROYECTOS POR CLIENTE ===");
		
		for (Proyecto ele: proDao.proyectosByCliente("B33333333"))
			System.out.println(ele);
	}
	
	private static void porJefeEstado() {
		System.out.println("\n=== PROYECTOS POR JEFE Y ESTADO ===");
		
		for (Proyecto ele: proDao.proyectosByJefeProyectoAndEstado(114, "ACTIVO"))
			System.out.println(ele);
	}
	

	private static void importeProyectosTerminados() {
		System.out.println("\n=== IMPORTE TOTAL DE PROYECTOS TERMINADOS ===");
		
		System.out.println(proDao.importesVentaProyectosTerminados());
	}
	
	private static void margenBrutoTerminados() {
		System.out.println("\n=== MARGEN BRUTO DE PROYECTOS TERMINADOS ===");
		
		System.out.println(proDao.margenBrutoProyectosTerminados());
	}
	
	private static void porcentageMargenTerminados() {
		System.out.println("\n=== PORCENTAGE MARGEN BRUTO DE PROYECTOS TERMINADOS ===");
		
		System.out.println(proDao.porcentageMargenBrutoProyectosTerminados() + "%");
	}

	private static void diasATerminProyecto() {
		System.out.println("\n=== DIAS PARA TERMINAR PROYECTO ACTIVO ===");
		
		System.out.println(proDao.diasATerminoProyectoActivo("FOR2026001"));
	}


}
