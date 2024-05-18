package com.example.gestiondesreclamations.service;

import com.example.gestiondesreclamations.dao.entities.Reclamation;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ReclamationManager {
    public Reclamation ajouterReclamation(Reclamation reclamation);
    public Reclamation miseajourReclamation(Reclamation reclamation);
    public boolean supprimerReclamation(Reclamation reclamation);
    public boolean supprimerReclamationById(Long id);
    public Page<Reclamation> listeReclamations(int page, int taille);
    public Reclamation getReclamationById(Long id);
}
