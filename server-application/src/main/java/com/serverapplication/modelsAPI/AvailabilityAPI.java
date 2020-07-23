package com.serverapplication.modelsAPI;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.serverapplication.domain.Medicine;
import com.serverapplication.domain.Pharmacyt;
import com.serverapplication.repos.MedicineRepo;
import com.serverapplication.repos.PharmacytRepo;

import java.sql.Date;

public class AvailabilityAPI {

    private Long idRec;
    private Long idMed;
    private Long idPhar;
    private Integer price;
    private Integer amount;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Europe/Samara")
    private Date receiptDate;

    public void setIdOnMed(Medicine medicine) {
        this.idMed = medicine.getIdMed();
    }

    public Medicine getIdOnMed(MedicineRepo medicineRepo) {
        return medicineRepo.findById(idMed).get();
    }

    public void setIdOnPhar(Pharmacyt pharmacyt) {
        this.idPhar = pharmacyt.getIdPhar();
    }

    public Pharmacyt getIdOnPhar(PharmacytRepo pharmacytRepo) {
        return pharmacytRepo.findById(idPhar).get();
    }


    public AvailabilityAPI() {
    }

    public AvailabilityAPI(Long idRec, Long idMed, Long idPhar, Integer price, Integer amount, Date receiptDate) {
        this.idRec = idRec;
        this.idMed = idMed;
        this.idPhar = idPhar;
        this.price = price;
        this.amount = amount;
        this.receiptDate = receiptDate;
    }

    public Long getIdRec() {
        return idRec;
    }

    public void setIdRec(Long idRec) {
        this.idRec = idRec;
    }

    public Long getIdMed() {
        return idMed;
    }

    public void setIdMed(Long idMed) {
        this.idMed = idMed;
    }

    public Long getIdPhar() {
        return idPhar;
    }

    public void setIdPhar(Long idPhar) {
        this.idPhar = idPhar;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }
}
