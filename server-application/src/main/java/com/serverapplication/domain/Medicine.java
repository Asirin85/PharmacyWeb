package com.serverapplication.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMed;
    @OneToMany(mappedBy = "medicine", fetch = FetchType.LAZY)
    private List<Availability> availabilities = new ArrayList<Availability>();

    private String medName;
    private String medCategory;
    private String medRelForm;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Europe/Samara")
    private Date expirationDate;

    public Medicine(){
    }

    public Medicine(String medName, String medCategory, String medRelForm, Date expirationDate) {
        this.medName = medName;
        this.medCategory = medCategory;
        this.medRelForm = medRelForm;
        this.expirationDate = expirationDate;
    }

    public List<Availability> getAvailabilities() {
        return availabilities;
    }

    public void addAvailabilities(Availability availability) {
        if (availabilities.contains(availability))
            return;
        availabilities.add(availability);
        availability.setMedicine(this);
    }

    public void removeAvailabilities(Availability availability) {
        if (!availabilities.contains(availability))
            return;
        availabilities.remove(availability);
        availability.setMedicine(null);
    }

    public Long getIdMed() {
        return idMed;
    }

    public void setIdMed(Long idMed) {
        this.idMed = idMed;
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public String getMedCategory() {
        return medCategory;
    }

    public void setMedCategory(String medCategory) {
        this.medCategory = medCategory;
    }

    public String getMedRelForm() {
        return medRelForm;
    }

    public void setMedRelForm(String medRelForm) {
        this.medRelForm = medRelForm;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
