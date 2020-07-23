package com.serverapplication.modelsAPI;

public class PharmacytAPI {
    private Long idPhar;
    private String workStart;
    private String workEnd;
    private String phoneNum;
    private String compName;
    private String address;
    private Integer pharNumb;

    public PharmacytAPI() {
    }

    public PharmacytAPI(Long idPhar, String workStart, String workEnd, String phoneNum, String compName, String address, Integer pharNumb) {
        this.idPhar = idPhar;
        this.workStart = workStart;
        this.workEnd = workEnd;
        this.phoneNum = phoneNum;
        this.compName = compName;
        this.address = address;
        this.pharNumb = pharNumb;
    }

    public Long getIdPhar() {
        return idPhar;
    }

    public void setIdPhar(Long idPhar) {
        this.idPhar = idPhar;
    }

    public String getWorkStart() {
        return workStart;
    }

    public void setWorkStart(String workStart) {
        this.workStart = workStart;
    }

    public String getWorkEnd() {
        return workEnd;
    }

    public void setWorkEnd(String workEnd) {
        this.workEnd = workEnd;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPharNumb() {
        return pharNumb;
    }

    public void setPharNumb(Integer pharNumb) {
        this.pharNumb = pharNumb;
    }
}
