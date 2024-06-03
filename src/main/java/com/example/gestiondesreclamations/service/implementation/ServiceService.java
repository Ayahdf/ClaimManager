package com.example.gestiondesreclamations.service.implementation;

import com.example.gestiondesreclamations.dao.entities.Service;
import com.example.gestiondesreclamations.dao.repositories.ServiceDAO;
import com.example.gestiondesreclamations.service.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceService implements ServiceManager {
    @Autowired
    ServiceDAO serviceDAO;
    @Override
    public Optional<Service> getServiceById(Integer id) {
        return serviceDAO.findById(id);
    }


//    @Autowired
//    private ServiceDAO serviceDAO;
//
//    @Override
//    public Optional<com.example.gestiondesreclamations.dao.entities.Service> getServiceById(Integer produitId) {
//        return serviceDAO.findById(produitId);
//    }
}
