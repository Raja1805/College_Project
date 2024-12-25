package org.example.TrustProjects.controller;

import org.example.TrustProjects.DTO.ResponseDTO;
import org.example.TrustProjects.IService.IUserService;
import org.example.TrustProjects.Repository.UserRepository;
import org.example.TrustProjects.service.UserService;
import org.example.TrustProjects.entity.User;
import org.example.TrustProjects.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import java.io.IOException;


@RestController
//@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private  JwtUtil jwtUtil;

    @Autowired
    IUserService iUserService;

    @PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    }

    @PostMapping({"signUp"})
    public User registerNewUser(@RequestBody User user) throws MessagingException, IOException {
        return userService.registerNewUser(user);
    }

    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin() {
        return "This URL is only accessible to the admin";
    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasRole('User')")
    public String forUser() {
        return "This URL is only accessible to the user";
    }



//    @GetMapping("/list")
//    public ResponseEntity<DataListDTO> getAllUsers(@RequestParam("pageIndex") int pageIndex, @RequestParam("pageSize") int pageSize, String search){
//        DataListDTO list = iUserService.getAllUsers(pageIndex,pageSize,search);
//        return new ResponseEntity<DataListDTO>(list, HttpStatus.OK);
//    }


    @PutMapping
    public ResponseEntity<ResponseDTO> updateUser(@RequestBody User user){
        ResponseDTO res = iUserService.updateUser(user);
        if(!res.isStatus()){
            return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>(res,HttpStatus.OK);
    }

}




