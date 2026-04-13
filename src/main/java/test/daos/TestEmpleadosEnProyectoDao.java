package test.daos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8Jpa;
import modelo.dao.EmpleadosEnProyectoDao;
import modelo.dao.EmpleadosEnProyectoDaoImplMy8Jpa;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8Jpa;
import modelo.entities.Empleado;
import modelo.entities.EmpleadosEnProyecto;
import modelo.entities.Proyecto;

public class TestEmpleadosEnProyectoDao {
    
	private static EmpleadosEnProyectoDao eepDao;
	private static ProyectoDao proDao;
	private static EmpleadoDao empDao;

	static {
		
		eepDao = new EmpleadosEnProyectoDaoImplMy8Jpa();
		proDao = new ProyectoDaoImplMy8Jpa();
		empDao = new EmpleadoDaoImplMy8Jpa();

	}
    
    public static void main(String[] args) {

    	
    	//alta();
    	//modificar();
    	//eliminar();
    	uno();
    	todos();
    	EmpleadosPorProyecto();
    	//asignarEmpleados();
    	horasProyecto();
    	CosteTotalProyecto();

    	
    }
    


	private static void alta() {
		System.out.println("\n=== ALTA ===");
		
		EmpleadosEnProyecto eep = new EmpleadosEnProyecto(0, proDao.buscarUno("FOR2021001"), 
				empDao.buscarUno(117), 50, LocalDate.of(2021, 10, 20));
		
		System.out.println(eepDao.alta(eep));
		System.out.println(eepDao.buscarUno(5));
		
	}
    
	private static void modificar() {
    	System.out.println("\n=== MODIFICAR ===");
		
		 EmpleadosEnProyecto entity = eepDao.buscarUno(5);
		 entity.setNumHoras(55);
		 
		 System.out.println(eepDao.buscarUno(5));
		 System.out.println(eepDao.modificar(entity));
		
	}


    private static void eliminar() {
		System.out.println("\n=== ELIMINAR ===");
		
		switch(eepDao.eliminar(16)) {
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
		
		System.out.println(eepDao.buscarUno(4));
	}

	public static void todos() {
		System.out.println("\n=== TODOS ===");
		
		for (EmpleadosEnProyecto ele: eepDao.buscarTodos())
			System.out.println(ele);
	}
		

    
    public static void EmpleadosPorProyecto() {
		System.out.println("\n=== EMPLEADOS POR PROYECTO ===");
		
		List<Empleado> empleados = eepDao.empleadosByProyecto("FOR2020001");
		
		for (Empleado e : empleados) {
			System.out.println("Empleado: " + e.getNombre() + " " + e.getApellidos());
		}

    } 
    
    public static void asignarEmpleados() {
		System.out.println("\n=== ASIGNAR EMPLEADOS A PROYECTO ===");
		
	    List<Empleado> empleados = empDao.buscarTodos();

	    Proyecto proyecto = proDao.buscarUno("FOR2021003"); 

	    List<EmpleadosEnProyecto> lista = new ArrayList<>();

	    for (Empleado e : empleados) {
	        if (e.getEmpleadoId() == 100 || e.getEmpleadoId() == 119 || e.getEmpleadoId() == 120) {

	            EmpleadosEnProyecto eep = new EmpleadosEnProyecto();
	            eep.setEmpleado(e);
	            eep.setProyecto(proyecto);
	            eep.setNumHoras(60); 
	            eep.setFechaIncorporacion(LocalDate.of(2021, 10, 30));

	            lista.add(eep);
	        }
	    }

	    eepDao.asignarEmpleadosAProyecto(lista);

	    System.out.println("Asignación realizada.");
	}
    
    
    
    public static void horasProyecto() {   	
    	System.out.println("\n=== HORAS ASIGNADAS A PROYECTO ===");
    	
		int totalHoras = eepDao.horasAsignadasAProyecto("FOR2020001");
		System.out.println("Total horas del proyecto: " + totalHoras + "h");
	}
    
    
    public static void CosteTotalProyecto() {
    	System.out.println("\n=== COSTE TOTAL EMPLEADOS EN PROYECTO ===");
    	

		double coste = eepDao.costeActualDeEmpleadosEnProyecto("FOR2020001");
		System.out.println("Coste total acumulado: " + coste + "€");
	}
}
