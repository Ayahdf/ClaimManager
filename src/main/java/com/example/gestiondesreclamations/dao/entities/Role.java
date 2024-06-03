package com.example.gestiondesreclamations.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;
    @Column(name = "nameRole")
    private String nom;

    @OneToMany(mappedBy = "role",fetch = FetchType.EAGER)
    private Collection<Utilisateur> users = new ArrayList<>();

    @Override
    public String toString() {
        return  nom ;
    }
}

