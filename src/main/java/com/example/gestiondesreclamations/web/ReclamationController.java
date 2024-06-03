//package com.example.gestiondesreclamations.web;
//
//import com.example.gestiondesreclamations.dao.entities.Reclamation;
//import com.example.gestiondesreclamations.service.implementation.ReclamationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@Controller
//
//public class ReclamationController {
//    @Autowired
//    public ReclamationService reclamationService;
//
//    @GetMapping("/listeReclamations")
//    public String listeReclamations(Model model, @RequestParam(name = "page" , defaultValue = "0")int page, @RequestParam(name = "taille" , defaultValue = "5")int taille)
//    {
//        Page<Reclamation> reclamations=reclamationService.listeReclamations(page,taille);
//        model.addAttribute("listeReclamations",reclamations.getContent());
//        int[]pages = new int[reclamations.getTotalPages()];
//        model.addAttribute("pages", pages);
//        model.addAttribute("currentpage",page);
//
//        return "listeReclamations";
//    }
//
//    @GetMapping("/ajouterReclamation")
//    public String ajouterReclamation()
//    {
//        return "/ajouterReclamation";
//    }
//
//    @PostMapping("/ajouterReclamation")
//    public String ajouterReclamation(Model model, @RequestParam(name = "titre")String titre, @RequestParam(name = "description")String description)
//    {
//        Reclamation reclamation=new Reclamation();
//        reclamation.setTitre(titre);
//        reclamation.setDescription(description);
//        reclamationService.ajouterReclamation(reclamation);
//        model.addAttribute("reclamation",reclamation);
//        return "redirect:/listeReclamations";
//    }
//    @GetMapping("/modifierReclamation/{id}")
//    public String modifierReclamation(Model model, @PathVariable long id)
//    {
//        Optional<Reclamation> reclamation=reclamationService.getReclamationById(id);
//        if (reclamation!=null){
//            System.out.println("ana mabidi chay");
//            model.addAttribute("reclamationToBeUpdated",reclamation);
//            return "modifierReclamation";
//        }
//        System.out.println("gltili");
//        return "error";
//    }
//
//    @PostMapping("/modifierReclamation/{id}")
//    public String modifierReclamation(Model model, @PathVariable long id, @ModelAttribute("reclamation")Reclamation reclamation)
//    {
//        reclamationService.miseajourReclamation(reclamation);
//        return "redirect:/listeReclamations";
//    }
//}






package com.example.gestiondesreclamations.web;

