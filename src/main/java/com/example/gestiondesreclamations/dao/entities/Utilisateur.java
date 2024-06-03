package com.example.gestiondesreclamations.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data@AllArgsConstructor
@NoArgsConstructor
@Table(name = "UserTable")

public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    //    @Column(name = "name")
    private String nom;
    @Column(name = "login")
    private String email;
    @Column(name = "password")
    private String motDePasse;
//    @Column(name = "role")
//    private String role;

    @OneToMany(mappedBy = "utilisateur",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<Reclamation> reclamations;
    @OneToMany(mappedBy = "utilisateur",fetch  = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<Commentaire> commentaires;
//    @ManyToMany
//    private List<Role> roles;

    @ManyToOne
    private Role role;

    @Override
    public String toString() {
        return "User{id=" + userId + ", nom=" + nom + "}";
    }

    public String getRole1() {
        return role.getNom();
    }

    //    @Override
//    public String toString() {
//        return "Utilisateur{" +
//                "userId=" + userId +
//                ", nom='" + nom + '\'' +
//                ", email='" + email + '\'' +
//                ", motDePasse='" + motDePasse + '\'' +
//                '}';
//    }
}
