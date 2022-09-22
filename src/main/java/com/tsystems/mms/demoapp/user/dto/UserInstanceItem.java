package com.tsystems.mms.demoapp.user.dto;

public class UserInstanceItem {
    private Long id;
    private String email;

    public UserInstanceItem(Long id, String email) {
        this.id = id;
        this.email = email;
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
