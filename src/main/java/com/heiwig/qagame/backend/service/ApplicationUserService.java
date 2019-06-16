package com.heiwig.qagame.backend.service;

import com.heiwig.qagame.backend.entity.ApplicationUser;
import com.heiwig.qagame.backend.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationUserService {

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    public ApplicationUser retrieveUserByUsername(String username) {
        Optional<ApplicationUser> applicationUser = applicationUserRepository.findByUsername(username);

        if(applicationUser.isPresent()) {
            return applicationUser.get();
        }

        return null;
    }
}
