/**
 * Copyright:	Copyright (c) From Down & Around, Inc.
 */

package com.emilio.projects.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity @Table( name="VOTER", schema="S2APP" )
public class Voter implements Serializable {

    private long id;
    private Date enrollmentTime;
    private Date voteRecordedTime;
    private Contestant votedForOption;
    private User user;
    private Event event;

    @Id  @GeneratedValue(strategy=GenerationType.AUTO) @Column(name="ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name="ENROLLMENT_TIME") @Temporal(TemporalType.TIMESTAMP)
    public Date getEnrollmentTime() {
        return enrollmentTime;
    }

    public void setEnrollmentTime(Date enrollmentTime) {
        this.enrollmentTime = enrollmentTime;
    }

    @Column(name="VOTED_ON",nullable=true) @Temporal(TemporalType.TIMESTAMP)
    public Date getVoteRecordedTime() {
        return voteRecordedTime;
    }

    public void setVoteRecordedTime(Date voteRecordedTime) {
        this.voteRecordedTime = voteRecordedTime;
    }

    @ManyToOne @JoinColumn(name="CONTESTANT_FK",nullable=true)
    public Contestant getVotedForOption() {
        return votedForOption;
    }

    public void setVotedForOption(Contestant votedForOption) {
        this.votedForOption = votedForOption;
    }

    @ManyToOne @JoinColumn(name="USER_FK")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne @JoinColumn(name="EVENT_FK")
    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((enrollmentTime == null) ? 0 : enrollmentTime.hashCode());
		result = prime * result + ((event == null) ? 0 : event.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime
				* result
				+ ((voteRecordedTime == null) ? 0 : voteRecordedTime.hashCode());
		result = prime * result
				+ ((votedForOption == null) ? 0 : votedForOption.hashCode());
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
		Voter other = (Voter) obj;
		if (enrollmentTime == null) {
			if (other.enrollmentTime != null)
				return false;
		} else if (!enrollmentTime.equals(other.enrollmentTime))
			return false;
		if (event == null) {
			if (other.event != null)
				return false;
		} else if (!event.equals(other.event))
			return false;
		if (id != other.id)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (voteRecordedTime == null) {
			if (other.voteRecordedTime != null)
				return false;
		} else if (!voteRecordedTime.equals(other.voteRecordedTime))
			return false;
		if (votedForOption == null) {
			if (other.votedForOption != null)
				return false;
		} else if (!votedForOption.equals(other.votedForOption))
			return false;
		return true;
	}
    
}
