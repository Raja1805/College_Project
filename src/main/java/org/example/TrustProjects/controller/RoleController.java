package org.example.TrustProjects.controller;


import org.example.TrustProjects.DTO.DataListDTO;
import org.example.TrustProjects.DTO.ResponseDTO;
import org.example.TrustProjects.IService.IRoleService;
import org.example.TrustProjects.entity.Role;
import org.example.TrustProjects.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    IRoleService iRoleService;

//    @PostMapping({"/createNewRole"})
//    public Role createNewRole(@RequestBody Role role) {
//        return roleService.createNewRole(role);
//    }

    @GetMapping("/list")
    public ResponseEntity<DataListDTO> getAllRole(@RequestParam("pageIndex") int pageIndex, @RequestParam("pageSize") int pageSize, String search){
        DataListDTO list = iRoleService.getAllRole(pageIndex,pageSize,search);
        return new ResponseEntity<DataListDTO>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> createRole(@RequestBody Role role){
        ResponseDTO res = iRoleService.createRole(role);
        if(!res.isStatus()){
            return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>(res,HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<ResponseDTO> updateRole(@RequestBody Role role){
        ResponseDTO res = iRoleService.updateRole(role);
        if(!res.isStatus()){
            return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>(res,HttpStatus.OK);
    }
}
