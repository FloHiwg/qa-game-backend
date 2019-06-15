package com.heiwig.qagame.backend.entity;

import com.heiwig.qagame.backend.enums.TicketType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
public class Ticket {
    @Id
    private String id;

    private String name;
    private TicketType type;
    private String description;
    @DBRef
    private Step refStep;
    @DBRef
    private ApplicationUser createdBy;
    private Date created;
    private List<TicketComment> commentList;

    public Ticket() {
    }

    public Ticket(String name, TicketType type, String description, Step refStep, ApplicationUser createdBy, Date created) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.refStep = refStep;
        this.createdBy = createdBy;
        this.created = created;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TicketType getType() {
        return type;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Step getRefStep() {
        return refStep;
    }

    public void setRefStep(Step refStep) {
        this.refStep = refStep;
    }

    public ApplicationUser getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(ApplicationUser createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public List<TicketComment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<TicketComment> commentList) {
        this.commentList = commentList;
    }
}
