package com.example.gestiondesreclamations.service.implementation;

import com.example.gestiondesreclamations.dao.entities.Produit;
import com.example.gestiondesreclamations.dao.entities.ServiceMaintenance;
import com.example.gestiondesreclamations.dao.repositories.ServiceDAO;
import com.example.gestiondesreclamations.dao.repositories.ServiceMaintenanceDAO;
import com.example.gestiondesreclamations.service.ServiceMaintenanceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceMaintenanceService implements ServiceMaintenanceManager {
    @Autowired
    ServiceMaintenanceDAO serviceMaintenanceDAO;
    @Autowired
    ServiceDAO serviceDAO;

    @Override
    public Page<Produit> getAll(String keyword, Pageable pageable) {
        return serviceMaintenanceDAO.findByNomContaining(keyword,pageable);
    }

    @Override
    public Page<ServiceMaintenance> listeReclamations(int page, int taille) {
        return serviceMaintenanceDAO.findAll(PageRequest.of(page,taille));
    }

    @Override
    public void createSerAcc(ServiceMaintenance serviceMaintenance) {
        serviceMaintenanceDAO.save(serviceMaintenance);
    }

    @Override
    public List<ServiceMaintenance> getAllCategorie2() {
        return serviceMaintenanceDAO.findAll();
    }

    @Override
    public Optional<ServiceMaintenance> getCategorieById(Integer id) {
        return serviceMaintenanceDAO.findById(id);
    }

    @Override
    public void updateServiceAcc(ServiceMaintenance serviceMaintenance) {
        serviceMaintenanceDAO.save(serviceMaintenance);
    }

    @Override
    public void deleteById(Integer id) {
        serviceMaintenanceDAO.deleteById(id);
    }

    @Override
    public Optional<ServiceMaintenance> findServiceById(Integer id) {
        return serviceMaintenanceDAO.findById(id);
    }
}
