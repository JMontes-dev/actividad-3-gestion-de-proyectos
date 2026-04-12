package modelo.dao;

import java.util.List;

import modelo.entities.Cliente;
import modelo.entities.Departamento;
import modelo.entities.Empleado;
import modelo.entities.Proyecto;

public class ProyectoDaoImplMy8Jpa extends AbstractDaoImpl implements ProyectoDao {

	@Override
	public int alta(Proyecto entity) {
		try {
			tx.begin();
				em.persist(entity);
			tx.commit();
			
			return 1;
			
		} catch (Exception e) {
			System.out.println("Error en dar de alta Proyecto: " + e.getMessage());
			return 0;
		}
	}


	@Override
	public int modificar(Proyecto entity) {
		if(buscarUno(entity.getProyectoId()) != null) {
			
			try {
				tx.begin();
					em.merge(entity);
				tx.commit();
				return 1;
			}catch (Exception e) {
				System.out.println("Error en modificar Proyecto: " + e.getMessage());
				return -1;
			}
		} else 
			return 0;
	}

	@Override
	public int eliminar(String atributoId) {
		Proyecto entity = buscarUno(atributoId);
		if(buscarUno(atributoId) != null) {
			
			try {
				tx.begin();
					em.remove(entity);
				tx.commit();
				return 1;
			}catch (Exception e) {
				System.out.println("Error en eliminar Proyecto: " + e.getMessage());
				return -1;
			}
		} else 
			return 0;
	}

	@Override
	public Proyecto buscarUno(String atributoId) {
		return em.find(Proyecto.class, atributoId);
	}

	@Override
	public List<Proyecto> buscarTodos() {
		jpql = "from Proyecto p";
		query = em.createQuery(jpql);
		
		return query.getResultList();
	}


	@Override
	public List<Proyecto> proyectosByEstado(String estado) {
		jpql = "from Proyecto p where p.estado = :est";
		
		query = em.createQuery(jpql);
		query.setParameter("est" , estado);
		return query.getResultList();
	}


	@Override
	public List<Proyecto> proyectosByCliente(String cif) {
		jpql = "from Proyecto p where p.cliente.cif = :cif";
		
		query = em.createQuery(jpql);
		query.setParameter("cif" , cif);
		return query.getResultList();
	}

	@Override
	public List<Proyecto> proyectosByJefeProyectoAndEstado(int jefeProyecto, String estado) {
		jpql = "from Proyecto p where p.empleado.empleadoId = :jfp and p.estado = :est";
		
		query = em.createQuery(jpql);
		query.setParameter("jfp" , jefeProyecto);
		query.setParameter("est" , estado);
		return query.getResultList();
	}

	@Override
	public double importesVentaProyectosTerminados() {
		jpql = "SELECT SUM(p.ventaPrevisto) from Proyecto p where p.estado = 'TERMINADO'";
		query = em.createQuery(jpql);
		
		return (double) query.getSingleResult();
	}


	@Override
	public double margenBrutoProyectosTerminados() {
		jpql = "SELECT SUM(p.ventaPrevisto) - SUM(p.costeReal) from Proyecto p where p.estado = 'TERMINADO'";
		query = em.createQuery(jpql);
		
		return (double) query.getSingleResult();
	}

	@Override
	public double porcentageMargenBrutoProyectosTerminados() {
		jpql = "SELECT (SUM(p.ventaPrevisto) - SUM(p.costeReal)) / SUM(p.ventaPrevisto) * 100"
				+ " from Proyecto p where p.estado = 'TERMINADO'";
		query = em.createQuery(jpql);
		
		return (double) query.getSingleResult();
	}


	@Override
	public int diasATerminoProyectoActivo(String codigoProyecto) {
	    jpql = "SELECT FUNCTION('DATEDIFF', p.fechaFinPrevisto, CURRENT_DATE) " +
	           "from Proyecto p where p.proyectoId = :codigo";

	    query = em.createQuery(jpql);
	    query.setParameter("codigo", codigoProyecto);

	    return (Integer) query.getSingleResult();
	
	}

}
