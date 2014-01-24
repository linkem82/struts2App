/**
 * Copyright:	Copyright (c) From Down & Around, Inc.
 */

package com.emilio.projects.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity @Table( name="APP_USER", schema="S2APP" )
@NamedQuery(name="user.byEmail", query="select u from User u where u.email >= :email")
public class User implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private byte[] portrait;

    @Id @Column(name="EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name="LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name="USER_PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Lob @Column(name="PORTRAIT")
    public byte[] getPortrait() {
        return portrait;
    }

    public void setPortrait(byte[] portrait) {
        this.portrait = portrait;
    }
}
