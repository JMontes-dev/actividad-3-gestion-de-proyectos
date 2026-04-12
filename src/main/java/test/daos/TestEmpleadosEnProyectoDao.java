package test.daos;

import java.util.List;
import modelo.dao.EmpleadosEnProyectoDao;
import modelo.dao.EmpleadosEnProyectoDaoImplMy8Jpa;
import modelo.entities.Empleado;
import modelo.entities.EmpleadosEnProyecto;

public class TestEmpleadosEnProyectoDao {
    
    private EmpleadosEnProyectoDao eepDao = new EmpleadosEnProyectoDaoImplMy8Jpa();

    public void testFindAll() {
		System.out.println("PROBANDO: findAll() ");
		List<EmpleadosEnProyecto> lista = eepDao.findAll();
		if (lista.isEmpty()) {
			System.out.println("No hay datos en la tabla.");
		} else {
			for (EmpleadosEnProyecto ee : lista) {
				System.out.println("ID: " + ee.getId() ); 
				System.out.println(" | Proyecto: " + ee.getProyecto().getDescripcion()); 
				System.out.println(" | Empleado: " + ee.getEmpleado().getNombre());
		}
	 }
		
    }
    
    public void testEmpleadosByProyecto(String idProyecto) {
		System.out.println("PROBANDO: empleadosByProyecto(" + idProyecto + ")");
		List<Empleado> empleados = eepDao.empleadosByProyecto(idProyecto);
		for (Empleado e : empleados) {
			System.out.println("Empleado asignado: " + e.getNombre() + " " + e.getApellidos());
		}

    } 
    
    public void testHorasProyecto(String idProyecto) {
		 System.out.println("PROBANDO: horasAsignadasAProyecto(" + idProyecto + ")");
		int totalHoras = eepDao.horasAsignadasAProyecto(idProyecto);
		System.out.println("Total horas del proyecto: " + totalHoras + "h");
	}
    
    public void testCosteTotalProyecto(String idProyecto) {
		System.out.println("PROBANDO: costeActualDeEmpleadosEnProyecto(" + idProyecto + ")");
		double coste = eepDao.costeActualDeEmpleadosEnProyecto(idProyecto);
		System.out.println("Coste total acumulado: " + coste + "€");
	}
}