package com.tsystems.mms.demoapp.user.dto;

public class UnitCreateCommand {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UnitCreateCommand() {
    }

    public UnitCreateCommand(String name) {
        this.name = name;
    }
}
