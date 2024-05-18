package com.example.gestiondesreclamations.service;

import com.example.gestiondesreclamations.dao.entities.Utilisateur;

import java.util.List;

public interface UtilisateurManager {
    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur);
    public Utilisateur miseajourUtilisateur(Utilisateur utilisateur);
    public boolean supprimerUtilisateur(Utilisateur utilisateur);
    public List<Utilisateur> listeUtilisateurs();
}
