package org.example.TrustProjects.controller;

import org.example.TrustProjects.DTO.ChangePassword;
import org.example.TrustProjects.DTO.InstitutionLoginRequest;
import org.example.TrustProjects.DTO.LoginRequest;
import org.example.TrustProjects.DTO.ResponseDTO;
import org.example.TrustProjects.Repository.UserRepository;
import org.example.TrustProjects.entity.User;
import org.example.TrustProjects.service.UserDetailsServiceImpl;
import org.example.TrustProjects.service.UserService;
import org.example.TrustProjects.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @PostMapping("/signIn")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Optional<User> optionalUser = userRepository.findByUserName(loginRequest.getUserName());

        if (!optionalUser.isPresent()) {
            // User not found
            return new ResponseEntity<>("Username not found", HttpStatus.BAD_REQUEST);
        }

        User user = optionalUser.get();

        if (!authenticate(loginRequest.getUserName(), loginRequest.getUserPassword())) {
            // Incorrect password
            return new ResponseEntity<>("Incorrect password", HttpStatus.BAD_REQUEST);
        }

        // If user exists and password is correct
        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUserName());
        final String token = jwtUtil.generateToken(userDetails);

        ResponseDTO data = new ResponseDTO();
        data.setMessage("Login Successful! Welcome to ICVTE Portal " +
                Optional.ofNullable(user.getUserName()).orElse("") + " ");
        Map<String, Object> map = new HashMap<>();
        map.put("tokenType", "Bearer");
        map.put("token", token);
        data.setData(map);

        return new ResponseEntity<>(data, HttpStatus.OK);
    }


    private boolean authenticate(String userName, String userPassword) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
            return true;
        } catch (DisabledException e) {
            //throw new Exception("USER_DISABLED", e);
            return false;
        } catch (BadCredentialsException e) {
            // throw new Exception("INVALID_CREDENTIALS", e);
            return false;
        }
    }

    //InstitutionLogin
    @PostMapping("/InstitutionSignIn")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody InstitutionLoginRequest institutionLoginRequest) {

        Optional<User> optionalUser = userRepository.findByUserName(institutionLoginRequest.getInstitutionUserName());

        if (!optionalUser.isPresent()) {
            // User not found
            return new ResponseEntity<>("Username not found", HttpStatus.BAD_REQUEST);
        }

        User user = optionalUser.get();

        if (!authenticate(institutionLoginRequest.getInstitutionUserName(), institutionLoginRequest.getInstitutionPassword())) {
            // Incorrect password
            return new ResponseEntity<>("Incorrect password", HttpStatus.BAD_REQUEST);
        }

        // If user exists and password is correct
        final UserDetails userDetails = userDetailsService.loadUserByUsername(institutionLoginRequest.getInstitutionUserName());
        final String token = jwtUtil.generateToken(userDetails);

        ResponseDTO data = new ResponseDTO();
        data.setMessage("Login Successful! Welcome to ICVTE Portal " +
                Optional.ofNullable(user.getUserName()).orElse("") + " ");
        Map<String, Object> map = new HashMap<>();
        map.put("tokenType", "Bearer");
        map.put("token", token);
        data.setData(map);

        return new ResponseEntity<>(data, HttpStatus.OK);
    }


    private boolean authenticateForInstitutionLogin(String userName, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
            return true;
        } catch (DisabledException e) {
            //throw new Exception("USER_DISABLED", e);
            return false;
        } catch (BadCredentialsException e) {
            // throw new Exception("INVALID_CREDENTIALS", e);
            return false;
        }
    }


    @PostMapping("/changePassword")
    public ResponseEntity<?> changePassword(@Valid @RequestBody ChangePassword changePasswordRequest) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();

        // Retrieve the institution by their code
        Optional<User> optionalInstitution = userRepository.findByUserName(principal.getUsername());

        if (!optionalInstitution.isPresent()) {
            // Institution not found
            return new ResponseEntity<>("Institution not found", HttpStatus.NOT_FOUND);
        }

        User institution = optionalInstitution.get();

        // Verify the old password
        if (!passwordEncoder.matches(changePasswordRequest.getOldPassword(), institution.getPassword())) {
            // Old password does not match
            return new ResponseEntity<>("Old password is incorrect", HttpStatus.BAD_REQUEST);
        }

        // Update the password to the new one, after encoding it
        institution.setPassword(passwordEncoder.encode(changePasswordRequest.getNewPassword()));

        // Save the updated institution
        userRepository.save(institution);

        // Return success response
        return new ResponseEntity<>("Password changed successfully", HttpStatus.OK);
    }

    @PostMapping("/signOut")
    public ResponseEntity<?> logout() {
        SecurityContextHolder.clearContext();
        return ResponseEntity.ok("Logged out successfully!");
    }

}

