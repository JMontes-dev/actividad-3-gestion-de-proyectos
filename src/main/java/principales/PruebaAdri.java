package principales;

import test.daos.TestEmpleadosEnProyectoDao;

public class PruebaAdri {

	public static void main(String[] args) {
		
		
		TestEmpleadosEnProyectoDao test = new TestEmpleadosEnProyectoDao();
		
		System.out.println(" PRUEBAS DE DAO ");
		
		 
		test.testFindAll();
		
	
		String idProyecto = "FOR2020001"; 
		
		test.testEmpleadosByProyecto(idProyecto);
		test.testHorasProyecto(idProyecto);
		test.testCosteTotalProyecto(idProyecto);
		
		System.out.println("PRUEBAS FINALIZADAS");
	}
}