package com.example.gestiondesreclamations.service;

import com.example.gestiondesreclamations.dao.entities.ServiceApresVente;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ServiceApresVenteManager {
    Page<ServiceApresVente> listeReclamations(int page, int taille);

    void createSerAcc(ServiceApresVente serviceApresVente);

    List<ServiceApresVente> getAllCategorie2();


    Optional<ServiceApresVente> getCategorieById(Integer id);

    void updateServiceAcc(ServiceApresVente serviceApresVente);

    void deleteById(Integer id);
}
