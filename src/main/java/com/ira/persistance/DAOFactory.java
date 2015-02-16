package com.ira.persistance;

/**
 * Created by Iryna on 2/13/15.
 */
public class DAOFactory {
    public static DocumentDAO getDocumentDAO(String sourceType) {
        switch(sourceType) {
            case "FileSystem":
                return new FileSystemDAO();
            case "Database":
                return new DatabaseDAO();
        }
        return null;
    }
}
