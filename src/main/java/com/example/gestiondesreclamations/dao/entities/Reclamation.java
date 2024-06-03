package com.example.gestiondesreclamations.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reclamation")

public class Reclamation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reclamationId;
    @Column(name = "Title")
    private String titre;
    @Column(name = "Description")
    private String description;

    //association avec utilisateur
    @ManyToOne
    private Utilisateur utilisateur;

    //association avec produit
    @ManyToOne
    private Produit produit;
    @ManyToOne
    private Service service;

//    @OneToMany(mappedBy = "reclamation", cascade = CascadeType.ALL)
//    private List<Document> documents;



}
