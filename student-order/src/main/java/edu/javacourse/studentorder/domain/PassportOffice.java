package edu.javacourse.studentorder.domain;

public class PassportOffice {
    private Long officeID;
    private String officeAreaId;
    private String officeName;

    public PassportOffice() {
    }

    public PassportOffice(Long officeID, String officeAreaId, String officeName) {
        this.officeID = officeID;
        this.officeAreaId = officeAreaId;
        this.officeName = officeName;
    }

    public Long getOfficeID() {
        return officeID;
    }

    public void setOfficeID(Long officeID) {
        this.officeID = officeID;
    }

    public String getOfficeAreaId() {
        return officeAreaId;
    }

    public void setOfficeAreaId(String officeAreaId) {
        this.officeAreaId = officeAreaId;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    @Override
    public String toString() {
        return "PassportOffice{" +
                "officeID=" + officeID +
                ", officeAreaId='" + officeAreaId + '\'' +
                ", officeName='" + officeName + '\'' +
                '}';
    }
}
