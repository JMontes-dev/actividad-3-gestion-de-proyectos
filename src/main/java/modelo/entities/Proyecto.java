package modelo.entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="PROYECTOS")
public class Proyecto {
	
	@Id
	@Column(name="ID_PROYECTO")
    private String proyectoId;
	
	private String descripcion;
	
	@Column(name="FECHA_INICIO")
	private LocalDate fechaInicio;
	
	@Column(name="FECHA_FIN_PREVISTO")
	private LocalDate fechaFinPrevisto;
	
	@Column(name="FECHA_FIN_REAL")
	private LocalDate fechaFinReal;
	
	@Column(name="VENTA_PREVISTO")
	private double ventaPrevisto;
	
	@Column(name="COSTES_PREVISTO")
	private double costePrevisto;
	
	@Column(name="COSTE_REAL")
	private double costeReal;
	
	private String estado;
	
	@ManyToOne
	@JoinColumn(name="JEFE_PROYECTO")
	private Empleado empleado;
	
	@ManyToOne
	@JoinColumn(name="CIF")
	private Cliente cliente;

	
	public double margenPrevisto() {
		return (ventaPrevisto - costePrevisto);		
	}
	
	public double procentageMargenPrevisto() {
	    return (margenPrevisto() / ventaPrevisto) * 100;
	}
	
	public double margenReal() {	
		return (ventaPrevisto - costeReal);
	}  
	
	public double procentageMargenReal() {
	    return (margenReal() / ventaPrevisto) * 100;
	}
	
	public double diferenciaGastos() {
	return (costeReal - costePrevisto);
		
	}
	
	public int diferenciaDiasFinPrevistoReal() {
		return (int) ChronoUnit.DAYS.between(fechaFinPrevisto, fechaFinReal);
		
	}

	public Proyecto(String proyectoId, String descripcion, LocalDate fechaInicio, LocalDate fechaFinPrevisto,
			LocalDate fechaFinReal, double ventaPrevisto, double costePrevisto, double costeReal, String estado,
			Empleado empleado, Cliente cliente) {
		super();
		this.proyectoId = proyectoId;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFinPrevisto = fechaFinPrevisto;
		this.fechaFinReal = fechaFinReal;
		this.ventaPrevisto = ventaPrevisto;
		this.costePrevisto = costePrevisto;
		this.costeReal = costeReal;
		this.estado = estado;
		this.empleado = empleado;
		this.cliente = cliente;
	}

	public Proyecto() {
		super();
	}

	public String getProyectoId() {
		return proyectoId;
	}

	public void setProyectoId(String proyectoId) {
		this.proyectoId = proyectoId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFinPrevisto() {
		return fechaFinPrevisto;
	}

	public void setFechaFinPrevisto(LocalDate fechaFinPrevisto) {
		this.fechaFinPrevisto = fechaFinPrevisto;
	}

	public LocalDate getFechaFinReal() {
		return fechaFinReal;
	}

	public void setFechaFinReal(LocalDate fechaFinReal) {
		this.fechaFinReal = fechaFinReal;
	}

	public double getVentaPrevisto() {
		return ventaPrevisto;
	}

	public void setVentaPrevisto(double ventaPrevisto) {
		this.ventaPrevisto = ventaPrevisto;
	}

	public double getCostePrevisto() {
		return costePrevisto;
	}

	public void setCostePrevisto(double costePrevisto) {
		this.costePrevisto = costePrevisto;
	}

	public double getCosteReal() {
		return costeReal;
	}

	public void setCosteReal(double costeReal) {
		this.costeReal = costeReal;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(proyectoId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Proyecto))
			return false;
		Proyecto other = (Proyecto) obj;
		return Objects.equals(proyectoId, other.proyectoId);
	}

	@Override
	public String toString() {
		return "Proyecto [proyectoId=" + proyectoId + ", descripcion=" + descripcion + ", fechaInicio=" + fechaInicio
				+ ", fechaFinPrevisto=" + fechaFinPrevisto + ", fechaFinReal=" + fechaFinReal + ", ventaPrevisto="
				+ ventaPrevisto + ", costePrevisto=" + costePrevisto + ", costeReal=" + costeReal + ", estado=" + estado
				+ ", empleado=" + empleado + ", cliente=" + cliente + "]";
	}
	
	
	


	

}
