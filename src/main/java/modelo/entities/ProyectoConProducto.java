package modelo.entities;


import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name="proyecto_con_productos") 
public class ProyectoConProducto { 

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="num_orden")
	private int numeroOrden;

	@ManyToOne
	@JoinColumn(name="id_proyecto")
	private Proyecto proyecto;

	@ManyToOne
	@JoinColumn(name="id_producto")
	private Producto producto;
	
	@Column(name="precio_asignado")
	private int precioAsignado;
	
	private int cantidad;
	
	
	
	public double importeLinea() {
        return this.cantidad * this.precioAsignado;
    }
	

	public ProyectoConProducto(int numeroOrden, Proyecto proyecto, Producto producto, int precioAsignado,
			int cantidad) {
		super();
		this.numeroOrden = numeroOrden;
		this.proyecto = proyecto;
		this.producto = producto;
		this.precioAsignado = precioAsignado;
		this.cantidad = cantidad;
	}

	public ProyectoConProducto() {
		super();
	}

	
	
	public int getNumeroOrden() {
		return numeroOrden;
	}


	public void setNumeroOrden(int numeroOrden) {
		this.numeroOrden = numeroOrden;
	}


	public Proyecto getProyecto() {
		return proyecto;
	}


	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public int getPrecioAsignado() {
		return precioAsignado;
	}


	public void setPrecioAsignado(int precioAsignado) {
		this.precioAsignado = precioAsignado;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	@Override
	public int hashCode() {
		return Objects.hash(numeroOrden);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ProyectoConProducto))
			return false;
		ProyectoConProducto other = (ProyectoConProducto) obj;
		return numeroOrden == other.numeroOrden;
	}

	@Override
	public String toString() {
		return "ProyectoConProducto [numeroOrden=" + numeroOrden + ", proyecto=" + proyecto + ", producto=" + producto
				+ ", precioAsignado=" + precioAsignado + ", cantidad=" + cantidad + "]";
	} 
	

	
	
}