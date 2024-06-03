package com.example.gestiondesreclamations.web;

import com.example.gestiondesreclamations.dao.entities.Produit;
import com.example.gestiondesreclamations.dao.entities.Utilisateur;
import com.example.gestiondesreclamations.service.ProduitManager;
import com.example.gestiondesreclamations.service.implementation.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller

public class ProduitController {
    @Autowired
    private ProduitService produitService;
    @Autowired
    private ProduitManager produitManager;

    @GetMapping("/")
    public String start()
    {
        return "indexpage";
    }

    @GetMapping("/listProduits")
    public String listProduits(Model model,
                               @RequestParam(name = "page", defaultValue = "0" ) int page,
                               @RequestParam(name = "taille", defaultValue = "6" ) int taille,
                               @RequestParam(name = "search", defaultValue = "") String keyword)
    {
        Pageable pageable = PageRequest.of(page, taille);
        Page<Produit> produits = produitManager.getAllUser(keyword,pageable);
        model.addAttribute("listProduits",produits.getContent());
        int[] pages = new int[produits.getTotalPages()];
        for (int i = 0; i < pages.length; i++) {
            pages[i] = i;
        }
        model.addAttribute("pages",pages);
        model.addAttribute("currentpages",page);

        return "listProduit";
    }
    @GetMapping("/ajouterProduit")
    public String ajouterProduit()
    {

        return "ajouterProduit";
    }
    @PostMapping("/ajouterProduit")
    public String ajouterProduit(@RequestParam(name = "nom")String nom,
                                 @RequestParam(name = "description") String description,
                                 Model model)
    {
        Produit produit=new Produit();
        produit.setNom(nom);
        produit.setDescription(description);
        produitService.ajouterProduit(produit);
        model.addAttribute("Produit",produit);
        return "redirect:/listProduits";
    }
    @GetMapping("/modifierProduit/{id}")
    public String modifierProduit(Model model, @PathVariable long id) {

        Produit produit = produitService.getProduitById(id);
        model.addAttribute("produit", produit);
        return "modifierProduit"; // Redirige vers la vue pour modifier un produit spécifique

    }


    @PostMapping("/modifierProduit/{id}")
    public  String modifierProduit(Model model,
                                   @PathVariable("id")Long id,
                                   @ModelAttribute("produit")Produit produit){
        Produit exPro = produitService.getProduitById(id);
        exPro.setDescription(produit.getDescription());
        exPro.setIdProduit(id);
        exPro.setNom(produit.getNom());
        produitService.miseajourProduit(exPro);

        return "redirect:/listProduits";


    }

    @GetMapping("/deleteProduit/{id}")
    public String deleteprod(@PathVariable Long id){
        produitService.supprimerProduitById(id);
        return "redirect:/listProduits";
    }



}

