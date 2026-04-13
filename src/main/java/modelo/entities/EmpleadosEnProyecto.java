package modelo.entities;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name="PROYECTO_CON_EMPLEADOS") 
public class EmpleadosEnProyecto {

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
    
	@Column(name="HORAS_ASIGNADAS")
    private int numHoras;
	
	@Column(name="FECHA_INCORPORACION")
    private LocalDate fechaIncorporacion;
	
  
    public double costeHorasAsignadas() {
        if (this.empleado != null && this.empleado.getPerfil() != null) {
            return this.numHoras * this.empleado.getPerfil().getTasaStandard();
        }
        return 0;
    }


	public EmpleadosEnProyecto(int id, Proyecto proyecto, Empleado empleado, int numHoras,
			LocalDate fechaIncorporacion) {
		super();
		this.id = id;
		this.proyecto = proyecto;
		this.empleado = empleado;
		this.numHoras = numHoras;
		this.fechaIncorporacion = fechaIncorporacion;
	}


	public EmpleadosEnProyecto() {
		super();
	}


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


	public Empleado getEmpleado() {
		return empleado;
	}


	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}


	public int getNumHoras() {
		return numHoras;
	}


	public void setNumHoras(int numHoras) {
		this.numHoras = numHoras;
	}


	public LocalDate getFechaIncorporacion() {
		return fechaIncorporacion;
	}


	public void setFechaIncorporacion(LocalDate fechaIncorporacion) {
		this.fechaIncorporacion = fechaIncorporacion;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof EmpleadosEnProyecto))
			return false;
		EmpleadosEnProyecto other = (EmpleadosEnProyecto) obj;
		return id == other.id;
	}


	@Override
	public String toString() {
		return "EmpleadosEnProyecto [id=" + id + ", proyecto=" + proyecto + ", empleado=" + empleado + ", numHoras="
				+ numHoras + ", fechaIncorporacion=" + fechaIncorporacion + "]";
	}

	
  
}