package modelo.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="DEPARTAMENTOS")
public class Departamento {
	
	@Id
	@Column(name="ID_DEPAR")
	private int departamentoId;
	
	private String nombre;
	private String direccion;
	
	
	
	public Departamento(int departamentoId, String nombre, String direccion) {
		super();
		this.departamentoId = departamentoId;
		this.nombre = nombre;
		this.direccion = direccion;
	}
	
	
	public Departamento() {
		super();
	}
	
	public int getDepartamentoId() {
		return departamentoId;
	}
	
	public void setDepartamentoId(int departamentoId) {
		this.departamentoId = departamentoId;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(departamentoId);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Departamento))
			return false;
		Departamento other = (Departamento) obj;
		return departamentoId == other.departamentoId;
	}
	
	@Override
	public String toString() {
		return "Departamento [departamentoId=" + departamentoId + ", nombre=" + nombre + ", direccion=" + direccion
				+ "]";
	}
	
	
	
}
