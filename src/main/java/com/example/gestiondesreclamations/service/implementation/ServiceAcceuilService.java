package com.example.gestiondesreclamations.service.implementation;

import com.example.gestiondesreclamations.dao.entities.ServiceAcceuil;
import com.example.gestiondesreclamations.dao.repositories.ServiceAcceuilDAO;
import com.example.gestiondesreclamations.service.ServiceAcceuilManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceAcceuilService implements ServiceAcceuilManager {
    @Autowired
    private ServiceAcceuilDAO serviceAcceuilDAO;
    @Override
    public void createSerAcc(ServiceAcceuil serviceAcceuil) {
        serviceAcceuilDAO.save(serviceAcceuil);
    }

    @Override
    public List<ServiceAcceuil> getAllCategorie2() {
        return serviceAcceuilDAO.findAll();
    }

    @Override
    public Optional<ServiceAcceuil> getCategorieById(Integer id) {
        return serviceAcceuilDAO.findById(id);
    }

    @Override
    public void updateServiceAcc(ServiceAcceuil serviceAcceuil) {
        serviceAcceuilDAO.save(serviceAcceuil);
    }

    @Override
    public void deleteById(Integer id) {
        serviceAcceuilDAO.deleteById(id);
    }

    @Override
    public Page<ServiceAcceuil> listeReclamations(int page, int taille) {
        return serviceAcceuilDAO.findAll(PageRequest.of(page,taille));
    }

    @Override
    public Optional<ServiceAcceuil> findServiceById(Integer id) {
        return serviceAcceuilDAO.findById(id);
    }


}
