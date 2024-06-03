package com.example.gestiondesreclamations.service.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTOADD {
    private Integer roleId;
    private String nom;
}
