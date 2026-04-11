package modelo.dao;

import java.util.List;
import modelo.entities.Cliente;

public interface GenericoDao<E, ID> {
	
	int alta(E entity);
	int modificar(E entity);
	int eliminar(ID atributoId);
	E buscarUno(ID atributoId);
	List<E> buscarTodos();
    
    
    
} 