package com.kamatchibotique.application.service.impl;

import com.kamatchibotique.application.entity.RoleEntity;
import com.kamatchibotique.application.exception.ServiceException;
import com.kamatchibotique.application.repository.RoleRepository;
import com.kamatchibotique.application.service.RoleService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Override
    public RoleEntity createRole(RoleEntity roleEntity) {
        return roleRepository.save(roleEntity);
    }

    @Override
    public List<RoleEntity> getListOfRoles() {
        return roleRepository.findAll();
    }

    @Override
    public RoleEntity getRoleById(Long id) {
        return roleRepository.findById(id).orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND, "Role was not found given id"));
    }

    @Override
    public RoleEntity updateRole(Long id, RoleEntity roleEntity) {

        RoleEntity role = roleRepository.findById(id).orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND, "Role was not found given id"));
        role.setRoleDescription(roleEntity.getRoleDescription());
        role.setName(roleEntity.getName());

        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(Long id) {
        RoleEntity role = roleRepository.findById(id).orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND, "Role was not found given id"));
        roleRepository.delete(role);
    }
}
