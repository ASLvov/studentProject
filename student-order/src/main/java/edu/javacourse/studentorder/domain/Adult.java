package edu.javacourse.studentorder.domain;

import java.time.LocalDate;

public class Adult extends Person {
    private String passportSerial;
    private String passportNumber;
    private LocalDate issueDate;
    private PassportOffice issueDepartment;
    private University university;
    private String studentID;

    public Adult(String surName, String givenName, String patronymic, LocalDate dateOfBirth, Address address) {
        super(surName, givenName, patronymic, dateOfBirth, address);
    }

    public Adult() {
        super();
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentId(String studentID) {
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

    public PassportOffice getIssueDepartment() {
        return issueDepartment;
    }

    public void setIssueDepartment(PassportOffice issueDepartment) {
        this.issueDepartment = issueDepartment;
    }

    @Override
    public String toString() {
        return "Adult{" +
                "passportSerial='" + passportSerial + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", issueDate=" + issueDate +
                ", issueDepartment=" + issueDepartment +
                ", university=" + university +
                ", studentID='" + studentID + '\'' +
                "} " + super.toString();
    }
}
