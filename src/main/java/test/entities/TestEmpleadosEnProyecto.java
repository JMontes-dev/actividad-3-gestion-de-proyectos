package test.entities;

import modelo.dao.EmpleadosEnProyectoDao;
import modelo.dao.EmpleadosEnProyectoDaoImplMy8Jpa;

public class TestEmpleadosEnProyecto {
	
	private static EmpleadosEnProyectoDao eepDao;
	
	static {
		eepDao = new EmpleadosEnProyectoDaoImplMy8Jpa();
	}

	
	public static void main(String[] args) {
        

		costeHorasAsignadas();
        
	}


	private static void costeHorasAsignadas() {     
        System.out.println("\n=== COSTE HORAS ASIGNADAS ===");
        
        System.out.println(eepDao.buscarUno(1).costeHorasAsignadas());
		
	}
}
