package com.tsystems.mms.demoapp.user.dto;

import com.tsystems.mms.demoapp.user.domain.User;

import java.util.List;

public class UnitInstanceItem {
    private String name;
    private List<User> users;

    public UnitInstanceItem(String name, List<User> users) {
        this.name = name;
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public UnitInstanceItem() {
    }
}
