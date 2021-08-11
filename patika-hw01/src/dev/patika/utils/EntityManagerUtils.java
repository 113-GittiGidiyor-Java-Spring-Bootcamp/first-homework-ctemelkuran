package dev.patika.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtils {

    static EntityManagerFactory emf = null;

    public static EntityManager getEntityManager(String persistenceUnitName){
        emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        return emf.createEntityManager();
    }

    // Entity manager is closed to save sources
    public static void closeEntityManager(EntityManager em){
        em.clear();
        em.close();
        emf.close();
    }
}
