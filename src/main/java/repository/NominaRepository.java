package repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;
import model.Nomina;
import util.JPAUtil;

/**
 * Repositorio de Nomina Responsable del acceso a datos mediante JPA Reemplaza
 * el ArrayList por persistencia en base de datos MySQL
 */
public class NominaRepository {

	public void agregar(Nomina nomina) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(nomina);
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive())
				tx.rollback();
			throw e;
		} finally {
			em.close();
		}
	}

	public List<Nomina> obtenerTodas() {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			return em.createQuery("SELECT n FROM Nomina n", Nomina.class).getResultList();
		} finally {
			em.close();
		}
	}

	public void limpiar() {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.createQuery("DELETE FROM Nomina n").executeUpdate();
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive())
				tx.rollback();
			throw e;
		} finally {
			em.close();
		}
	}

	public int contar() {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			Long count = em.createQuery("SELECT COUNT(n) FROM Nomina n", Long.class).getSingleResult();
			return count.intValue();
		} finally {
			em.close();
		}
	}
	
	public boolean existePorIdONombre(String id, String nombre) {
	    EntityManager em = JPAUtil.getEntityManager();
	    try {
	        Long count = em.createQuery(
	            "SELECT COUNT(n) FROM Nomina n WHERE n.id = :id OR LOWER(n.nombre) = LOWER(:nombre)",
	            Long.class)
	            .setParameter("id", id)
	            .setParameter("nombre", nombre)
	            .getSingleResult();
	        return count > 0;
	    } finally {
	        em.close();
	    }
	}
	
	public void eliminarPorId(String id) {
	    EntityManager em = JPAUtil.getEntityManager();
	    EntityTransaction tx = em.getTransaction();
	    try {
	        tx.begin();
	        em.createQuery("DELETE FROM Nomina n WHERE n.id = :id")
	          .setParameter("id", id)
	          .executeUpdate();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx.isActive()) tx.rollback();
	        throw e;
	    } finally {
	        em.close();
	    }
	}

	
}