package com.example.gestiondesreclamations.service;

import com.example.gestiondesreclamations.dao.entities.ServiceAcceuil;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ServiceAcceuilManager {
    void createSerAcc(ServiceAcceuil serviceAcceuil);

    List<ServiceAcceuil> getAllCategorie2();

    Optional<ServiceAcceuil> getCategorieById(Integer id);

    void updateServiceAcc(ServiceAcceuil serviceAcceuil);

    void deleteById(Integer id);



    Page<ServiceAcceuil> listeReclamations(int page, int taille);

    Optional<ServiceAcceuil> findServiceById(Integer id);
}
