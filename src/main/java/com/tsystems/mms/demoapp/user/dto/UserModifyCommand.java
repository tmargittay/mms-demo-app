package com.tsystems.mms.demoapp.user.dto;

public class UserModifyCommand {
    private String email;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserModifyCommand(String email, Long id) {
        this.email = email;
        this.id = id;
    }

    public UserModifyCommand() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
