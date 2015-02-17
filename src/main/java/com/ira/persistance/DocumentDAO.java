package com.ira.persistance;

import com.ira.domain.Document;

/**
 * Created by Iryna on 2/13/15.
 */
public interface DocumentDAO {

    public void insertDocument(Document document) throws Exception;

    public Document findDocument(Integer id) throws Exception;

    public void deleteDocument(Integer id);
}
