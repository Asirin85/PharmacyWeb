package com.serverapplication.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Availability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rec;

    private Integer id_med_fk;
    private Integer id_phar_fk;
    private Integer price;
    private Integer amount;
    private Date receipt_date;

    public Availability() {
    }

    public Availability(Integer id_med_fk, Integer id_phar_fk, Integer price, Integer amount, Date receipt_date) {
        this.id_med_fk = id_med_fk;
        this.id_phar_fk = id_phar_fk;
        this.price = price;
        this.amount = amount;
        this.receipt_date = receipt_date;
    }

    public Long getId_rec() {
        return id_rec;
    }

    public void setId_rec(Long id_rec) {
        this.id_rec = id_rec;
    }

    public Integer getId_med_fk() {
        return id_med_fk;
    }

    public void setId_med_fk(Integer id_med_fk) {
        this.id_med_fk = id_med_fk;
    }

    public Integer getId_phar_fk() {
        return id_phar_fk;
    }

    public void setId_phar_fk(Integer id_phar_fk) {
        this.id_phar_fk = id_phar_fk;
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

    public Date getReceipt_date() {
        return receipt_date;
    }

    public void setReceipt_date(Date receipt_date) {
        this.receipt_date = receipt_date;
    }
}
