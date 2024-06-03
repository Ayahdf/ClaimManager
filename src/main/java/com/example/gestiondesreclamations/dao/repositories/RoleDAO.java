package com.example.gestiondesreclamations.dao.repositories;

import com.example.gestiondesreclamations.dao.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<Role,Long> {
//    Role findByNom(String user);

    Role findRoleByNom(String user);
}
