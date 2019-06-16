package com.heiwig.qagame.backend.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document
public class Step {

    @Id
    private String id;
    private String description;
    private String expectedResult;
    private Date created;
    @DBRef
    private ApplicationUser createdBy;
    private Date updated;
    @DBRef
    private ApplicationUser updatedBy;

    public Step() {
    }

    public Step(String description, String expectedResult) {
        this.description = description;
        this.expectedResult = expectedResult;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
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
