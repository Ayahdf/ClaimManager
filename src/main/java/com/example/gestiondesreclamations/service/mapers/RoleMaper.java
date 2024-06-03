package com.example.gestiondesreclamations.service.mapers;

import com.example.gestiondesreclamations.dao.entities.Role;
import com.example.gestiondesreclamations.service.dto.RoleDTO;
import com.example.gestiondesreclamations.service.dto.RoleDTOADD;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

@Component
public class RoleMaper {
    private ModelMapper modelMapper = new ModelMapper();
    public RoleDTO fromRoleteToRoleDTO(Role role){
        return modelMapper.map(role, RoleDTO.class);
    }

    public Role fromRoleDTOToRole(RoleDTO compteDto){
        return modelMapper.map(compteDto, Role.class);
    }

    public RoleDTOADD fromRoleToRoleDTOADD(Role compte){
        return modelMapper.map(compte, RoleDTOADD.class);
    }

    public Role fromRoleDTOADDToRole(RoleDTOADD compteDTOADD){
        return modelMapper.map(compteDTOADD, Role.class);
    }
}
