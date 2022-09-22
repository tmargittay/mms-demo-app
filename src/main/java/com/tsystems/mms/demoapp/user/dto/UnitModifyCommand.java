package com.tsystems.mms.demoapp.user.dto;

public class UnitModifyCommand {
    private String name;
    private Long unitId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public UnitModifyCommand() {
    }

    public UnitModifyCommand(String name, Long unitId) {
        this.name = name;
        this.unitId = unitId;
    }
}
