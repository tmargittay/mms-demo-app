package com.tsystems.mms.demoapp.user.domain;

import com.tsystems.mms.demoapp.user.enums.Gender;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "demo_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1715994813284718249L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "first_name", nullable = false)
    private String first_name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name= "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public User(String email, String first_name, String surname, Gender gender) {
        this.email = email;
        this.first_name = first_name;
        this.surname = surname;
        this.gender = gender;
    }

    public User() {
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
