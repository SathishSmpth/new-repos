package com.kamatchibotique.application.service;



import com.kamatchibotique.application.entity.RoleEntity;

import java.util.List;

public interface RoleService {
    RoleEntity createRole(RoleEntity roleEntity);

    List<RoleEntity> getListOfRoles();

    RoleEntity getRoleById(Long id);

    RoleEntity updateRole(Long id, RoleEntity roleEntity);

    void deleteRole(Long id);
}
