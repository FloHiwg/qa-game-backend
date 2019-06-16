package com.heiwig.qagame.backend.controller;

import com.heiwig.qagame.backend.entity.Case;
import com.heiwig.qagame.backend.entity.Scenario;
import com.heiwig.qagame.backend.repository.CaseRepository;
import com.heiwig.qagame.backend.repository.ScenarioRepository;
import com.heiwig.qagame.backend.service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Optional;

@RestController
public class CaseController {

    @Autowired
    private ApplicationUserService applicationUserService;

    @Autowired
    private CaseRepository caseRepository;

    @Autowired
    private ScenarioRepository scenarioRepository;

    @PostMapping("/scenarios/{id}/cases")
    public ResponseEntity<Object> createCaseForScenario(@RequestBody Case caze, @PathVariable String id, HttpServletRequest request) {
        Optional<Scenario> scenario = scenarioRepository.findById(id);

        caze.setCreatedBy(applicationUserService.retrieveUserByUsername(request.getUserPrincipal().getName()));
        caze.setCreated(new Date());
        caze.setUpdatedBy(applicationUserService.retrieveUserByUsername(request.getUserPrincipal().getName()));
        caze.setUpdated(new Date());

        Case savedCaze = caseRepository.save(caze);

        if(!scenario.isPresent()) return ResponseEntity.notFound().build();
        scenario.get().getCasesList().add(savedCaze);
        scenarioRepository.save(scenario.get());

        return ResponseEntity.ok(savedCaze);
    }

    @PatchMapping("/cases/{id}")
    public ResponseEntity<Object> partialUpdateCase(@RequestBody Case caze, @PathVariable String id, HttpServletRequest request) {
        Optional<Case> oldCaze = caseRepository.findById(id);

        if(!oldCaze.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        oldCaze.get().setUpdated(new Date());
        oldCaze.get().setUpdatedBy(applicationUserService.retrieveUserByUsername(request.getUserPrincipal().getName()));

        if(caze.getDescription() != null) oldCaze.get().setDescription(caze.getDescription());

        Case savedCaze = caseRepository.save(oldCaze.get());

        return ResponseEntity.ok(savedCaze);
    }

}

