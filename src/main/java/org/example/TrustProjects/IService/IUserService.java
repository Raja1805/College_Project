package org.example.TrustProjects.IService;

import org.example.TrustProjects.DTO.DataListDTO;
import org.example.TrustProjects.DTO.ResponseDTO;
import org.example.TrustProjects.entity.User;

public interface IUserService {
//    DataListDTO getAllUsers(int pageIndex, int pageSize, String search);

    ResponseDTO updateUser(User user);
}
