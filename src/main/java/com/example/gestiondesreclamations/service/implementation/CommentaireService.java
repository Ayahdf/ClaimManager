package com.example.gestiondesreclamations.service.implementation;

import com.example.gestiondesreclamations.dao.entities.Commentaire;
import com.example.gestiondesreclamations.dao.repositories.CommentaireDAO;
import com.example.gestiondesreclamations.service.CommentaireManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class CommentaireService implements CommentaireManager {
    @Autowired
    private CommentaireDAO commentaireDAO;
    @Override
    public Commentaire ajouterCommentaire(Commentaire commentaire) {

        return commentaireDAO.save(commentaire);
    }

    @Override
    public Commentaire miseajourCommentaire(Commentaire commentaire) {
        if (commentaire != null && commentaire.getCommentaireId() != null && commentaireDAO.existsById(commentaire.getCommentaireId()))
        {
            return commentaireDAO.save(commentaire);
        }

        return null;
    }

    @Override
    public boolean supprimerCommentaire(Commentaire commentaire) {
        if (commentaire != null && commentaire.getCommentaireId() != null && commentaireDAO.existsById(commentaire.getCommentaireId()))
        {
             commentaireDAO.delete(commentaire);
             return true;
        }
        return false;
    }

    @Override
    public Page<Commentaire> listeCommentaires(int page, int taille) {
        return commentaireDAO.findAll(PageRequest.of(page, taille));
    }

    @Override
    public List<Commentaire> listeCommentaires() {
        return commentaireDAO.findAll();
    }

    @Override
    public List<Commentaire> getCommentairesByProduitId(Long produitId) {
        return commentaireDAO.findByProduitIdProduit(produitId);
    }
}
