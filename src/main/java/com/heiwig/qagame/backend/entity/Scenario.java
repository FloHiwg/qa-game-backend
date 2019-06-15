package com.heiwig.qagame.backend.entity;

import com.heiwig.qagame.backend.enums.Priority;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
public class Scenario {

    @Id
    private String id;
    @DBRef
    private List<Case> casesList;
    private String description;
    private Date created;
    @DBRef
    private ApplicationUser createdBy;
    private Date updated;
    @DBRef
    private ApplicationUser updatedBy;
    private Priority priority;

    public Scenario() {
    }

    public Scenario(String description, Date created, ApplicationUser createdBy, Date updated, ApplicationUser updatedBy, Priority priority) {
        this.description = description;
        this.created = created;
        this.createdBy = createdBy;
        this.updated = updated;
        this.updatedBy = updatedBy;
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Case> getCasesList() {
        return casesList;
    }

    public void setCasesList(List<Case> casesList) {
        this.casesList = casesList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public ApplicationUser getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(ApplicationUser createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public ApplicationUser getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(ApplicationUser updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
