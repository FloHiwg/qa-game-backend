package com.heiwig.qagame.backend.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.List;

@Document
public class Case {

    @Id
    private String id;

    @DBRef
    private List<Step> stepList;

    private String description;
    private Date created;
    @DBRef
    private ApplicationUser createdBy;
    private Date updated;
    @DBRef
    private ApplicationUser updatedBy;

    public Case() {
    }

    public Case(List<Step> stepList, String description, Date created, ApplicationUser createdBy, Date updated, ApplicationUser updatedBy) {
        this.stepList = stepList;
        this.description = description;
        this.created = created;
        this.createdBy = createdBy;
        this.updated = updated;
        this.updatedBy = updatedBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Step> getStepList() {
        return stepList;
    }

    public void setStepList(List<Step> stepList) {
        this.stepList = stepList;
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
}
