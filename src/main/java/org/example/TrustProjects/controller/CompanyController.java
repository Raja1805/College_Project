package org.example.TrustProjects.controller;
import org.example.TrustProjects.DTO.DataListDTO;
import org.example.TrustProjects.DTO.ResponseDTO;
import org.example.TrustProjects.IService.ICompanyService;
import org.example.TrustProjects.entity.Company;
import org.example.TrustProjects.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

 

@RestController
@RequestMapping("/company")
public class CompanyController {


    @Autowired
    ICompanyService iCompanyService;

    @Autowired
    CompanyService companyService;


    @GetMapping("/list")
    public ResponseEntity<DataListDTO> getAllCompany(@RequestParam("pageIndex") int pageIndex, @RequestParam("pageSize") int pageSize, String search){
        DataListDTO list = iCompanyService.getAllCompany(pageIndex,pageSize,search);
        return new ResponseEntity<DataListDTO>(list, HttpStatus.OK);
    }

    

    @PostMapping
    public ResponseEntity<ResponseDTO> createCompany(@RequestBody Company company){
        ResponseDTO res = iCompanyService.createCompany(company);
        if(!res.isStatus()){
            return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>(res,HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<ResponseDTO> updateCompany(@RequestBody Company company){
        ResponseDTO res = iCompanyService.updateCompany(company);
        if(!res.isStatus()){
            return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>(res,HttpStatus.OK);
    }
}

