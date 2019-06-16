package com.heiwig.qagame.backend.controller;

import com.heiwig.qagame.backend.entity.Case;
import com.heiwig.qagame.backend.entity.Step;
import com.heiwig.qagame.backend.repository.CaseRepository;
import com.heiwig.qagame.backend.repository.StepRepository;
import com.heiwig.qagame.backend.service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Optional;

@RestController
public class StepController {

    @Autowired
    private ApplicationUserService applicationUserService;

    @Autowired
    private StepRepository stepRepository;

    @Autowired
    private CaseRepository caseRepository;

    @PostMapping("/cases/{id}/steps")
    public ResponseEntity<Object> createStepForCase(@RequestBody Step step, @PathVariable String id, HttpServletRequest request) {
        Optional<Case> caze = caseRepository.findById(id);

        step.setCreatedBy(applicationUserService.retrieveUserByUsername(request.getUserPrincipal().getName()));
        step.setCreated(new Date());
        step.setUpdatedBy(applicationUserService.retrieveUserByUsername(request.getUserPrincipal().getName()));
        step.setUpdated(new Date());

        Step savedStep = stepRepository.save(step);

        if(!caze.isPresent()) return ResponseEntity.notFound().build();
        caze.get().getStepList().add(savedStep);
        caseRepository.save(caze.get());

        return ResponseEntity.ok(savedStep);
    }

    @PatchMapping("/steps/{id}")
    public ResponseEntity<Object> partialUpdateStep(@RequestBody Step step, @PathVariable String id, HttpServletRequest request) {
        Optional<Step> oldStep = stepRepository.findById(id);

        if(!oldStep.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        oldStep.get().setUpdated(new Date());
        oldStep.get().setUpdatedBy(applicationUserService.retrieveUserByUsername(request.getUserPrincipal().getName()));

        if(step.getDescription() != null) oldStep.get().setDescription(step.getDescription());
        if(step.getExpectedResult() != null) oldStep.get().setDescription(step.getExpectedResult());

        Step savedStep = stepRepository.save(oldStep.get());

        return ResponseEntity.ok(savedStep);
    }
}
