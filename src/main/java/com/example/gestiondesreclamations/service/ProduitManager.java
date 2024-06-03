package com.example.gestiondesreclamations.service;

import com.example.gestiondesreclamations.dao.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProduitManager {
    public Produit ajouterProduit(Produit produit);
    public Produit miseajourProduit(Produit produit);
    public boolean supprimerProduit(Produit produit);
    public List<Produit> listeProduit();
    public Produit getProduitById(Long id);

    void supprimerProduitById(Long id);
    public Page<Produit> listeProduit2(int page, int taille);

    Page<Produit> getAllUser(String keyword, Pageable pageable);
}
