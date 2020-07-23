package com.serverapplication.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Availability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRec;

    private Integer price;
    private Integer amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_phar_fk")
    private Pharmacyt pharmacyt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_med_fk")
    private Medicine medicine;
    
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Europe/Samara")
    private Date receiptDate;

    public Availability() {
    }

    public Availability(Integer price, Integer amount, Date receiptDate, Medicine medicine, Pharmacyt pharmacyt) {
        this.price = price;
        this.amount = amount;
        this.receiptDate = receiptDate;
        this.medicine = medicine;
        this.pharmacyt = pharmacyt;
    }


    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        if (sameAsFormerMedicine(medicine)) return;
        Medicine oldMedicine = this.medicine;
        this.medicine = medicine;
        if (oldMedicine != null) {
            oldMedicine.removeAvailabilities(this);
        }
        if (medicine != null) {
            medicine.addAvailabilities(this);
        }
    }

    private boolean sameAsFormerMedicine(Medicine newMedicine) {
        return medicine == null ? newMedicine == null : medicine.equals(newMedicine);
    }

    public Pharmacyt getPharmacyt() {
        return pharmacyt;
    }

    public void setPharmacyt(Pharmacyt pharmacyt) {
        if (sameAsFormerPharmacyt(pharmacyt)) return;
        Pharmacyt oldPharmacyt = this.pharmacyt;
        this.pharmacyt = pharmacyt;
        if (oldPharmacyt != null) {
            oldPharmacyt.removeAvailabilities(this);
        }
        if (pharmacyt != null) {
            pharmacyt.addAvailabilities(this);
        }
    }

    private boolean sameAsFormerPharmacyt(Pharmacyt newPharmacyt) {
        return pharmacyt == null ? newPharmacyt == null : pharmacyt.equals(newPharmacyt);
    }

    public Long getIdRec() {
        return idRec;
    }

    public void setIdRec(Long idRec) {
        this.idRec = idRec;
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
