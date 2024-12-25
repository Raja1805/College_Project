package org.example.TrustProjects.controller;



import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin
public class JwtController {

//    @Autowired
//    private JwtService jwtService;

//    @PostMapping({"/authenticate"})
//    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
//        return jwtService.createJwtToken(jwtRequest);
//    }

    @GetMapping("/authenticationForGoogleLogin")
    public String getRequest(Principal user) {
        return "welcome to our NCVTE Portal";
    }
}
