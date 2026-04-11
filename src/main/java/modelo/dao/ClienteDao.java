package modelo.dao;

import java.util.List;
import modelo.entities.Cliente;

public interface ClienteDao {
	
    int alta(Cliente cliente);
    Cliente buscarUno(String cif);
    List<Cliente> findAll();
    int eliminar(String cif);
    
} 