package com.example.gestiondesreclamations.web;

import com.example.gestiondesreclamations.dao.entities.Role;
import com.example.gestiondesreclamations.dao.entities.Utilisateur;
import com.example.gestiondesreclamations.service.RoleManager;
import com.example.gestiondesreclamations.service.UtilisateurManager;
import com.example.gestiondesreclamations.service.dto.RoleDTO;
import com.example.gestiondesreclamations.service.mapers.RoleMaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UtilisateurController {
    @Autowired
    private UtilisateurManager utilisateurManager;
    @Autowired
    private RoleManager roleManager;
    @Autowired
    private RoleMaper roleMaper;

    @GetMapping("/user")
    public String ListUser(Model model,
                           @RequestParam(name = "page", defaultValue = "0" ) int page,
                           @RequestParam(name = "taille", defaultValue = "6" ) int taille,
                           @RequestParam(name = "search", defaultValue = "") String keyword) {
        Pageable pageable = PageRequest.of(page, taille);
        Page<Utilisateur> users = utilisateurManager.getAllUser(keyword,pageable);
        model.addAttribute("user", users);
        int[] pages = new int[users.getTotalPages()];
        for (int i = 0; i < pages.length; i++) {
            pages[i] = i;
        }
        model.addAttribute("pages" , pages);
        model.addAttribute("currentpages",page);
        return "userList";
    }

    @GetMapping("/user/new")
    public String creatUser(Model model){
        Utilisateur user=new Utilisateur();
        model.addAttribute("user",user);
        return "addUser";
    }

    @PostMapping("/user")
    public String saveUser(Model model,
                           @RequestParam("nom") String nom,
//                           @RequestParam("adress") String adress,
                           @RequestParam("email") String email,
                           @RequestParam("mdps") String mdps
    ) {
        System.out.println("Nom: " + nom);
//        System.out.println("Adresse: " + adress);
        System.out.println("Email: " + email);
        System.out.println("mdps: " + mdps);
        // Récupérer le rôle "user" depuis la base de données
        Role userRole = roleManager.findRoleByNom("user");


        Utilisateur newUser = new Utilisateur();


        // Sauvegardez votre nouvel utilisateur
        newUser.setNom(nom);
//        newUser.setAdress(adress);
        newUser.setEmail(email);
        newUser.setMotDePasse(mdps);
        // Assigner le rôle "user" à l'utilisateur
        newUser.setRole(userRole);
        utilisateurManager.createUser(newUser);

        List<Utilisateur> users = utilisateurManager.getAllUser2();
        model.addAttribute("user", users);
        return "redirect:/login";
    }

    @GetMapping("/userad/new")
    public String creatUserad(Model model){
        Utilisateur user=new Utilisateur();
        model.addAttribute("user",user);
        return "addUser";
    }
    @PostMapping("/userad")
    public String saveUserAdd(Model model,
                              @RequestParam("nom") String nom,
//                           @RequestParam("adress") String adress,
                              @RequestParam("email") String email,
                              @RequestParam("mdps") String mdps
    ) {
        System.out.println("Nom: " + nom);
//        System.out.println("Adresse: " + adress);
        System.out.println("Email: " + email);
        System.out.println("mdps: " + mdps);
        // Récupérer le rôle "user" depuis la base de données
        Role userRole = roleManager.findRoleByNom("user");


        Utilisateur newUser = new Utilisateur();


        // Sauvegardez votre nouvel utilisateur
        newUser.setNom(nom);
//        newUser.setAdress(adress);
        newUser.setEmail(email);
        newUser.setMotDePasse(mdps);
        // Assigner le rôle "user" à l'utilisateur
        newUser.setRole(userRole);
        utilisateurManager.createUser(newUser);

        List<Utilisateur> users = utilisateurManager.getAllUser2();
        model.addAttribute("user", users);
        return "redirect:/user";
    }
    @GetMapping("/user/edit/{id}")
    public String edditUserForm(Model model, @PathVariable Integer id){
        model.addAttribute("user",utilisateurManager.getUserById(id));
//        Role role = new Role();
//        model.addAttribute("role",roleManager.getAllRole());

        return "editUser";
    }

    @PostMapping("/user/{id}")
    public String edditUser(Model model,
                            @PathVariable Integer id,
                            @ModelAttribute("user") Utilisateur user){
        Utilisateur exUser = (Utilisateur) utilisateurManager.getUserById(id);
        exUser.setUserId(id);
//        exUser.setAdress(user.getAdress());
        exUser.setNom(user.getNom());
//        Role role = new Role();
//        role = roleManager.findRoleByNom(user.getRole1());
//        role = roleManager.findRoleByNom(String.valueOf(user.getRole()));
//        exUser.setRole(role);
        exUser.setEmail(user.getEmail());
        utilisateurManager.updateUser(exUser);
        List<Utilisateur> users = utilisateurManager.getAllUser2();
        model.addAttribute("user", users);
        return "redirect:/user";
    }

    @GetMapping("/user/{id}")
    public String deleteUser(@PathVariable Integer id){
        utilisateurManager.deleteById(id);
        return "redirect:/user";
    }

}
