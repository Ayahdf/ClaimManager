package com.example.gestiondesreclamations.service.implementation;

import com.example.gestiondesreclamations.dao.entities.Produit;
import com.example.gestiondesreclamations.dao.repositories.ProduitDAO;
import com.example.gestiondesreclamations.service.ProduitManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService implements ProduitManager {

    @Autowired
    private ProduitDAO produitDAO;
    @Override
    public Produit ajouterProduit(Produit produit) {
        if (produitDAO.findByNom(produit.getNom())!=null)
        {
            produitDAO.save(produit);
            return produit;
        }

        return null;
    }

    @Override
    public Produit miseajourProduit(Produit produit) {
        if (produit != null && produit.getIdProduit() !=null && produitDAO.existsById(produit.getIdProduit()))
        {
            produitDAO.save(produit);
            return produit;
        }

        return null;
    }

    @Override
    public boolean supprimerProduit(Produit produit) {
        if(produit !=null && produit.getIdProduit() !=null && produitDAO.existsById(produit.getIdProduit()))
        {
            produitDAO.delete(produit);
            return true;
        }
        return false;
    }

    @Override
    public List<Produit> listeProduit() {

        return produitDAO.findAll();
    }

    @Override
    public Produit getProduitById(Long id) {
        Optional<Produit> produitOptional= produitDAO.findById(id);
        return produitOptional.orElse(null);
    }

    @Override
    public void supprimerProduitById(Long id) {
        produitDAO.deleteById(id);
    }

    public List<Produit> getAllProduits() {
        return produitDAO.findAll();
    }


    public Page<Produit> listeProduit2(int page, int taille) {
        return produitDAO.findAll(PageRequest.of(page, taille));
    }

    @Override
    public Page<Produit> getAllUser(String keyword, Pageable pageable) {
        return produitDAO.findByNomContaining(keyword,pageable);
    }


}
