package modelo.dao;

import java.util.List;

import modelo.entities.Cliente;
import modelo.entities.Departamento;

public class DepartamentoDaoImplMy8Jpa extends AbstractDaoImpl implements DepartamentoDao {

	@Override
	public int alta(Departamento entity) {
		try {
			tx.begin();
				em.persist(entity);
			tx.commit();
			
			return 1;
			
		} catch (Exception e) {
			System.out.println("Error en dar de alta Departamento: " + e.getMessage());
			return 0;
		}
	}


	@Override
	public int modificar(Departamento entity) {
		if(buscarUno(entity.getDepartamentoId()) != null) {
			
			try {
				tx.begin();
					em.merge(entity);
				tx.commit();
				return 1;
			}catch (Exception e) {
				System.out.println("Error en modificar Departamento: " + e.getMessage());
				return -1;
			}
		} else 
			return 0;
	}

	@Override
	public int eliminar(Integer atributoId) {
		Departamento entity = buscarUno(atributoId);
		if(buscarUno(atributoId) != null) {
			
			try {
				tx.begin();
					em.remove(entity);
				tx.commit();
				return 1;
			}catch (Exception e) {
				System.out.println("Error en eliminar Departamento: " + e.getMessage());
				return -1;
			}
		} else 
			return 0;
	}

	@Override
	public Departamento buscarUno(Integer atributoId) {
		return em.find(Departamento.class, atributoId);
	}

	@Override
	public List<Departamento> buscarTodos() {
		jpql = "from Departamento r";
		query = em.createQuery(jpql);
		
		return query.getResultList();
	}

}
