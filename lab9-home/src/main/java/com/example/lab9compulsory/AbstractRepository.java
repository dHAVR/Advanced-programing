package com.example.lab9compulsory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.logging.Level;

public abstract class AbstractRepository<T, ID> {
    private Class<T> entityClass;
    private EntityManagerFactory entityManagerFactory;

    public AbstractRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
        this.entityManagerFactory = EntityManagerFactorySingleton.getEntityManagerFactory();
    }

    public T findById(ID id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        T entity = null;
        try {
          entity = entityManager.find(entityClass, id);
          LogHelper.log(Level.INFO, "Successfully found book: ");
        } catch (Exception ex) {
            LogHelper.log(Level.SEVERE, "Error finding book with ID: " );
        } finally {
            entityManager.close();
        }
        return entity;
    }

    public void create(T entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(T entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
