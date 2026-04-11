package modelo.dao;


import java.util.List;
import modelo.entities.Cliente;


public class ClienteDaoImplMy8Jpa extends AbstractDaoImpl implements ClienteDao {
	
	public ClienteDaoImplMy8Jpa() {

	}

	@Override
	public int alta(Cliente cliente) {
		try {
			tx.begin();
				em.persist(cliente);
			tx.commit();
			
			return 1;
			
		} catch (Exception e) {
			System.out.println("Error en dar de alta Cliente: " + e.getMessage());
			return 0;
		}
	}

	@Override
	public int modificar(Cliente cliente) {
		if(buscarUno(cliente.getCif()) != null) {
			
			try {
				tx.begin();
					em.merge(cliente);
				tx.commit();
				return 1;
			}catch (Exception e) {
				System.out.println("Error en modificar Cliente: " + e.getMessage());
				return -1;
			}
		} else 
			return 0;
	}

	@Override
	public int eliminar(String atributoId) {
		Cliente cliente = buscarUno(atributoId);
		if(buscarUno(atributoId) != null) {
			
			try {
				tx.begin();
					em.remove(cliente);
				tx.commit();
				return 1;
			}catch (Exception e) {
				System.out.println("Error en eliminar Cliente: " + e.getMessage());
				return -1;
			}
		} else 
			return 0;
	}

	@Override
	public Cliente buscarUno(String atributoId) {
		return em.find(Cliente.class, atributoId);
	}

	@Override
	public List<Cliente> buscarTodos() {
		jpql = "from Cliente r";
		query = em.createQuery(jpql);
		
		return query.getResultList();
	}

	

 
}