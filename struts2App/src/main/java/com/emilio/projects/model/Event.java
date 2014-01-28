/**
 * Copyright:	Copyright (c) From Down & Around, Inc.
 */

package com.emilio.projects.model;

import org.hibernate.annotations.Generated;

import javax.persistence.*;

import java.util.*;
import java.io.Serializable;

@Entity @Table( name="EVENT", schema="S2APP" )
public class Event  implements Serializable {

    private long id;
    private String name;
    private Date startTime;
    private int duration;
    private int timeZoneOffset;
    private Date votingStartTime;
    private Date lastUpdateTime;
    private Set<Voter> voters = new HashSet<Voter>();
    private Location location;
    private List<Contestant> options = new ArrayList<Contestant>();
    private Progress status;

    @Id @GeneratedValue(strategy=GenerationType.AUTO) @Column(name="ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name="NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="START_TIME") @Temporal(TemporalType.TIMESTAMP)
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Column(name="DURATION")
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Column(name="TZ_OFFSET")
    public int getTimeZoneOffset() {
        return timeZoneOffset;
    }

    public void setTimeZoneOffset(int timeZoneOffset) {
        this.timeZoneOffset = timeZoneOffset;
    }

    @Column(name="VOTING_STARTS") @Temporal(TemporalType.TIMESTAMP)
    public Date getVotingStartTime() {
        return votingStartTime;
    }

    public void setVotingStartTime(Date votingStartTime) {
        this.votingStartTime = votingStartTime;
    }

    @Column(name="LAST_UPDATE") @Temporal(TemporalType.TIMESTAMP)
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @OneToMany(mappedBy="event",cascade=CascadeType.ALL)
    public Set<Voter> getVoters() {
        return voters;
    }

    public void setVoters(Set<Voter> voters) {
        this.voters = voters;
    }

    public void addVoter( Voter v ) {
        v.setEvent(this);
        voters.add(v);
    }

    @ManyToOne(cascade=CascadeType.ALL) @JoinColumn(name="LOCATION_FK")
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @OneToMany(mappedBy="event",cascade=CascadeType.ALL)
    public List<Contestant> getOptions() {
        return options;
    }

    public void setOptions(List<Contestant> options) {
        this.options = options;
    }

    public void addOption( Contestant c ) {
        c.setEvent(this);
        options.add(c);
    }

    @Column(name="STATE") @Enumerated(EnumType.STRING)
    public Progress getStatus() {
        return status;
    }

    public void setStatus(Progress status) {
        this.status = status;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + duration;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((lastUpdateTime == null) ? 0 : lastUpdateTime.hashCode());
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((options == null) ? 0 : options.hashCode());
		result = prime * result
				+ ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + timeZoneOffset;
		result = prime * result + ((voters == null) ? 0 : voters.hashCode());
		result = prime * result
				+ ((votingStartTime == null) ? 0 : votingStartTime.hashCode());
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
		Event other = (Event) obj;
		if (duration != other.duration)
			return false;
		if (id != other.id)
			return false;
		if (lastUpdateTime == null) {
			if (other.lastUpdateTime != null)
				return false;
		} else if (!lastUpdateTime.equals(other.lastUpdateTime))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (options == null) {
			if (other.options != null)
				return false;
		} else if (!options.equals(other.options))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (status != other.status)
			return false;
		if (timeZoneOffset != other.timeZoneOffset)
			return false;
		if (voters == null) {
			if (other.voters != null)
				return false;
		} else if (!voters.equals(other.voters))
			return false;
		if (votingStartTime == null) {
			if (other.votingStartTime != null)
				return false;
		} else if (!votingStartTime.equals(other.votingStartTime))
			return false;
		return true;
	}
    
}
