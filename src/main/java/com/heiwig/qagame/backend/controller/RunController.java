package com.heiwig.qagame.backend.controller;

import com.heiwig.qagame.backend.entity.Run;
import com.heiwig.qagame.backend.repository.RunRepository;
import com.heiwig.qagame.backend.service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.util.Date;
import java.util.Optional;

@RestController
public class RunController {

    @Autowired
    private ApplicationUserService applicationUserService;

    @Autowired
    private RunRepository runRepository;

    @PostMapping("/runs")
    public ResponseEntity<Object> createRun(@Valid @RequestBody Run run, HttpServletRequest request) {
        run.setCreatedBy(applicationUserService.retrieveUserByUsername(request.getUserPrincipal().getName()));
        run.setCreated(new Date());
        run.setUpdatedBy(applicationUserService.retrieveUserByUsername(request.getUserPrincipal().getName()));
        run.setUpdated(new Date());

        Run savedRun = runRepository.save(run);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedRun.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/runs/{id}")
    public ResponseEntity<Object> partialUpdateRun(@RequestBody Run run, @PathVariable String id, HttpServletRequest request) {
        Optional<Run> oldRun= runRepository.findById(id);

        if(!oldRun.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        oldRun.get().setUpdated(new Date());
        oldRun.get().setUpdatedBy(applicationUserService.retrieveUserByUsername(request.getUserPrincipal().getName()));

        if(run.getDescription() != null) oldRun.get().setDescription(run.getDescription());
        if(run.getRunDate() != null) oldRun.get().setRunDate(run.getRunDate());

        Run savedRun = runRepository.save(oldRun.get());

        return ResponseEntity.ok(savedRun);

    }
}
