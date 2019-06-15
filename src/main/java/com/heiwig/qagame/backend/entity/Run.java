package com.heiwig.qagame.backend.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
public class Run {

    @Id
    private String id;

    @DBRef
    private List<Scenario> scenarioList;
    private Date runDate;
    private String description;
    private User createdBy;
    private Date created;
    private User updatedBy;
    private Date updated;

    public Run() {
    }

    public Run(Date runDate, String description, User createdBy, Date created, User updatedBy, Date updated) {
        this.runDate = runDate;
        this.description = description;
        this.createdBy = createdBy;
        this.created = created;
        this.updatedBy = updatedBy;
        this.updated = updated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Scenario> getScenarioList() {
        return scenarioList;
    }

    public void setScenarioList(List<Scenario> scenarioList) {
        this.scenarioList = scenarioList;
    }

    public Date getRunDate() {
        return runDate;
    }

    public void setRunDate(Date runDate) {
        this.runDate = runDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public User getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
