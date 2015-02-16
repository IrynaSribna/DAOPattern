package com.ira.persistance;

import com.ira.domain.Document;

/**
 * Created by Iryna on 2/13/15.
 */
public class FileSystemDAO implements DocumentDAO {
    @Override
    public void insertDocument(Document document) {
        System.out.println("Document is inserted");

    }

    @Override
    public Document findDocument(Integer id) {
        return new Document();
    }

    @Override
    public void deleteDocument(Integer id) {
        System.out.println("Document is deleted");
    }
}
