package library.data;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class Repository {
    public void persist(Object entity) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("libraryPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public void merge(Object entity) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("libraryPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public Object getSingleResult(String queryText) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("libraryPU");
        EntityManager em = emf.createEntityManager();

        try {
            Query query = em.createQuery(queryText);
            return query.getSingleResult();
            
        } finally {
            em.close();
        }        
    }
    
    public Object getResultList(String queryText) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("libraryPU");
        EntityManager em = emf.createEntityManager();
        
        try {
            Query query = em.createQuery(queryText);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
