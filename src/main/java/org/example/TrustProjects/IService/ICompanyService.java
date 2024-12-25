package org.example.TrustProjects.IService;

import org.example.TrustProjects.DTO.DataListDTO;
import org.example.TrustProjects.DTO.ResponseDTO;
import org.example.TrustProjects.entity.Company;

public interface ICompanyService {
    DataListDTO getAllCompany(int pageIndex, int pageSize, String search);

    ResponseDTO createCompany(Company company);

    ResponseDTO updateCompany(Company company);
}
