package modelo.dao;

import java.util.List;
import modelo.entities.Empleado;
import modelo.entities.EmpleadosEnProyecto;


public interface EmpleadosEnProyectoDao {
	
	boolean create(EmpleadosEnProyecto ee);
    boolean update(EmpleadosEnProyecto ee);
    boolean delete(int id);
    EmpleadosEnProyecto findById(int id);
    List<EmpleadosEnProyecto> findAll();
    
    List<Empleado> empleadosByProyecto(String idProyecto);
    int asignarEmpleadosAProyecto(List<EmpleadosEnProyecto> empleados);
    int horasAsignadasAProyecto(String idProyecto);
    double costeActualDeEmpleadosEnProyecto(String idProyecto);
    
  

}
