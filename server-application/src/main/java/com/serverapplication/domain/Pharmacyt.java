package com.serverapplication.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pharmacyt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_phar;

    private String work_start;
    private String work_end;
    private String phone_num;
    private String comp_name;
    private String address;
    private Integer phar_numb;

    public Pharmacyt() {
    }

    public Pharmacyt(String work_start, String work_end, String phone_num, String comp_name, String address, Integer phar_numb) {
        this.work_start = work_start;
        this.work_end = work_end;
        this.phone_num = phone_num;
        this.comp_name = comp_name;
        this.address = address;
        this.phar_numb = phar_numb;
    }

    public Long getId_phar() {
        return id_phar;
    }

    public void setId_phar(Long id_phar) {
        this.id_phar = id_phar;
    }

    public String getWork_start() {
        return work_start;
    }

    public void setWork_start(String work_start) {
        this.work_start = work_start;
    }

    public String getWork_end() {
        return work_end;
    }

    public void setWork_end(String work_end) {
        this.work_end = work_end;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getComp_name() {
        return comp_name;
    }

    public void setComp_name(String comp_name) {
        this.comp_name = comp_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhar_numb() {
        return phar_numb;
    }

    public void setPhar_numb(Integer phar_numb) {
        this.phar_numb = phar_numb;
    }
}
