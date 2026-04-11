package modelo.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PERFILES")
public class Perfil {
	
	@Id
	@Column(name="ID_PERFIL")
	private int perfilId;
	
	private String nombre;
	
	@Column(name="TASA_STANDARD")
	private double tasaStandard;

	public Perfil(int perfilId, String nombre, double tasaStandard) {
		super();
		this.perfilId = perfilId;
		this.nombre = nombre;
		this.tasaStandard = tasaStandard;
	}

	public Perfil() {
		super();
	}

	public int getPerfilId() {
		return perfilId;
	}

	public void setPerfilId(int perfilId) {
		this.perfilId = perfilId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getTasaStandard() {
		return tasaStandard;
	}

	public void setTasaStandard(double tasaStandard) {
		this.tasaStandard = tasaStandard;
	}

	@Override
	public int hashCode() {
		return Objects.hash(perfilId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Perfil))
			return false;
		Perfil other = (Perfil) obj;
		return perfilId == other.perfilId;
	}

	@Override
	public String toString() {
		return "Perfil [perfilId=" + perfilId + ", nombre=" + nombre + ", tasaStandard=" + tasaStandard + "]";
	}
	
	
	
	

	
	
}
