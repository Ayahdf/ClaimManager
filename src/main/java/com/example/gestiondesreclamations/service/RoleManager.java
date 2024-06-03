package com.example.gestiondesreclamations.service;

import com.example.gestiondesreclamations.dao.entities.Role;
import com.example.gestiondesreclamations.service.dto.RoleDTO;

import java.util.List;

public interface RoleManager {
    List<RoleDTO> getAllRole();

    Role findRoleByNom(String user);
//    public List<Role> listeRoles();
//    public Role ajouterRole(Role role);
//    public Role miseajourRole(Role role);
//    public boolean supprimerRole(Role role);

}
