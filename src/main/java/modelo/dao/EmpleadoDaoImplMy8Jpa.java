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
		jpql = "from Empleado e";
		query = em.createQuery(jpql);
		
		return query.getResultList();
	}

	@Override
	public List<Empleado> empleadosByDepartamento(int IdDepar) {
		jpql = "from Empleado e where e.departamento.departamentoId = :dep";
		
		query = em.createQuery(jpql);
		query.setParameter("dep" , IdDepar);
		return query.getResultList();
	}

	@Override
	public List<Empleado> empleadosByGenero(char sexo) {
		jpql = "from Empleado e where e.genero = :gen";
		
		query = em.createQuery(jpql);
		query.setParameter("gen" , sexo);
		return query.getResultList();
	}


	@Override
	public List<Empleado> empleadosByApellido(String subcadena) {
		jpql = "from Empleado e where e.apellidos = :apell";
		
		query = em.createQuery(jpql);
		query.setParameter("apell" , subcadena);
		return query.getResultList();
	}


	@Override
	public double salarioTotal() {
		jpql = "SELECT SUM(e.salario) from Empleado e";
		query = em.createQuery(jpql);
		
		return (double) query.getSingleResult();
	}

	@Override
	public double salarioTotal(int idDepar) {
		jpql = "SELECT SUM(e.salario) from Empleado e where e.departamento.departamentoId = :depar";
		
		query = em.createQuery(jpql);
		query.setParameter("depar" , idDepar);
		return (double) query.getSingleResult();
	}



}
