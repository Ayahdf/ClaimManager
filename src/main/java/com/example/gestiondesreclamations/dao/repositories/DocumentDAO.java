package com.example.gestiondesreclamations.dao.repositories;

import com.example.gestiondesreclamations.dao.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DocumentDAO extends JpaRepository<Document, Long> {
}
