package com.emilio.projects.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "Contestant", schema = "S2APP")
public class Contestant implements Serializable {
	
	
	private Long id;
	private String name;
	private String description;
	private Event event;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@ManyToOne
    @JoinColumn(name="EVENT_FK")   
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}	
	
	

}
