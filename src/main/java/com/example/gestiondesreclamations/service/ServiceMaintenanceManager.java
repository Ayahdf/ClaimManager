package com.example.gestiondesreclamations.service;

import com.example.gestiondesreclamations.dao.entities.Produit;
import com.example.gestiondesreclamations.dao.entities.ServiceMaintenance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ServiceMaintenanceManager {


    Page<Produit> getAll(String keyword, Pageable pageable) ;

    Page<ServiceMaintenance> listeReclamations(int page, int taille);

    void createSerAcc(ServiceMaintenance serviceMaintenance);

    List<ServiceMaintenance> getAllCategorie2();


    Optional<ServiceMaintenance> getCategorieById(Integer id);

    void updateServiceAcc(ServiceMaintenance serviceMaintenance);

    void deleteById(Integer id);

    Optional<ServiceMaintenance> findServiceById(Integer id);
}
