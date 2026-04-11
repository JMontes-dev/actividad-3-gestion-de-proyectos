package modelo.dao;

import java.util.List;

import modelo.entities.Cliente;
import modelo.entities.Departamento;
import modelo.entities.Empleado;
import modelo.entities.Perfil;

public class PerfilDaoImplMy8Jpa extends AbstractDaoImpl implements PerfilDao {

	public PerfilDaoImplMy8Jpa() {

	}
	
	@Override
	public int alta(Perfil entity) {
		try {
			tx.begin();
				em.persist(entity);
			tx.commit();
			
			return 1;
			
		} catch (Exception e) {
			System.out.println("Error en dar de alta Perfil: " + e.getMessage());
			return 0;
		}
	}


	@Override
	public int modificar(Perfil entity) {
		if(buscarUno(entity.getPerfilId()) != null) {
			
			try {
				tx.begin();
					em.merge(entity);
				tx.commit();
				return 1;
			}catch (Exception e) {
				System.out.println("Error en modificar Perfil: " + e.getMessage());
				return -1;
			}
		} else 
			return 0;
	}

	@Override
	public int eliminar(Integer atributoId) {
		Perfil entity = buscarUno(atributoId);
		if(buscarUno(atributoId) != null) {
			
			try {
				tx.begin();
					em.remove(entity);
				tx.commit();
				return 1;
			}catch (Exception e) {
				System.out.println("Error en eliminar Perfil: " + e.getMessage());
				return -1;
			}
		} else 
			return 0;
	}

	@Override
	public Perfil buscarUno(Integer atributoId) {
		return em.find(Perfil.class, atributoId);
	}

	@Override
	public List<Perfil> buscarTodos() {
		jpql = "from Perfil r";
		query = em.createQuery(jpql);
		
		return query.getResultList();
	}



}
