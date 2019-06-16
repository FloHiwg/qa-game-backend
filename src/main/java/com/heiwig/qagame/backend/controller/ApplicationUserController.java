package com.heiwig.qagame.backend.controller;

import com.heiwig.qagame.backend.entity.ApplicationUser;
import com.heiwig.qagame.backend.entity.Run;
import com.heiwig.qagame.backend.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class ApplicationUserController {

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/sign-up")
    public ResponseEntity<Object> signUp(@RequestBody ApplicationUser applicationUser) {
        applicationUser.setPassword(bCryptPasswordEncoder.encode(applicationUser.getPassword()));
        ApplicationUser savedUser = applicationUserRepository.save(applicationUser);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/current")
    public ResponseEntity<Object> currentUserNameSimple(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        Optional<ApplicationUser> applicationUser = applicationUserRepository.findByUsername(principal.getName());

        if(!applicationUser.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(applicationUser.get().getId()).toUri();

        return ResponseEntity.ok(applicationUser.get());
    }
}
