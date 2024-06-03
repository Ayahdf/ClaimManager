package com.example.gestiondesreclamations.dao.repositories;

import com.example.gestiondesreclamations.dao.entities.Produit;
import com.example.gestiondesreclamations.dao.entities.Service;
import com.example.gestiondesreclamations.dao.entities.ServiceMaintenance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceMaintenanceDAO extends JpaRepository<ServiceMaintenance,Integer> {
    Page<Produit> findByNomContaining(String keyword, Pageable pageable);
}
