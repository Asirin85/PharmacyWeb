package com.serverapplication.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_med;

    private String med_name;
    private String med_category;
    private String med_rel_form;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date expiration_date;

    public Medicine() {
    }

    public Medicine(String med_name, String med_category, String med_rel_form, Date expiration_date) {
        this.med_name = med_name;
        this.med_category = med_category;
        this.med_rel_form = med_rel_form;
        this.expiration_date = expiration_date;
    }

    public Long getID_med() {
        return id_med;
    }

    public void setID_med(Long id_med) {
        this.id_med = id_med;
    }

    public String getMed_name() {
        return med_name;
    }

    public void setMed_name(String med_name) {
        this.med_name = med_name;
    }

    public String getMed_category() {
        return med_category;
    }

    public void setMed_category(String med_category) {
        this.med_category = med_category;
    }

    public String getMed_rel_form() {
        return med_rel_form;
    }

    public void setMed_rel_form(String med_rel_form) {
        this.med_rel_form = med_rel_form;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }
}
