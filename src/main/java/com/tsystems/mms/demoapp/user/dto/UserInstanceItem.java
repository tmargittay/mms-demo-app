package com.tsystems.mms.demoapp.user.dto;

public class UserInstanceItem {
    private Long id;
    private String email;
    private String first_name;
    private String surname;
    private String gender;
    private UnitInstanceItem unitInstanceItem;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public UnitInstanceItem getUnitInstanceItem() {
        return unitInstanceItem;
    }

    public void setUnitInstanceItem(UnitInstanceItem unitInstanceItem) {
        this.unitInstanceItem = unitInstanceItem;
    }

    public UserInstanceItem(Long id, String email, String first_name, String surname, String gender, UnitInstanceItem unitInstanceItem) {
        this.id = id;
        this.email = email;
        this.first_name = first_name;
        this.surname = surname;
        this.gender = gender;
        this.unitInstanceItem = unitInstanceItem;
    }

    public UserInstanceItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
