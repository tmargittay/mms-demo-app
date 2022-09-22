package com.tsystems.mms.demoapp.user.dto;

public class UserCreateCommand {
    private String email;
    private String first_name;
    private String surname;
    private String gender;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserCreateCommand() {
    }

    public UserCreateCommand(String email, String first_name, String surname, String gender) {
        this.email = email;
        this.first_name = first_name;
        this.surname = surname;
        this.gender = gender;
    }
}
