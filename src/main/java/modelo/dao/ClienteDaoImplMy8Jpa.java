package modelo.dao;

import java.util.ArrayList;
import java.util.List;
import modelo.entities.Cliente;



public class ClienteDaoImplMy8Jpa extends AbstractDaoImpl implements ClienteDao {

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
	public Cliente buscarUno(String cif) {

		return em.find(Cliente.class, cif);
	}

	@Override
	public List<Cliente> findAll() {
		jpql = "from Cliente c";
		query = em.createQuery(jpql);
		
		return query.getResultList();
	}

	@Override
	public int eliminar(String cif) {
		Cliente cliente = buscarUno(cif);
		if(buscarUno(cif) != null) {
			
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
    
 
}