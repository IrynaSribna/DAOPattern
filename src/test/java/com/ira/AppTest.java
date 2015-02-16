package com.ira;

import com.ira.domain.Document;
import com.ira.persistance.DAOFactory;
import com.ira.persistance.DatabaseDAO;
import com.ira.persistance.DocumentDAO;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private static final String PERSISTENCE_UNIT_NAME = "Document";
    private static EntityManagerFactory factory;

    @Test
    public void testDAO() throws Exception {
        Document doc = new Document(1, "First doc");
        System.out.println(doc);

        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        //DocumentTransfer docTransfer = doc.getDocumentTransferObject();
        DatabaseDAO documentDAO = (DatabaseDAO) DAOFactory.getDocumentDAO("Database");
        documentDAO.setEntityManager(em);
        documentDAO.insertDocument(doc);
    }


}
