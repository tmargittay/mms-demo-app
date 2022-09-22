package com.tsystems.mms.demoapp.user.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "demo_organisational_unit")
public class OrganisationalUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unit_id", nullable = false)
    protected Long unitId;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "unit")
    private List<User> users;

    public OrganisationalUnit(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public OrganisationalUnit(String name, List<User> users) {
        this.name = name;
        this.users = users;
    }

    public OrganisationalUnit() {
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
