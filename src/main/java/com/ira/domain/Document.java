package com.ira.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Iryna on 2/13/15.
 */
@Entity
public class Document implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    private String text;

    public Document() {

    }

    public Document(Integer id, String text) {
        this.id = id;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

//    public DocumentTransfer getDocumentTransferObject() {
//        DocumentTransfer documentTransfer = new DocumentTransfer();
//        documentTransfer.setId(id);
//        documentTransfer.setText(text);
//
//        return documentTransfer;
//    }

    public String toString() {
        return "Document: " + id +  "\n " + "Content: " + text;
    }
}
