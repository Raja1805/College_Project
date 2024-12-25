package org.example.TrustProjects.IService;

import org.example.TrustProjects.DTO.DataListDTO;
import org.example.TrustProjects.DTO.ResponseDTO;
import org.example.TrustProjects.entity.Role;

public interface IRoleService {
    DataListDTO getAllRole(int pageIndex, int pageSize, String search);

    ResponseDTO createRole(Role role);

    ResponseDTO updateRole(Role role);
}
