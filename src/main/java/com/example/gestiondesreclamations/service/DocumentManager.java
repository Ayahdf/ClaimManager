package com.example.gestiondesreclamations.service;

import com.example.gestiondesreclamations.dao.entities.Document;

import java.util.List;

public interface DocumentManager {
    public List<Document> listeDocuments();
    public Document ajouterDocument(Document document);
    public Document miseajourDocument(Document document);
    public boolean supprimerDocument(Document document);
}
