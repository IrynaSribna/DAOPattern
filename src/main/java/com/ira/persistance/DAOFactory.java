package com.ira.persistance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Iryna on 2/13/15.
 */
public class DAOFactory {
    private static final String PERSISTENCE_UNIT_NAME = "Document";
    private static EntityManagerFactory factory;

    public static DocumentDAO getDocumentDAO(String sourceType) {
        switch(sourceType) {
            case "FileSystem":
                return new FileSystemDAO();
            case "Database":
                factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
                EntityManager em = factory.createEntityManager();
                DatabaseDAO databaseDAO = new DatabaseDAO();
                databaseDAO.setEntityManager(em);
                return databaseDAO;
        }
        return null;
    }
}
