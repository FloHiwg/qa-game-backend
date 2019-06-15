package com.heiwig.qagame.backend.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class TicketComment {

    @Id
    private String id;
    @DBRef
    private ApplicationUser createdBy;
    private Date created;
    private String content;

    public TicketComment() {
    }

    public TicketComment(ApplicationUser createdBy, Date created, String content) {
        this.createdBy = createdBy;
        this.created = created;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
