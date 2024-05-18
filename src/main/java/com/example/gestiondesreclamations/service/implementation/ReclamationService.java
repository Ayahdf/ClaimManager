package com.example.gestiondesreclamations.service.implementation;

import com.example.gestiondesreclamations.dao.entities.Reclamation;
import com.example.gestiondesreclamations.dao.repositories.ReclamationDAO;
import com.example.gestiondesreclamations.service.ReclamationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class ReclamationService implements ReclamationManager {
    @Autowired
    private ReclamationDAO reclamationDAO;
    @Override
    public Reclamation ajouterReclamation(Reclamation reclamation) {

        return reclamationDAO.save(reclamation);
    }

    @Override
    public Reclamation miseajourReclamation(Reclamation reclamation) {
        if ( reclamation.getReclamationId() != null && reclamationDAO.existsById(reclamation.getReclamationId())) {
            return reclamationDAO.save(reclamation);
        }
        return null;
    }

    @Override
    public boolean supprimerReclamation(Reclamation reclamation) {
       if (reclamation.getReclamationId() != null && reclamationDAO.existsById(reclamation.getReclamationId())) {
             reclamationDAO.delete(reclamation);
             return true;
        }
        return false;
    }

    @Override
    public boolean supprimerReclamationById(Long id) {
        reclamationDAO.deleteById(id);
        return false;
    }

    @Override
    public Page<Reclamation> listeReclamations(int page, int taille) {

        return reclamationDAO.findAll(PageRequest.of(page,taille));
    }

    @Override
    public Reclamation getReclamationById(Long id) {
        Optional<Reclamation> reclamationOptional=reclamationDAO.findById(id);
        return reclamationOptional.orElse(null);
    }
}
