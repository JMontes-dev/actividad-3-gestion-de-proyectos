package principales;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import modelo.entities.ProyectoConProducto;

public class PruebaAdri {

	public static void main(String[] args) {
		
		System.out.println(" PRUEBAS");

		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("proyectos_fp_2025");
		EntityManager em = emf.createEntityManager();

		try {
			
		
			
			List<ProyectoConProducto> lista = em.createQuery("SELECT p FROM ProyectoConProducto p", ProyectoConProducto.class).getResultList();

			if (lista.isEmpty()) {
				System.out.println("tabla vacia en MySQL pero conexion correcta");
			} else {
				System.out.println("Se han encontrado " + lista.size() + " registros:");
				for (ProyectoConProducto pcp : lista) {
					System.out.println("");
					System.out.println("ID Orden: " + pcp.getNumeroOrden());
					System.out.println("Proyecto: " + (pcp.getProyecto() != null ? pcp.getProyecto().getDescripcion() : "Sin proyecto"));
					System.out.println("Producto: " + (pcp.getProducto() != null ? pcp.getProducto().getDescripcion() : "Sin producto"));
					System.out.println("CANTIDAD: " + pcp.getCantidad()); 
				}
			}

		} catch (Exception e) {
			System.err.println("¡ERROR EN EL TEST!");
			e.printStackTrace();
		} finally {
			
			em.close();
			emf.close();
		}
		
		System.out.println("FIN PRUEBAs");
	}
}