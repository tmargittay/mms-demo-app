package com.tsystems.mms.demoapp.user.dto;

import com.tsystems.mms.demoapp.user.domain.OrganisationalUnit;

public class UserCreateCommand {
    private String email;
    private String first_name;
    private String surname;
    private String gender;
    private Long unitId;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserCreateCommand() {
    }

    public UserCreateCommand(String email, String first_name, String surname, String gender,Long unitId) {
        this.email = email;
        this.first_name = first_name;
        this.surname = surname;
        this.gender = gender;
        this.unitId = unitId;
    }
}
