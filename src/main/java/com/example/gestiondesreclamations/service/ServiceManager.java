package com.example.gestiondesreclamations.service;


import com.example.gestiondesreclamations.dao.entities.Service;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface ServiceManager {
    Optional<Service> getServiceById(Integer id);

//    ServiceAcceuil findServiceById(Integer id);
//    Optional<Service> getServiceById(Integer produitId);
}
