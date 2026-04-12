package modelo.entities;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name="PROYECTO_CON_EMPLEADOS") 
public class EmpleadosEnProyecto implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="NUMERO_ORDEN")
    private int id;

    @ManyToOne
    @JoinColumn(name="ID_PROYECTO")
    private Proyecto proyecto;

    @ManyToOne
    @JoinColumn(name="ID_EMPL")
    private Empleado empleado;

    public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Proyecto getProyecto() {
		return proyecto;
	}


	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}


	public int getNumHoras() {
		return numHoras;
	}


	public void setNumHoras(int numHoras) {
		this.numHoras = numHoras;
	}


	public Empleado getEmpleado() {
		return empleado;
	}


	@Column(name="HORAS_ASIGNADAS")
    private int numHoras;

  
    public double costeHorasAsignadas() {
        if (this.empleado != null && this.empleado.getPerfil() != null) {
            return this.numHoras * this.empleado.getPerfil().getTasaStandard();
        }
        return 0;
    }


	public void setEmpleado(Empleado emp) {
		this.empleado = emp;
		
	}


	public void setHorasAsignadas(int i) {
		this.numHoras = i;
		
	}



	
  
}