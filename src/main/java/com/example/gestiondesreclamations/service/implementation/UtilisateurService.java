package com.example.gestiondesreclamations.service.implementation;

import com.example.gestiondesreclamations.dao.entities.Utilisateur;
import com.example.gestiondesreclamations.dao.repositories.UtilisateurDAO;
import com.example.gestiondesreclamations.service.UtilisateurManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class UtilisateurService implements UtilisateurManager {
    @Autowired
    private UtilisateurDAO utilisateurDAO;
    @Override
    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur) {
        if(utilisateurDAO.findByEmail(utilisateur.getEmail()).isPresent()){
            return utilisateurDAO.save(utilisateur);
        }
        else {
            System.out.println("Impossible d'ajouter l'utilisateur, email deja existant");
            return null;}
    }

    @Override
    public Utilisateur miseajourUtilisateur(Utilisateur utilisateur) {
        if (utilisateurDAO.existsById(utilisateur.getUserId())){
            return utilisateurDAO.save(utilisateur);
        }
        return null;
    }

    @Override
    public boolean supprimerUtilisateur(Utilisateur utilisateur) {
        if (utilisateurDAO.existsById(utilisateur.getUserId())){
            utilisateurDAO.delete(utilisateur);
            return true;
        }
        return false;
    }

    @Override
    public List<Utilisateur> listeUtilisateurs() {
        return utilisateurDAO.findAll();
    }

    @Override
    public Page<Utilisateur> getAllUser(String keyword, Pageable pageable) {
        return utilisateurDAO.findByNomContaining(keyword,pageable);
    }

    @Override
    public void createUser(Utilisateur newUser) {
        utilisateurDAO.save(newUser);
    }

    @Override
    public List<Utilisateur> getAllUser2() {
        return utilisateurDAO.findAll();
    }

    @Override
    public Utilisateur getUserById(Integer id) {
        return utilisateurDAO.findById(id).orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    }


    @Override
    public void updateUser(Utilisateur exUser) {
        utilisateurDAO.save(exUser);
    }

    @Override
    public void deleteById(Integer id) {
        utilisateurDAO.deleteById(id);
    }
}
