package com.example.gestiondesreclamations.service.implementation;

import com.example.gestiondesreclamations.dao.entities.Role;
import com.example.gestiondesreclamations.dao.repositories.RoleDAO;
import com.example.gestiondesreclamations.service.RoleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleService implements RoleManager {
    @Autowired
    private RoleDAO roleDAO;
    @Override
    public List<Role> listeRoles() {

        return roleDAO.findAll();
    }

    @Override
    public Role ajouterRole(Role role) {

        return roleDAO.save(role);
    }

    @Override
    public Role miseajourRole(Role role) {
        if (roleDAO.existsById(role.getRoleId()))
        {
            return roleDAO.save(role);
        }
        return null;
    }

    @Override
    public boolean supprimerRole(Role role) {

        if (roleDAO.existsById(role.getRoleId()))
        {
            roleDAO.save(role);
            return true;
        }
        return false;
    }
}
