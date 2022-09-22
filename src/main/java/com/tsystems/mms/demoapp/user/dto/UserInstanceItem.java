package com.tsystems.mms.demoapp.user.dto;

import com.tsystems.mms.demoapp.user.domain.User;

public class UserInstanceItem {
    private Long id;
    private String email;
    private String first_name;
    private String surname;
    private String gender;
    private Long unitId;

    public UserInstanceItem(User user) {
        id = null;
        email = null;
        first_name = null;
        surname = null;
        gender = null;
        unitId = null;
        if(user.getId() != null){
            id = user.getId();
        }
        if(user.getEmail() != null){
            email = user.getEmail();
        }if(user.getFirst_name() != null){
            first_name = user.getFirst_name();
        }
        if(user.getSurname() != null){
            surname = user.getSurname();
        }
        if(user.getGender() != null){
            gender = user.getGender().toString();
        }
        if(user.unit != null)
        {
            unitId = user.unit.getUnitId();
        }
    }

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

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
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
