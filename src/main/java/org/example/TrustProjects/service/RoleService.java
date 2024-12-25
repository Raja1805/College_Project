package org.example.TrustProjects.service;


import org.example.TrustProjects.DTO.DataListDTO;
import org.example.TrustProjects.DTO.ResponseDTO;
import org.example.TrustProjects.IService.IRoleService;
import org.example.TrustProjects.Repository.RoleRepository;
import org.example.TrustProjects.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private RoleRepository roleDao;

//    public Role createNewRole(Role role) {
//        return roleDao.save(role);
//    }




    @Override
    public DataListDTO getAllRole(int pageIndex, int pageSize, String search){
        DataListDTO result = new DataListDTO();
        Page<Map<String,Object>> rawResult = roleDao.getAllRole(PageRequest.of(pageIndex,pageSize), Optional.ofNullable(search).orElse(""));
        if (rawResult != null){
            result.setData(rawResult.getContent());
            result.setLength((int)rawResult.getTotalElements());
        }
        result.setStatus(true);
        return  result;
    }

    @Override
    public ResponseDTO createRole(Role role){
        ResponseDTO res = new ResponseDTO();
        roleDao.save(role);
        res.setStatus(true);
        res.setMessage("Role created success");
        return  res;
    }

    @Override
    public ResponseDTO updateRole(Role role){
        ResponseDTO res = new ResponseDTO();
        Role updateRole = roleDao.getOne(role.getRoleCode());
        if (role.getRoleCode() != null) {
            updateRole.setRoleCode(role.getRoleCode());
        }

        if (role.getRoleDescription() != null) {
            updateRole.setRoleDescription(role.getRoleDescription());
        }

        if(role.getRoleName() != null){
            updateRole.setRoleName(role.getRoleName());
        }

        roleDao.saveAndFlush(updateRole);
        res.setStatus(true);
        res.setMessage("Update Success");
        return res;
    }
}
