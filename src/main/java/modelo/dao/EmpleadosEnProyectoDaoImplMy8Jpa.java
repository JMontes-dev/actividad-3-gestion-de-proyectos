package modelo.dao;

import java.util.List;
import jakarta.persistence.TypedQuery;
import modelo.entities.Empleado;
import modelo.entities.EmpleadosEnProyecto;
import modelo.entities.Proyecto;

public class EmpleadosEnProyectoDaoImplMy8Jpa extends AbstractDaoImpl implements EmpleadosEnProyectoDao {

	@Override
	public int alta(EmpleadosEnProyecto entity) {
		try {
			tx.begin();
				em.persist(entity);
			tx.commit();
			
			return 1;
			
		} catch (Exception e) {
			System.out.println("Error en dar de alta Empleado en Proyecto: " + e.getMessage());
			return 0;
		}
	}

	@Override
	public int modificar(EmpleadosEnProyecto entity) {
		if(buscarUno(entity.getId()) != null) {
			
			try {
				tx.begin();
					em.merge(entity);
				tx.commit();
				return 1;
			}catch (Exception e) {
				System.out.println("Error en modificar Empleado en Proyecto: " + e.getMessage());
				return -1;
			}
		} else 
			return 0;
	}
	@Override
	public int eliminar(Integer atributoId) {
		EmpleadosEnProyecto entity = buscarUno(atributoId);
		if(buscarUno(atributoId) != null) {
			
			try {
				tx.begin();
					em.remove(entity);
				tx.commit();
				return 1;
			}catch (Exception e) {
				System.out.println("Error en eliminar Empleado en Proyecto: " + e.getMessage());
				return -1;
			}
		} else 
			return 0;
	}

	@Override
	public EmpleadosEnProyecto buscarUno(Integer atributoId) {
		return em.find(EmpleadosEnProyecto.class, atributoId);
	}

	@Override
	public List<EmpleadosEnProyecto> buscarTodos() {
		jpql = "from EmpleadosEnProyecto ep";
		query = em.createQuery(jpql);
		
		return query.getResultList();
	}
	
	
    @Override
    public List<Empleado> empleadosByProyecto(String idProyecto) {
        String jpql = "SELECT ee.empleado FROM EmpleadosEnProyecto ee WHERE ee.proyecto.proyectoId = :id";
        return em.createQuery(jpql, Empleado.class)
                 .setParameter("id", idProyecto)
                 .getResultList();
    }

    @Override
    public int asignarEmpleadosAProyecto(List<EmpleadosEnProyecto> lista) {
        int total = 0;
        try {
            tx.begin();
            for (EmpleadosEnProyecto ee : lista) {
                em.persist(ee);
                total++;
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
        return total;
    }

    @Override
    public int horasAsignadasAProyecto(String idProyecto) {
        String jpql = "SELECT SUM(ee.numHoras) FROM EmpleadosEnProyecto ee WHERE ee.proyecto.proyectoId = :id";
        Long suma = em.createQuery(jpql, Long.class)
                      .setParameter("id", idProyecto)
                      .getSingleResult();
        return (suma != null) ? suma.intValue() : 0;
    }

    @Override
    public double costeActualDeEmpleadosEnProyecto(String idProyecto) {
        String jpql = "SELECT ee FROM EmpleadosEnProyecto ee WHERE ee.proyecto.proyectoId = :id";
        List<EmpleadosEnProyecto> lista = em.createQuery(jpql, EmpleadosEnProyecto.class)
                                            .setParameter("id", idProyecto)
                                            .getResultList();
        double total = 0;
        for (EmpleadosEnProyecto ee : lista) {
            total += ee.costeHorasAsignadas();
        }
        return total;
    }

    
	@Override
	public List<EmpleadosEnProyecto> detalleEmpleadosProyecto(String idProyecto) {
		
		String jpql = "SELECT eep FROM EmpleadosEnProyecto eep WHERE eep.proyecto.proyectoId = :idProyecto";
		
		return em.createQuery(jpql, EmpleadosEnProyecto.class)
				.setParameter("idProyecto", idProyecto)
				.getResultList();
	}

}