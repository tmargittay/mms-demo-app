package com.tsystems.mms.demoapp.user.dto;

public class UserCreateCommand {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserCreateCommand() {
    }

    public UserCreateCommand(String email) {
        this.email = email;
    }
}
