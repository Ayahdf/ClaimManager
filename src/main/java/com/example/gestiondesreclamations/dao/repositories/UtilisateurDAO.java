package com.example.gestiondesreclamations.dao.repositories;

import com.example.gestiondesreclamations.dao.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UtilisateurDAO extends JpaRepository<Utilisateur,Long> {

    public Optional<Utilisateur> findByEmail(String email);
}
