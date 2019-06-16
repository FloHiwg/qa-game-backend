package com.heiwig.qagame.backend.controller;

import com.heiwig.qagame.backend.entity.Case;
import com.heiwig.qagame.backend.entity.Scenario;
import com.heiwig.qagame.backend.repository.CaseRepository;
import com.heiwig.qagame.backend.repository.ScenarioRepository;
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
public class ScenarioController {

    @Autowired
    private ScenarioRepository scenarioRepository;

    @Autowired
    private CaseRepository caseRepository;

    @Autowired
    private ApplicationUserService applicationUserService;

    @PostMapping("/scenarios")
    public ResponseEntity<Object> createScenario(@Valid @RequestBody Scenario scenario, HttpServletRequest request) {
        scenario.setCreatedBy(applicationUserService.retrieveUserByUsername(request.getUserPrincipal().getName()));
        scenario.setCreated(new Date());
        scenario.setUpdatedBy(applicationUserService.retrieveUserByUsername(request.getUserPrincipal().getName()));
        scenario.setUpdated(new Date());

        Scenario savedScenario = scenarioRepository.save(scenario);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedScenario.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/scenarios/{id}")
    public ResponseEntity<Object> partialUpdateScenario(@RequestBody Scenario scenario, @PathVariable String id, HttpServletRequest request) {
        Optional<Scenario> oldScenario = scenarioRepository.findById(id);

        if(!oldScenario.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        oldScenario.get().setUpdated(new Date());
        oldScenario.get().setUpdatedBy(applicationUserService.retrieveUserByUsername(request.getUserPrincipal().getName()));

        if(scenario.getDescription() != null) oldScenario.get().setDescription(scenario.getDescription());
        if(scenario.getPriority() != null) oldScenario.get().setPriority(scenario.getPriority());

        Scenario savedScenario = scenarioRepository.save(oldScenario.get());

        return ResponseEntity.ok(savedScenario);
    }
}
