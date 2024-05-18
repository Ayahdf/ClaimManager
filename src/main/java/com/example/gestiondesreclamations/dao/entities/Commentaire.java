package com.example.gestiondesreclamations.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Comment")


public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentaireId;
    @Column(name = "Content")
    private String contenu;

    @ManyToOne
    private Utilisateur utilisateur;

    @ManyToOne
    private Produit produit;
}
