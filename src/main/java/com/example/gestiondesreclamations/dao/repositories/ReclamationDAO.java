package com.example.gestiondesreclamations.dao.repositories;

import com.example.gestiondesreclamations.dao.entities.Reclamation;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReclamationDAO extends JpaRepository<Reclamation,Long> {
    List<Reclamation> findByTitre (String Titre);
}
