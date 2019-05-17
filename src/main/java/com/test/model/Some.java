package com.test.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "SOME")
public class Some {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long Id;

    @Basic(fetch = FetchType.LAZY)
    @NotNull
    @Column(name = "Password")
    String password;

    @Basic
    @Column(name = "Name")
    String name;

    @Basic
    @Column(name = "Address")
    String address;

    public Some() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
