package com.example.gestiondesreclamations.service;

import com.example.gestiondesreclamations.dao.entities.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UtilisateurManager {
    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur);
    public Utilisateur miseajourUtilisateur(Utilisateur utilisateur);
    public boolean supprimerUtilisateur(Utilisateur utilisateur);
    public List<Utilisateur> listeUtilisateurs();

    Page<Utilisateur> getAllUser(String keyword, Pageable pageable);

    void createUser(Utilisateur newUser);

    List<Utilisateur> getAllUser2();

    Utilisateur getUserById(Integer id);

    void updateUser(Utilisateur exUser);

    void deleteById(Integer id);
}
