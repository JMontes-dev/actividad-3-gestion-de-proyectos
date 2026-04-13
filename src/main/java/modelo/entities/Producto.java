package modelo.entities;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name="productos")
public class Producto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_producto")
	private int idProducto;

	private String descripcion;
	private double precio;
	
	@Column(name="FECHA_CREACION")
	private LocalDate fechaCreacion;
	
	@ManyToOne
	@JoinColumn(name="ID_FAMILIA")
	private Familia familia;
	
	

	public Producto(int idProducto, String descripcion, double precio, LocalDate fechaCreacion, Familia familia) {
		super();
		this.idProducto = idProducto;
		this.descripcion = descripcion;
		this.precio = precio;
		this.fechaCreacion = fechaCreacion;
		this.familia = familia;
	}


	public Producto() {
		super();
	}


	public int getIdProducto() {
		return idProducto;
	}


	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	public Familia getFamilia() {
		return familia;
	}


	public void setFamilia(Familia familia) {
		this.familia = familia;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idProducto);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Producto))
			return false;
		Producto other = (Producto) obj;
		return idProducto == other.idProducto;
	}


	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", descripcion=" + descripcion + ", precio=" + precio
				+ ", fechaCreacion=" + fechaCreacion + ", familia=" + familia + "]";
	}
	
	
    
}