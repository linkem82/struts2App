/**
 * Copyright:	Copyright (c) From Down & Around, Inc.
 */

package com.emilio.projects.model;

import javax.persistence.*;

@Entity @Table( name="BROADCAST", schema="S2APP" )
@PrimaryKeyJoinColumn(name="LOCATION_PK")
public class Broadcast extends Location {

    private String stationIdentifier;
    private String network;

    @Column(name="CALLSIGN")
    public String getStationIdentifier() {
        return stationIdentifier;
    }

    public void setStationIdentifier(String stationIdentifier) {
        this.stationIdentifier = stationIdentifier;
    }

    @Column(name="NETWORK")
    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((network == null) ? 0 : network.hashCode());
		result = prime
				* result
				+ ((stationIdentifier == null) ? 0 : stationIdentifier
						.hashCode());
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
		Broadcast other = (Broadcast) obj;
		if (network == null) {
			if (other.network != null)
				return false;
		} else if (!network.equals(other.network))
			return false;
		if (stationIdentifier == null) {
			if (other.stationIdentifier != null)
				return false;
		} else if (!stationIdentifier.equals(other.stationIdentifier))
			return false;
		return true;
	}
    
}
