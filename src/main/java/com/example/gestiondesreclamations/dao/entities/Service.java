package com.example.gestiondesreclamations.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_produit", discriminatorType = DiscriminatorType.STRING)

public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    private String responsable;
    @OneToMany(mappedBy = "service",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reclamation> reclamations;
}
