package com.example.gestiondesreclamations.dao.repositories;

import com.example.gestiondesreclamations.dao.entities.Service;
import com.example.gestiondesreclamations.dao.entities.ServiceApresVente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceApresVenteDAO extends JpaRepository<ServiceApresVente,Integer> {
}
