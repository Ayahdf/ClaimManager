package com.example.gestiondesreclamations.dao.repositories;

import com.example.gestiondesreclamations.dao.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitDAO extends JpaRepository<Produit,Long> {

    List<Produit> findByNom (String nom);

    Page<Produit> findByNomContaining(String keyword, Pageable pageable);
}
