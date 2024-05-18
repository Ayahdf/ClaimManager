package com.example.gestiondesreclamations.dao.repositories;

import com.example.gestiondesreclamations.dao.entities.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentaireDAO extends JpaRepository<Commentaire,Long> {
    List<Commentaire> findByProduitIdProduit(Long idProduit);
}
