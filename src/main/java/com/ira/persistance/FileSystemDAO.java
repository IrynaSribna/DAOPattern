package com.ira.persistance;

import com.ira.domain.Document;

import java.io.*;
import java.nio.file.Files;

/**
 * Created by Iryna on 2/13/15.
 */
public class FileSystemDAO implements DocumentDAO {
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public void insertDocument(Document document) throws IOException {
        File fileName = new File(path + document.getId() + ".txt");
        boolean result = fileName.getParentFile().mkdirs();
        FileOutputStream fos = new FileOutputStream(fileName);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(document);
        oos.close();
        System.out.println("Document is inserted");

    }

    @Override
    public Document findDocument(Integer id) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(path + id + ".txt");
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);
        Document document = (Document) ois.readObject();
        ois.close();
        return document;
    }

    @Override
    public void deleteDocument(Integer id) {
        File file = new File(path + id + ".txt");

        if(file.delete()){
            System.out.println(file.getName() + " is deleted!");
        }else{
            System.out.println("Delete operation is failed.");
        }

    }
}
