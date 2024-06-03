package com.example.gestiondesreclamations.dao.repositories;

import com.example.gestiondesreclamations.dao.entities.Produit;
import com.example.gestiondesreclamations.dao.entities.Role;
import com.example.gestiondesreclamations.dao.entities.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceDAO extends JpaRepository<Service,Integer> {
    Page<Produit> findByResponsableContaining(String keyword, Pageable pageable);
}
