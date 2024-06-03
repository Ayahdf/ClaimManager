package com.example.gestiondesreclamations.web;

import com.example.gestiondesreclamations.dao.entities.Produit;
import com.example.gestiondesreclamations.dao.entities.ServiceAcceuil;
import com.example.gestiondesreclamations.dao.entities.ServiceApresVente;
import com.example.gestiondesreclamations.dao.entities.ServiceMaintenance;
import com.example.gestiondesreclamations.service.ServiceAcceuilManager;
import com.example.gestiondesreclamations.service.ServiceMaintenanceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Controller
public class ServiceMaintenanceController {
    @Autowired
    private ServiceMaintenanceManager serviceMaintenanceManager;



    @GetMapping("/listemaintenance")
    public String listeReclamations(Model model,
                                    @RequestParam(name = "page", defaultValue = "0") int page,
                                    @RequestParam(name = "taille", defaultValue = "5") int taille) {
        Page<ServiceMaintenance> pageServiceAcceuils = serviceMaintenanceManager.listeReclamations(page, taille);

        model.addAttribute("serviceAcceuils", pageServiceAcceuils.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", pageServiceAcceuils.getTotalPages());

        return "maintenance";
    }

    @GetMapping("/maintenance/new")
    public String addCategorie (Model model){
        ServiceMaintenance serviceMaintenance = new ServiceMaintenance();
        model.addAttribute("serviceAcceuil",serviceMaintenance);
        return "addmaintenance";
    }

    @PostMapping("/maintenance")
    public  String saveCategorie(Model model,
                                 @RequestParam("responsable")String responsable,
                                 @RequestParam("nom")String nom){
        ServiceMaintenance serviceMaintenance = new ServiceMaintenance();
        serviceMaintenance.setNom(nom);
        serviceMaintenance.setResponsable(responsable);
        serviceMaintenanceManager.createSerAcc(serviceMaintenance);
        List<ServiceMaintenance> serviceMaintenances = serviceMaintenanceManager.getAllCategorie2();
        model.addAttribute("serviceMaintenance",serviceMaintenances);
        return "redirect:/listemaintenance";
    }

    @GetMapping("/maintenance/edit/{id}")
    public String editCategorieForm(Model model, @PathVariable Integer id){
        Optional<ServiceMaintenance> serviceMaintenance = serviceMaintenanceManager.getCategorieById(id);
        model.addAttribute("serviceMaintenance",serviceMaintenance);
        model.addAttribute("id", id);
        return "editmaintenance";

    }
    @PostMapping("/maintenance/{id}")
    public String editCategorie(Model model,
                                @PathVariable Integer id,
                                @ModelAttribute("serviceAcceuil")ServiceMaintenance serviceMaintenanceex){
        Optional<ServiceMaintenance> serviceMaintenance = serviceMaintenanceManager.getCategorieById(id);
        serviceMaintenance.get().setNom(serviceMaintenanceex.getNom());
        serviceMaintenance.get().setResponsable(serviceMaintenanceex.getResponsable());
        serviceMaintenanceManager.updateServiceAcc(serviceMaintenance.get());
        return "redirect:/listemaintenance";
    }

    @GetMapping("/maintenance/{id}")
    public String deleteUser(@PathVariable Integer id){
        serviceMaintenanceManager.deleteById(id);
        return "redirect:/listemaintenance";
    }

}
