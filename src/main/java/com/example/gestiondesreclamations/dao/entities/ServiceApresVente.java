package com.example.gestiondesreclamations.dao.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("apresvente")
public class ServiceApresVente extends Service {
    private String numeroTelephone;
}
