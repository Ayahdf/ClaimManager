package com.example.gestiondesreclamations.web;

import com.example.gestiondesreclamations.dao.entities.*;
import com.example.gestiondesreclamations.service.ServiceAcceuilManager;
import com.example.gestiondesreclamations.service.ServiceManager;
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
public class ServiceAcceuilControlleur {
    @Autowired
    private ServiceAcceuilManager serviceAcceuilManager;



    @GetMapping("/listeacceuil")
    public String listeReclamations(Model model,
                                    @RequestParam(name = "page", defaultValue = "0") int page,
                                    @RequestParam(name = "taille", defaultValue = "5") int taille) {
        Page<ServiceAcceuil> pageServiceAcceuils = serviceAcceuilManager.listeReclamations(page, taille);

        model.addAttribute("serviceAcceuils", pageServiceAcceuils.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", pageServiceAcceuils.getTotalPages());

        return "acceuil";
    }

    @GetMapping("/acceuil/new")
    public String addCategorie (Model model){
        ServiceAcceuil serviceAcceuil = new ServiceAcceuil();
        model.addAttribute("serviceAcceuil",serviceAcceuil);
        return "addacceuil";
    }

    @PostMapping("acceuil")
    public  String saveCategorie(Model model,
                                 @RequestParam("responsable")String responsable,
                                 @RequestParam("poste")String poste){
        ServiceAcceuil serviceAcceuil = new ServiceAcceuil();
        serviceAcceuil.setPoste(poste);
        serviceAcceuil.setResponsable(responsable);
        serviceAcceuilManager.createSerAcc(serviceAcceuil);
        List<ServiceAcceuil> serviceAcceuils = serviceAcceuilManager.getAllCategorie2();
        model.addAttribute("serviceAcceuil",serviceAcceuils);
        return "redirect:/listeacceuil";
    }

    @GetMapping("/acceuil/edit/{id}")
    public String editCategorieForm(Model model, @PathVariable Integer id){
        Optional<ServiceAcceuil> serviceAcceuil = serviceAcceuilManager.getCategorieById(id);
        model.addAttribute("serviceAcceuil",serviceAcceuil);
        model.addAttribute("id", id);
        return "editacceuil";

    }
    @PostMapping("/acceuil/{id}")
    public String editCategorie(Model model,
                                @PathVariable Integer id,
                                @ModelAttribute("serviceAcceuil")ServiceAcceuil serviceAcceuilex){
        Optional<ServiceAcceuil> serviceAcceuil = serviceAcceuilManager.getCategorieById(id);
        serviceAcceuil.get().setPoste(serviceAcceuilex.getPoste());
        serviceAcceuil.get().setResponsable(serviceAcceuilex.getResponsable());
        serviceAcceuilManager.updateServiceAcc(serviceAcceuil.get());
        return "redirect:/listeacceuil";
    }

    @GetMapping("/acceuil/{id}")
    public String deleteUser(@PathVariable Integer id){
        serviceAcceuilManager.deleteById(id);
        return "redirect:/listeacceuil";
    }






}
