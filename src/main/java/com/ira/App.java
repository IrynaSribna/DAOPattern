package com.ira;

import com.ira.domain.Document;
import com.ira.persistance.DAOFactory;
import com.ira.persistance.DatabaseDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Iryna on 2/16/15.
 */
public class App
{
    private static final String PERSISTENCE_UNIT_NAME = "Document";
    private static EntityManagerFactory factory;


    public static void main(String[] args) throws Exception {
        Document doc = new Document();
        doc.setText("Some text");
        System.out.println(doc);

        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        //create a doc
        DatabaseDAO documentDAO = (DatabaseDAO) DAOFactory.getDocumentDAO("Database");
        documentDAO.setEntityManager(em);
        documentDAO.insertDocument(doc);

        //find a doc
        Document doc2 = new Document();
        doc2.setText("Another doc");
        documentDAO.insertDocument(doc2);
        Document foundDoc = documentDAO.findDocument(doc2.getId());
        System.out.println(foundDoc.toString());

        //doc to remove
        Document doc3 = new Document();
        doc3.setText("Doc to delete");
        documentDAO.insertDocument(doc3);
        documentDAO.deleteDocument(doc3.getId());

    }
}