import com.example.gestiondesreclamations.dao.entities.*;
import com.example.gestiondesreclamations.service.ServiceAcceuilManager;
import com.example.gestiondesreclamations.service.ServiceMaintenanceManager;
import com.example.gestiondesreclamations.service.ServiceManager;
import com.example.gestiondesreclamations.service.implementation.ProduitService;
import com.example.gestiondesreclamations.service.implementation.ReclamationService;
import com.example.gestiondesreclamations.service.implementation.ServiceService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ReclamationController {

    @Autowired
    public ReclamationService reclamationService;

    @Autowired
    public ProduitService produitService;
    @Autowired
    public ServiceAcceuilManager serviceAcceuilManager;
    @Autowired
    public ServiceMaintenanceManager serviceMaintenanceManager;
    @Autowired
    public ServiceManager serviceManager;



    @GetMapping("/listeReclamations")
    public String listeReclamations(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
                                    @RequestParam(name = "taille", defaultValue = "5") int taille) {
        Page<Reclamation> reclamations = reclamationService.listeReclamations(page, taille);

        // Charger le produit associé à chaque réclamation
        for (Reclamation reclamation : reclamations.getContent()) {
            if (reclamation.getProduit() != null && reclamation.getProduit().getIdProduit()!=null) {
                Produit produit = produitService.getProduitById(reclamation.getProduit().getIdProduit());
                reclamation.setProduit(produit);
            }
        }

        model.addAttribute("listeReclamations", reclamations.getContent());
        int[] pages = new int[reclamations.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("currentpage", page);

        return "listeReclamations";
    }


    @GetMapping("/listeReclamation")
    public String listeReclamation(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
                                   @RequestParam(name = "taille", defaultValue = "5") int taille) {
        Page<Reclamation> reclamations = reclamationService.listeReclamations(page, taille);

        // Charger le produit associé à chaque réclamation
        for (Reclamation reclamation : reclamations.getContent()) {
            if (reclamation.getService() != null && reclamation.getService().getId()!=null) {
//                Produit produit = produitService.getProduitById(reclamation.getProduit().getIdProduit());
                Optional<Service> service =serviceManager.getServiceById(reclamation.getService().getId());
                reclamation.setService(service.get());
            }
        }

        model.addAttribute("listeReclamations", reclamations.getContent());
        int[] pages = new int[reclamations.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("currentpage", page);

        return "listeReclamation";
    }

    @GetMapping("/ajouterReclamation")
    public String ajouterReclamation() {
        return "ajouterReclamation";
    }


    @PostMapping("/ajouterReclamation")
    public String ajouterReclamation(Model model, @RequestParam(name = "titre") String titre,
                                     @RequestParam(name = "description") String description
    ) {
        Reclamation reclamation = new Reclamation();
        reclamation.setTitre(titre);
        reclamation.setDescription(description);
        reclamationService.ajouterReclamation(reclamation);
        model.addAttribute("reclamation", reclamation);
        return "redirect:/listeReclamations";
    }

    @GetMapping("/modifierReclamation/{id}")
    public String modifierReclamation(Model model, @PathVariable long id) {
        Reclamation reclamation = reclamationService.getReclamationById(id);

        model.addAttribute("reclamationToBeUpdated", reclamation);
        return "modifierReclamation";


    }
    @PostMapping("/modifierReclamation/{id}")
    public  String modifierProduit(Model model,
                                   @PathVariable("id")Long id,
                                   @ModelAttribute("reclamation") Reclamation reclamation){
        Reclamation exRec = reclamationService.getReclamationById(id);
        exRec.setTitre(reclamation.getTitre());
        exRec.setDescription(reclamation.getDescription());
        exRec.setReclamationId(id);
        reclamationService.miseajourReclamation(exRec);
        return "redirect:/listeReclamations";


    }


    @GetMapping("/supprimerReclamation/{id}")
    public String supprimerReclamation(@PathVariable long id) {
        reclamationService.supprimerReclamationById(id);
        return "redirect:/listeReclamations";
    }

    @GetMapping("/detailsReclamation/{id}")
    public String detailsReclamation(Model model, @PathVariable long id) {
        Reclamation reclamation = reclamationService.getReclamationById(id);

        model.addAttribute("reclamation", reclamation);
        return "detailsReclamation";

    }

    @GetMapping("/reclamer/{produitId}")
    public String reclamerProduit(@PathVariable Long produitId, Model model) {
        Reclamation reclamation = new Reclamation();
        Produit produit = produitService.getProduitById(produitId);
        reclamation.setProduit(produit);
        model.addAttribute("reclamation", reclamation);
        model.addAttribute("produit", produit);
        return "reclamer";
    }


    @PostMapping("/reclamer/{produitId}")
    public String ajouterReclamation(Model model, @PathVariable Long produitId, @RequestParam(name = "titre") String titre, @RequestParam(name = "description") String description) {
        Reclamation reclamation = new Reclamation();
        reclamation.setTitre(titre);
        reclamation.setDescription(description);
        Produit produit = produitService.getProduitById(produitId);
        reclamation.setProduit(produit);
        reclamationService.ajouterReclamation(reclamation);
        model.addAttribute("reclamation", reclamation);
        return "redirect:/listProduits";
    }
    @GetMapping("/reclamation")
    public String star(){
        return "reclamation";
    }

    @GetMapping("/rec")
    public String sta(){
        return "rec";
    }

    @GetMapping("/recla")
    public String startee(){
        return "recla";
    }

    @GetMapping("/reclamer/acc/{id}")
    public String reclamerAcc(@PathVariable Integer id ,Model model){
        Reclamation reclamation =new Reclamation();
        Optional<ServiceAcceuil> serviceAcceuil = serviceAcceuilManager.findServiceById(id);
        reclamation.setService(serviceAcceuil.get());
        model.addAttribute("reclamation", reclamation);
        model.addAttribute("produit",serviceAcceuil.get());
        return "reclameracc";
    }
    @GetMapping("/reclamer/man/{id}")
    public String reclamerMan(@PathVariable Integer id ,Model model){
        Reclamation reclamation =new Reclamation();
        Optional<ServiceMaintenance> serviceMaintenance = serviceMaintenanceManager.findServiceById(id);
        reclamation.setService(serviceMaintenance.get());
        model.addAttribute("reclamation", reclamation);
        model.addAttribute("produit",serviceMaintenance.get());
        return "reclamerman";
    }




    @PostMapping("/reclamer/acc/{id}")
    public String ajouterReclamationAcc(Model model, @PathVariable Integer id,
                                        @RequestParam(name = "titre") String titre,
                                        @RequestParam(name = "description") String description) {
        Reclamation reclamation = new Reclamation();
        reclamation.setTitre(titre);
        reclamation.setDescription(description);
        Optional<ServiceAcceuil> serviceAcceuil = serviceAcceuilManager.getCategorieById(id);
        reclamation.setService(serviceAcceuil.get());
        reclamationService.ajouterReclamation(reclamation);
        model.addAttribute("reclamation", reclamation);
        return "redirect:/rec";
    }
    @PostMapping("/reclamerman/man/{id}")
    public String ajouterReclamationMan(Model model, @PathVariable Integer id,
                                        @RequestParam(name = "titre") String titre,
                                        @RequestParam(name = "description") String description) {
        Reclamation reclamation = new Reclamation();
        reclamation.setTitre(titre);
        reclamation.setDescription(description);
        Optional<ServiceMaintenance> serviceMaintenance = serviceMaintenanceManager.findServiceById(id);
        reclamation.setService(serviceMaintenance.get());
        reclamationService.ajouterReclamation(reclamation);
        model.addAttribute("reclamation", reclamation);
        return "redirect:/rec";
    }










}
