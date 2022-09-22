package com.tsystems.mms.demoapp.user.dto;

import com.tsystems.mms.demoapp.user.domain.OrganisationalUnit;

import java.util.List;
import java.util.stream.Collectors;

public class UnitInstanceItem {
    private String name;
    private List<UserInstanceItem> users;

    public UnitInstanceItem(String name, List<UserInstanceItem> users) {
        this.name = name;
        this.users = users;
    }

    public UnitInstanceItem(OrganisationalUnit unit) {
        this.name = unit.getName();
        this.users = unit.getUsers().stream().map(UserInstanceItem::new).collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserInstanceItem> getUsers() {
        return users;
    }

    public void setUsers(List<UserInstanceItem> users) {
        this.users = users;
    }

    public UnitInstanceItem() {
    }
}