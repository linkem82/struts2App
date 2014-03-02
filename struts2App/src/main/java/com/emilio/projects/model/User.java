/**
 * Copyright:	Copyright (c) From Down & Around, Inc.
 */

package com.emilio.projects.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Arrays;
import com.opensymphony.xwork2.validator.annotations.*;

@Entity @Table( name="APP_USER", schema="S2APP" )
@NamedQuery(name="user.byEmail", query="select u from User u where u.email = :email")
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
    
    @EmailValidator(message="Validation Error", key="validate.email")
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Column(name="FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }
    
    @RequiredStringValidator(
    		message="Validation Error", key="validate.notEmpty", trim=true)   
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name="LAST_NAME")
    public String getLastName() {
        return lastName;
    }
    
    @RequiredStringValidator(
    		message="Validation Error", key="validate.notEmpty", trim=true)   
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name="USER_PASSWORD")
    public String getPassword() {
        return password;
    }
    
    @RequiredStringValidator(
    		message="Validation Error", key="validate.notEmpty",
    		trim=true, shortCircuit=true)
    @StringLengthFieldValidator(
    		message="Length too short", key="validate.minLength.6",
    		trim=true, minLength="6")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + Arrays.hashCode(portrait);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (!Arrays.equals(portrait, other.portrait))
			return false;
		return true;
	}
    
    
}
