package com.example.gestiondesreclamations.service.implementation;

import com.example.gestiondesreclamations.dao.entities.Document;
import com.example.gestiondesreclamations.dao.repositories.DocumentDAO;
import com.example.gestiondesreclamations.service.DocumentManager;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DocumentService implements DocumentManager {
    private DocumentDAO documentDAO;
    @Override
    public List<Document> listeDocuments() {
        return null;
    }

    @Override
    public Document ajouterDocument(Document document) {
        return documentDAO.save(document);

    }

    @Override
    public Document miseajourDocument(Document document) {
        if (document.getId()!=null && documentDAO.existsById(document.getId()))
        {
            return documentDAO.save(document);
        }

            return null;
    }

    @Override
    public boolean supprimerDocument(Document document) {

        if (document.getId()!=null && documentDAO.existsById(document.getId()))
        {
            documentDAO.delete(document);
            return true;
        }
            return false;
    }
}
