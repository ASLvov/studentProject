package edu.javacourse.studentorder.domain;

import java.time.LocalDate;
import java.util.Date;

public class Adult extends Person {
    private String passportSerial;
    private String passportNumber;
    private LocalDate issueDate;
    private String issueDepartment;
    private String university;
    private String studentID;

    public Adult(String surName, String givenName, String patronymic, Date dateOfBirth, Address address) {
        super(surName, givenName, patronymic, dateOfBirth, address);
    }


    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getPassportSerial() {
        return passportSerial;
    }

    public void setPassportSerial(String passportSerial) {
        this.passportSerial = passportSerial;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
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
