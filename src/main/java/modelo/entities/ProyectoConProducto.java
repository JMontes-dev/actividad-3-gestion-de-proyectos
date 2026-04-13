package modelo.entities;


import jakarta.persistence.*;

@Entity
@Table(name="proyecto_con_productos") 
public class ProyectoConProducto { 

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="num_orden")
	private int numeroOrden;

	private int cantidad; 

	@ManyToOne
	@JoinColumn(name="id_proyecto")
	private Proyecto proyecto;

	@ManyToOne
	@JoinColumn(name="id_producto")
	private Producto producto;

	public ProyectoConProducto() {
		super();
	}

	public int getNumeroOrden() {
		return numeroOrden;
	}

	public void setNumeroOrden(int numeroOrden) {
		this.numeroOrden = numeroOrden;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
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

	
}