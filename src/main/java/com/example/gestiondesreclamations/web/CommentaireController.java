package com.example.gestiondesreclamations.web;

import com.example.gestiondesreclamations.dao.entities.Commentaire;
import com.example.gestiondesreclamations.dao.entities.Produit;
import com.example.gestiondesreclamations.dao.entities.Reclamation;
import com.example.gestiondesreclamations.service.implementation.CommentaireService;
import com.example.gestiondesreclamations.service.implementation.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class CommentaireController {
    @Autowired
    public CommentaireService commentaireService;
    @Autowired
    public ProduitService produitService;

    @GetMapping("/commentaire")
    public String listeCommentaire(Model model) {
        List<Commentaire> listCommentaires = commentaireService.getAllCommentaires();
//        List<Produit> produit = produitService.getAllProduits();
//        model.addAttribute("produit", produit);
        model.addAttribute("listCommentaires", listCommentaires);
        return "listeCommentaire";
    }

    @GetMapping("/commentaires/{idProduit}")
    public String listeCommentaires(@PathVariable Long idProduit, Model model) {
        Produit produit = produitService.getProduitById(idProduit);
        List<Commentaire> listCommentaires = commentaireService.getCommentairesByProduitId(idProduit);
        model.addAttribute("produit", produit);
        model.addAttribute("listCommentaires", listCommentaires);
        return "listeCommentaires";
    }

    @GetMapping("/ajouterCommentaire/{idProduit}")
    public String afficherFormulaireAjoutCommentaire(@PathVariable Long idProduit, Model model) {
        Commentaire commentaire = new Commentaire();
        Produit produit = produitService.getProduitById(idProduit);
        commentaire.setProduit(produit);
        model.addAttribute("commentaire", commentaire);
        model.addAttribute("produit", produit);
        return "formulaireCommentaire";
    }



    //    @PostMapping("/ajouterCommentaire")
//    public String ajouterCommentaire(@ModelAttribute("commentaire") Commentaire commentaire) {
//        Produit produit = commentaire.getProduit();
//        commentaireService.ajouterCommentaire(commentaire);
//        return "redirect:/commentaires/" + produit.getIdProduit();
//    }
    @PostMapping("/ajouterCommentaire/{produitId}")
    public String ajouterCommentaire(@ModelAttribute("commentaire") Commentaire commentaire, @PathVariable Long produitId) {
        Produit produit = produitService.getProduitById(produitId);
        commentaire.setProduit(produit);
        commentaireService.ajouterCommentaire(commentaire);
        return "redirect:/commentaires/" + produitId;
    }

//    @PostMapping("/ajouterCommentaire")
//    public String ajouterCommentaire(@ModelAttribute("commentaire") Commentaire commentaire) {
//        Produit produit = commentaire.getProduit();
//        commentaireService.ajouterCommentaire(commentaire);
//        return "redirect:/commentaires/" + produit.getIdProduit();
//    }


}
