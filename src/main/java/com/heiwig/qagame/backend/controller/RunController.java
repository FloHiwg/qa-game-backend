package com.heiwig.qagame.backend.controller;

import com.heiwig.qagame.backend.entity.Run;
import com.heiwig.qagame.backend.entity.Scenario;
import com.heiwig.qagame.backend.repository.RunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class RunController {

    @Autowired
    private RunRepository runRepository;

    @GetMapping("/runs")
    public List<Run> retrieveAllRuns() {
        return runRepository.findAll();
    }

    @GetMapping("/runs/{id}")
    public Optional<Run> retrieveRunById(@PathVariable String id) {
        Optional<Run> run = runRepository.findById(id);

        return run;
    }

    @PostMapping("/runs")
    public ResponseEntity<Object> createRun(@Valid @RequestBody Run run) {

        Run savedRun = runRepository.save(run);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedRun.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PostMapping("/runs/{id}/scenarios")
    public ResponseEntity<Object> createScenario(@Valid @RequestBody Run run) {

        Run savedRun = runRepository.save(run);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedRun.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
