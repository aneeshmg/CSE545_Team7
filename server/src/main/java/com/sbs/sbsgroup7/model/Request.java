package com.sbs.sbsgroup7.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;


@Entity
public class Request {

    @Id
    @Column(name = "requestId",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    @NotNull
    @Column(name = "requestType",nullable = false)
    private String requestType;

    @Column(name = "requestedTime",nullable = false)
    private Instant requestedTime;

    @ManyToOne
    @JoinColumn(name = "userId", nullable=false)
    @NotNull
    private User requestedUser;

    @ManyToOne
    @JoinColumn
    private User approvedUser;

    @NotNull
    @Column(name = "requestStatus",nullable = false)
    private String requestStatus;

    @Column(name = "description",nullable = true)
    private String description;

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public Request(){}

    public Long getRequestId() {
        return requestId;
    }

    public String getRequestType() {
        return requestType;
    }

    public Instant getRequestedTime() {
        return requestedTime;
    }

    public User getRequestedUser() {
        return requestedUser;
    }

    public User getApprovedUser() {
        return approvedUser;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public void setRequestedTime(Instant requestedTime) {
        this.requestedTime = requestedTime;
    }

    public void setRequestedUser(User requestedUser) {
        this.requestedUser = requestedUser;
    }

    public void setApprovedUser(User approvedUser) {
        this.approvedUser = approvedUser;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }
}
