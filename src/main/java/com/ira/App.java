package com.ira;

import com.ira.domain.Document;
import com.ira.persistance.DAOFactory;
import com.ira.persistance.DocumentDAO;

/**
 * Created by Iryna on 2/16/15.
 */
public class App
{

    public static void main(String[] args) throws Exception {
        Document doc = new Document();
        doc.setText("Some text");
        System.out.println(doc);

        //preparation
        DocumentDAO documentDAO = DAOFactory.getDocumentDAO("Database");

        //create a doc
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

        DocumentDAO fileDAO = DAOFactory.getDocumentDAO("FileSystem");
        fileDAO.insertDocument(doc2);
        fileDAO.insertDocument(doc);
        Document fileFromFileSystem = fileDAO.findDocument(doc.getId());
        System.out.println("--------------------- File from file system ------------------------------");
        System.out.println(fileFromFileSystem.toString());
        fileDAO.deleteDocument(doc2.getId());


    }
}
