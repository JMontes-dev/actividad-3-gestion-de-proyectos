package test.entities;

import modelo.entities.Empleado;
import modelo.entities.EmpleadosEnProyecto;
import modelo.entities.Perfil;

public class TestEmpleadosEnProyecto {
	
	public static void main(String[] args) {
        
        Perfil senior = new Perfil();
        senior.setTasaStandard(50.0); 

        Empleado emp = new Empleado();
        emp.setPerfil(senior);

        EmpleadosEnProyecto asignacion = new EmpleadosEnProyecto();
        asignacion.setEmpleado(emp);
        asignacion.setHorasAsignadas(10); 

        
        double resultado = asignacion.costeHorasAsignadas();

        
        System.out.println("--- TEST : EmpleadosEnProyecto ---");
        
        System.out.println("Resultado: " + resultado + "€");

        
	}
}
