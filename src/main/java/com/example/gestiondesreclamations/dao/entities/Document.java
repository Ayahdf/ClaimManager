package com.example.gestiondesreclamations.dao.entities;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data@AllArgsConstructor@NoArgsConstructor
@Table(name = "Document")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "file_name")
    private String nom_fichier;
    @Column(name = "path")
    private String chemin;
    @ManyToOne
    private Reclamation reclamation;

}
