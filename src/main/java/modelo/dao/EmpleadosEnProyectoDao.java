package modelo.dao;

import java.util.List;
import modelo.entities.Empleado;
import modelo.entities.EmpleadosEnProyecto;
import modelo.entities.Proyecto;


public interface EmpleadosEnProyectoDao extends GenericoDao<EmpleadosEnProyecto, Integer> {
	
  
    List<Empleado> empleadosByProyecto(String idProyecto);
    
    int asignarEmpleadosAProyecto(List<EmpleadosEnProyecto> empleados);
    
    int horasAsignadasAProyecto(String idProyecto);
    
    double costeActualDeEmpleadosEnProyecto(String idProyecto);

    //Método extra usado en imprimirGastos
    List<EmpleadosEnProyecto> detalleEmpleadosProyecto(String idProyecto);
}
