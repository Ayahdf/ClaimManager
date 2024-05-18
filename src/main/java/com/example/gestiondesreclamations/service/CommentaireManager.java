package com.example.gestiondesreclamations.service;

import com.example.gestiondesreclamations.dao.entities.Commentaire;
import org.springframework.data.domain.Page;


import java.util.List;

public interface CommentaireManager {
    public Commentaire ajouterCommentaire(Commentaire commentaire);
    public Commentaire miseajourCommentaire(Commentaire commentaire);
    public boolean supprimerCommentaire(Commentaire commentaire);
    public Page<Commentaire> listeCommentaires (int page, int taille);
    public List<Commentaire> listeCommentaires();
    List<Commentaire> getCommentairesByProduitId(Long produitId);
}
