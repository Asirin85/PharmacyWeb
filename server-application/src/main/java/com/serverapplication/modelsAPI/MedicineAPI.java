package com.serverapplication.modelsAPI;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

public class MedicineAPI {
    private Long idMed;
    private String medName;
    private String medCategory;
    private String medRelForm;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Europe/Samara")
    private Date expirationDate;

    public MedicineAPI() {
    }

    public MedicineAPI(Long idMed, String medName, String medCategory, String medRelForm, Date expirationDate) {
        this.idMed = idMed;
        this.medName = medName;
        this.medCategory = medCategory;
        this.medRelForm = medRelForm;
        this.expirationDate = expirationDate;
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
