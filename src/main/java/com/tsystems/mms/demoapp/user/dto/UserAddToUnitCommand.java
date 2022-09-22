package com.tsystems.mms.demoapp.user.dto;

public class UserAddToUnitCommand {
    private Long id;
    private Long unitId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public UserAddToUnitCommand() {
    }

    public UserAddToUnitCommand(Long id, Long unitId) {
        this.id = id;
        this.unitId = unitId;
    }
}
