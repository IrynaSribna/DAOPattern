package com.ira.persistance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;

/**
 * Created by Iryna on 2/13/15.
 */
public class DAOFactory {
    private static final String PERSISTENCE_UNIT_NAME = "Document";
    private static EntityManagerFactory factory;
  //  private static String path = "daoFiles"+File.separator;


    public static DocumentDAO getDocumentDAO(String sourceType) {
        switch(sourceType) {
            case "FileSystem":
                FileSystemDAO fileSystemDAO = new FileSystemDAO();
                //create a folder

                String path = "daoFiles"+File.separator;
                fileSystemDAO.setPath(path);
                return fileSystemDAO;
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
