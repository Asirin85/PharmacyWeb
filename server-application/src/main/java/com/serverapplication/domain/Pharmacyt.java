package com.serverapplication.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pharmacyt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPhar;
    @OneToMany(mappedBy = "pharmacyt", fetch = FetchType.LAZY)
    private List<Availability> availabilities = new ArrayList<Availability>();


    private String workStart;
    private String workEnd;
    private String phoneNum;
    private String compName;
    private String address;
    private Integer pharNumb;

    public Pharmacyt() {
    }

    public Pharmacyt(String workStart, String workEnd, String phoneNum, String compName, String address, Integer pharNumb) {
        this.workStart = workStart;
        this.workEnd = workEnd;
        this.phoneNum = phoneNum;
        this.compName = compName;
        this.address = address;
        this.pharNumb = pharNumb;
    }

    public List<Availability> getAvailabilities() {
        return availabilities;
    }

    public void addAvailabilities(Availability availability) {
        if (availabilities.contains(availability))
            return;
        availabilities.add(availability);
        availability.setPharmacyt(this);
    }

    public void removeAvailabilities(Availability availability) {
        if (!availabilities.contains(availability))
            return;
        availabilities.remove(availability);
        availability.setPharmacyt(null);
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
