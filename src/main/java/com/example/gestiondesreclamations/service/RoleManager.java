package com.example.gestiondesreclamations.service;

import com.example.gestiondesreclamations.dao.entities.Role;

import java.util.List;

public interface RoleManager {
    public List<Role> listeRoles();
    public Role ajouterRole(Role role);
    public Role miseajourRole(Role role);
    public boolean supprimerRole(Role role);

}
