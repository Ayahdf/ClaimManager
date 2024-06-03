package com.example.gestiondesreclamations.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")


public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;
    @Column(name = "name")
    private String nom;
    @Column(name = "description")
    private String description;

    //association avec reclamation
    @OneToMany(mappedBy = "produit")
    private List<Reclamation> reclamations;
    //association avec produit
    @OneToMany(mappedBy = "produit", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Commentaire> commentaires;

}
