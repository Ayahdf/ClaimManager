package com.example.gestiondesreclamations.web;

import com.example.gestiondesreclamations.service.RoleManager;
import com.example.gestiondesreclamations.service.dto.RoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller

public class RoleControlleur {
    @Autowired
    RoleManager roleManager;

    @GetMapping("/rolelist")
    public String roleList(Model model, @RequestParam(required = false) String search) {
        List<RoleDTO> roleDTOList = roleManager.getAllRole();

        model.addAttribute("roles", roleDTOList);
        return "rolelist";
    }

    @GetMapping("/role/new")
    public String newRoleForm(Model model) {
        model.addAttribute("role", new RoleDTO());
        return "roleform";
    }
}
