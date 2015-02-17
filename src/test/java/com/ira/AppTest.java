package com.ira;

import com.ira.domain.Document;
import com.ira.persistance.DAOFactory;
import com.ira.persistance.DatabaseDAO;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private static final String PERSISTENCE_UNIT_NAME = "Document";
    private static EntityManagerFactory factory;
    DatabaseDAO documentDAO;
    EntityManager em;

    @Before
    public void setUp() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();
        documentDAO = (DatabaseDAO) DAOFactory.getDocumentDAO("Database");
        documentDAO.setEntityManager(em);
    }

    @Test
    public void shouldInsertFile() throws Exception {
        Document doc = new Document();
        doc.setText("Some text");

        documentDAO.insertDocument(doc);
        Query q = em.createQuery("select d from Document d");
        List<Document> documents = q.getResultList();
        Assert.assertEquals("The list size is correct", 1, documents.size());
    }

    @Test
    public void shouldFindDocument() throws Exception {

        //find a doc
        Document doc2 = new Document();
        doc2.setText("Another doc");
        documentDAO.insertDocument(doc2);
        Document foundDoc = documentDAO.findDocument(doc2.getId());
        System.out.println(foundDoc.toString());
        Query q = em.createQuery("select d from Document d");
        List<Document> documents = q.getResultList();
        Assert.assertEquals("The list size is correct", 2, documents.size());
    }

    @Test
    public void shouldDeleteDocument() throws Exception {
        //doc to remove
        Document doc3 = new Document();
        doc3.setText("Doc to delete");
        documentDAO.insertDocument(doc3);
        documentDAO.deleteDocument(doc3.getId());
        Query q = em.createQuery("select d from Document d");
        List<Document> documents = q.getResultList();
        Assert.assertEquals("The list size is correct", 2, documents.size());
    }


}
