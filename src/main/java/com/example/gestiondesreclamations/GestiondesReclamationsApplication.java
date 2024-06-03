package com.example.gestiondesreclamations;

import com.example.gestiondesreclamations.dao.entities.Produit;
import com.example.gestiondesreclamations.dao.entities.Role;
import com.example.gestiondesreclamations.dao.entities.Utilisateur;
import com.example.gestiondesreclamations.dao.repositories.RoleDAO;
import com.example.gestiondesreclamations.dao.repositories.UtilisateurDAO;
//import com.example.gestiondesreclamations.service.UtilisateurManager;
import com.example.gestiondesreclamations.service.ProduitManager;
import com.example.gestiondesreclamations.service.UtilisateurManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestiondesReclamationsApplication implements CommandLineRunner {
    @Autowired

    private UtilisateurManager utilisateurManager;
    @Autowired
    private ProduitManager produitManager;
    @Autowired
    private RoleDAO roleDAO;
    @Autowired
    private UtilisateurDAO utilisateurDAO;

    public static void main(String[] args) {
        SpringApplication.run(GestiondesReclamationsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


//        Role roleUser = new Role();
//        roleUser.setNom("user");
//        roleDAO.save(roleUser);
//        Role roleAdmin = new Role();
//        roleAdmin.setNom("admin");
//        roleDAO.save(roleAdmin);
//        Utilisateur adminManager = new Utilisateur();
//        Role role = new Role();
//        role.setNom("admin");
//        roleDAO.save(role);
//        adminManager.setRole(role);
//        adminManager.setNom("Aya");
//        adminManager.setMotDePasse("123");
//        adminManager.setEmail("admin@manager");
//        utilisateurDAO.save(adminManager);



        //System.out.println(utilisateurManager.listeUtilisateurs());
        System.out.println("hello its working");


//        Produit produit = new Produit();
//        produit.setNom("prdt1");
//        produit.setDescription("ceci est le produit 1");
//        produitManager.ajouterProduit(produit);
    }
}
