package edu.javacourse.studentorder.domain;

import java.time.LocalDate;
import java.util.Date;

public class Child extends Person {
    private String certificateNumber;
    private LocalDate issueDate;
    private String issueDepartment;

    public Child(String surName, String givenName, String patronymic, Date dateOfBirth, Address address) {
        super(surName, givenName, patronymic, dateOfBirth, address);
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public String getIssueDepartment() {
        return issueDepartment;
    }

    public void setIssueDepartment(String issueDepartment) {
        this.issueDepartment = issueDepartment;
    }
}
