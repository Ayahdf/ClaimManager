package com.example.gestiondesreclamations.service.implementation;

import com.example.gestiondesreclamations.dao.entities.ServiceApresVente;
import com.example.gestiondesreclamations.dao.repositories.ServiceApresVenteDAO;
import com.example.gestiondesreclamations.service.ServiceApresVenteManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ServiceApresVenteService implements ServiceApresVenteManager {
    @Autowired
    private ServiceApresVenteDAO serviceApresVenteDAO;

    @Override
    public Page<ServiceApresVente> listeReclamations(int page, int taille) {
        return serviceApresVenteDAO.findAll(PageRequest.of(page,taille));
    }

    @Override
    public void createSerAcc(ServiceApresVente serviceApresVente) {
        serviceApresVenteDAO.save(serviceApresVente);
    }

    @Override
    public List<ServiceApresVente> getAllCategorie2() {
        return serviceApresVenteDAO.findAll();
    }

    @Override
    public Optional<ServiceApresVente> getCategorieById(Integer id) {
        return serviceApresVenteDAO.findById(id);
    }

    @Override
    public void updateServiceAcc(ServiceApresVente serviceApresVente) {
        serviceApresVenteDAO.save(serviceApresVente);
    }

    @Override
    public void deleteById(Integer id) {
        serviceApresVenteDAO.deleteById(id);
    }
}
