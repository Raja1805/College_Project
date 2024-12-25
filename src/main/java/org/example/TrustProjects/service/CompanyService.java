package org.example.TrustProjects.service;

import org.example.TrustProjects.DTO.DataListDTO;
import org.example.TrustProjects.DTO.ResponseDTO;
import org.example.TrustProjects.IService.ICompanyService;
import org.example.TrustProjects.Repository.CompanyRepository;
import org.example.TrustProjects.entity.Company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.util.Map;
import java.util.Optional;


@Service
public class CompanyService implements ICompanyService {

        @Autowired
        CompanyRepository companyRepository;


        @Override
        public DataListDTO getAllCompany(int pageIndex, int pageSize, String search){
            DataListDTO result = new DataListDTO();
            Page<Map<String,Object>> rawResult = companyRepository.getAllCompany(PageRequest.of(pageIndex,pageSize), Optional.ofNullable(search).orElse(""));
            if (rawResult != null){
                result.setData(rawResult.getContent());
                result.setLength((int)rawResult.getTotalElements());
            }
            result.setStatus(true);
            return  result;
        }

        @Override
        public ResponseDTO createCompany(Company company){
            ResponseDTO res = new ResponseDTO();
            companyRepository.save(company);
            res.setStatus(true);
            res.setMessage("Company created success");
            return  res;
        }

        @Override
        public ResponseDTO updateCompany(Company company){
            ResponseDTO res = new ResponseDTO();
            Company updateCompany = companyRepository.getOne(company.getCompanyCode());
            if (company.getCompanyCode() != null) {
                updateCompany.setCompanyCode(company.getCompanyCode());
            }

            if (company.getCompanyName() != null) {
                updateCompany.setCompanyName(company.getCompanyName());
            }

            if(company.getCreatedDate() != null){
                updateCompany.setCreatedDate(company.getCreatedDate());
            }

            companyRepository.saveAndFlush(updateCompany);
            res.setStatus(true);
            res.setMessage("Update Success");
            return res;
        }
}
