package modelo.dao;

import java.util.List;

import modelo.entities.Cliente;
import modelo.entities.Departamento;
import modelo.entities.Empleado;

public class EmpleadoDaoImplMy8Jpa extends AbstractDaoImpl implements EmpleadoDao {

	@Override
	public int alta(Empleado entity) {
		try {
			tx.begin();
				em.persist(entity);
			tx.commit();
			
			return 1;
			
		} catch (Exception e) {
			System.out.println("Error en dar de alta Empleado: " + e.getMessage());
			return 0;
		}
	}

	@Override
	public int modificar(Empleado entity) {
		if(buscarUno(entity.getEmpleadoId()) != null) {
			
			try {
				tx.begin();
					em.merge(entity);
				tx.commit();
				return 1;
			}catch (Exception e) {
				System.out.println("Error en modificar Empleado: " + e.getMessage());
				return -1;
			}
		} else 
			return 0;
	}

	@Override
	public int eliminar(Integer atributoId) {
		Empleado entity = buscarUno(atributoId);
		if(buscarUno(atributoId) != null) {
			
			try {
				tx.begin();
					em.remove(entity);
				tx.commit();
				return 1;
			}catch (Exception e) {
				System.out.println("Error en eliminar Empleado: " + e.getMessage());
				return -1;
			}
		} else 
			return 0;
	}

	@Override
	public Empleado buscarUno(Integer atributoId) {
		return em.find(Empleado.class, atributoId);
	}

	@Override
	public List<Empleado> buscarTodos() {
		jpql = "from Empleado r";
		query = em.createQuery(jpql);
		
		return query.getResultList();
	}



}
