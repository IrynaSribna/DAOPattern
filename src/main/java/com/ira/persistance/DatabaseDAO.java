package com.ira.persistance;

import com.ira.domain.Document;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Iryna on 2/13/15.
 */
public class DatabaseDAO implements DocumentDAO {

    private EntityManager entityManager;


    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
    @Override
    public void insertDocument(Document document) throws Exception {

        getEntityManager().getTransaction().begin();
        getEntityManager().persist(document);
        getEntityManager().flush();
        getEntityManager().getTransaction().commit();

//        javax.persistence.Query q = entityManager.createQuery("select d from Document d");
//        List<Document> documents = q.getResultList();

    }

    @Override
    public Document findDocument(Integer id) {
          Query selectQuery = (Query) getEntityManager().createQuery("SELECT d FROM Document d WHERE d.id = :id").setParameter("id" , id);
          Document doc = (Document) selectQuery.getSingleResult();
          return doc;

    }

    @Override
    public void deleteDocument(Integer id) {
        getEntityManager().getTransaction().begin();
        Query q = getEntityManager()
                .createQuery("SELECT d FROM Document d WHERE d.id = :id");
        q.setParameter("id", id);
        Document docToDelete = (Document) q.getSingleResult();
        getEntityManager().remove(docToDelete);
        getEntityManager().getTransaction().commit();

//        Query qu = getEntityManager().createQuery("SELECT d FROM Document d");
//        List<Document> documents = qu.getResultList();

    }
}
