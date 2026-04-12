package test.entities;

import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8Jpa;

public class TestProyecto {
	
	private static ProyectoDao proDao;
	
	static {
		proDao = new ProyectoDaoImplMy8Jpa();
	}

	public static void main(String[] args) {
		
		margenPrevisto();
		porcentageMargen();
		margenReal();
		porcentageMargenReal();
		diferencia();
		diferenciaDias();
		

	}
	

	private static void margenPrevisto() {

		System.out.println("\n=== MARGEN PREVISTO ===");
		
		System.out.println(proDao.buscarUno("FOR2021003").margenPrevisto());
		

	}

	private static void porcentageMargen() {
		
		System.out.println("\n=== PORCENTAGE MARGEN PREVISTO ===");
		
		System.out.println(proDao.buscarUno("FOR2021003").procentageMargenPrevisto() + "%");
	}

	
	private static void margenReal() {

		
		System.out.println("\n=== MARGEN REAL ===");
		
		System.out.println(proDao.buscarUno("FOR2021003").margenReal());
		
	}
	
	private static void porcentageMargenReal() {
		
		System.out.println("\n=== PORCENTAGE MARGEN REAL ===");
		
		System.out.println(proDao.buscarUno("FOR2021003").procentageMargenReal() + "%");
	}
	
	private static void diferencia() {
		System.out.println("\n=== DIFERENCIA COSTES ===");
		
		System.out.println(proDao.buscarUno("FOR2021003").diferenciaGastos());
	}
	
	private static void diferenciaDias() {
		System.out.println("\n=== DIFERENCIA DÍAS FIN PREVISTO Y FIN REAL ===");
		
		System.out.println(proDao.buscarUno("FOR2021003").diferenciaDiasFinPrevistoReal());
		
	}

}
