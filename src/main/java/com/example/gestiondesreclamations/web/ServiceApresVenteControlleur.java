package com.example.gestiondesreclamations.web;

import com.example.gestiondesreclamations.dao.entities.ServiceApresVente;
import com.example.gestiondesreclamations.dao.entities.ServiceMaintenance;
import com.example.gestiondesreclamations.service.ServiceApresVenteManager;
import com.example.gestiondesreclamations.service.ServiceMaintenanceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Controller
public class ServiceApresVenteControlleur {
    @Autowired
    private ServiceApresVenteManager serviceApresVenteManager;



    @GetMapping("/listeapresvente")
    public String listeReclamations(Model model,
                                    @RequestParam(name = "page", defaultValue = "0") int page,
                                    @RequestParam(name = "taille", defaultValue = "5") int taille) {
        Page<ServiceApresVente> pageServiceAcceuils = serviceApresVenteManager.listeReclamations(page, taille);

        model.addAttribute("serviceAcceuils", pageServiceAcceuils.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", pageServiceAcceuils.getTotalPages());

        return "apresvente";
    }

    @GetMapping("/apresvente/new")
    public String addCategorie (Model model){
        ServiceApresVente serviceApresVente = new ServiceApresVente();
        model.addAttribute("serviceApresVente",serviceApresVente);
        return "addapresvente";
    }

    @PostMapping("/apresvente")
    public  String saveCategorie(Model model,
                                 @RequestParam("responsable")String responsable,
                                 @RequestParam("numeroTelephone")String numeroTelephone){
        ServiceApresVente serviceApresVente = new ServiceApresVente();
        serviceApresVente.setNumeroTelephone(numeroTelephone);
        serviceApresVente.setResponsable(responsable);
        serviceApresVenteManager.createSerAcc(serviceApresVente);
        List<ServiceApresVente> serviceApresVentes = serviceApresVenteManager.getAllCategorie2();
        model.addAttribute("serviceApresVente",serviceApresVentes);
        return "redirect:/listeapresvente";
    }

    @GetMapping("/apresvente/edit/{id}")
    public String editCategorieForm(Model model, @PathVariable Integer id){
        Optional<ServiceApresVente> serviceApresVente = serviceApresVenteManager.getCategorieById(id);
        model.addAttribute("serviceApresVente",serviceApresVente);
        model.addAttribute("id", id);
        return "editapresvente";

    }
    @PostMapping("/apresvente/{id}")
    public String editCategorie(Model model,
                                @PathVariable Integer id,
                                @ModelAttribute("serviceAcceuil")ServiceApresVente serviceApresVente){
        Optional<ServiceApresVente> serviceApresVente1 = serviceApresVenteManager.getCategorieById(id);
        serviceApresVente1.get().setNumeroTelephone(serviceApresVente.getNumeroTelephone());
        serviceApresVente1.get().setResponsable(serviceApresVente.getResponsable());
        serviceApresVenteManager.updateServiceAcc(serviceApresVente1.get());
        return "redirect:/listemaintenance";
    }

    @GetMapping("/apresvente/{id}")
    public String deleteUser(@PathVariable Integer id){
        serviceApresVenteManager.deleteById(id);
        return "redirect:/listeapresvente";
    }

}
