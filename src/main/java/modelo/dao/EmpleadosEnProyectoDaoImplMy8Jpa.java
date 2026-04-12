package modelo.dao;

import java.util.List;
import jakarta.persistence.TypedQuery;
import modelo.entities.Empleado;
import modelo.entities.EmpleadosEnProyecto;

public class EmpleadosEnProyectoDaoImplMy8Jpa extends AbstractDaoImpl implements EmpleadosEnProyectoDao {

    @Override
    public List<EmpleadosEnProyecto> findAll() {
        return em.createQuery("SELECT ee FROM EmpleadosEnProyecto ee", EmpleadosEnProyecto.class)
                 .getResultList();
    }

    @Override
    public EmpleadosEnProyecto findById(int id) {
        return em.find(EmpleadosEnProyecto.class, id);
    }

    @Override
    public boolean create(EmpleadosEnProyecto ee) {
        try {
            tx.begin();
            em.persist(ee);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            return false;
        }
    }

    @Override
    public boolean update(EmpleadosEnProyecto ee) {
        try {
            tx.begin();
            em.merge(ee);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            EmpleadosEnProyecto ee = findById(id);
            if (ee != null) {
                tx.begin();
                em.remove(ee);
                tx.commit();
                return true;
            }
        } catch (Exception e) {
            tx.rollback();
        }
        return false;
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
}