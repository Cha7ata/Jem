package com.jem.jeeniso.controller;


import com.jem.jeeniso.dto.auth.AuthenticationRequest;
import com.jem.jeeniso.dto.auth.AuthenticationResponse;
import com.jem.jeeniso.model.auth.ExtendedUser;
import com.jem.jeeniso.services.auth.ApplicationUserDetailsService;
import com.jem.jeeniso.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.jem.jeeniso.utils.Constants.AUTHENTICATION_ENDPOINT;

@RestController
@RequestMapping(AUTHENTICATION_ENDPOINT)
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ApplicationUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        System.out.println("**************************************");
        System.out.println("**************************************");
        System.out.println("**************************************");
        System.out.println("**************************************");
        System.out.println("**************************************");
        System.out.println(request.getLogin());
        System.out.println(request.getPassword());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin(),
                        request.getPassword()
                )
        );
        System.out.println("**************************************");
        System.out.println("**************************************");
        System.out.println("**************************************");
        System.out.println("**************************************");
        System.out.println("**************************************");

        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getLogin());
        System.out.println("**************************************");
        System.out.println("**************************************");
        System.out.println("**************************************");
        System.out.println("**************************************");
        System.out.println(userDetails);
        final String jwt = jwtUtil.generateToken((ExtendedUser) userDetails);
        System.out.println("**************************************");
        System.out.println("**************************************");
        System.out.println("**************************************");
        System.out.println("**************************************");
        System.out.println("**************************************");
        System.out.println("**************************************");
        System.out.println(jwt);
        return ResponseEntity.ok(
                AuthenticationResponse
                        .builder()
                        .accessToken(jwt)
                        .build());
    }

}
