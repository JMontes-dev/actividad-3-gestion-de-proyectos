package modelo.dao;

import java.util.List;

import modelo.entities.Proyecto;

public interface ProyectoDao extends GenericoDao<Proyecto, String>{

	List<Proyecto> proyectosByEstado(String estado);
	
	List<Proyecto> proyectosByCliente(String cif);
	
	List<Proyecto> proyectosByJefeProyectoAndEstado(int jefeProyecto, String estado);
	
	double importesVentaProyectosTerminados();
	
	double margenBrutoProyectosTerminados();
	
	double porcentageMargenBrutoProyectosTerminados();
	
	int diasATerminoProyectoActivo(String codigoProyecto);
		
	
}
