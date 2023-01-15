package com.example.meetingrooms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="meeting_room")
public class MeetingRoom extends AuditEntity{
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="capacity")
	private Integer capacity;
	
	@Column(name="features")
	private String features;

	public MeetingRoom() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MeetingRoom(Integer id, String name, Integer capacity, String location) {
		super();
		this.id = id;
		this.name = name;
		this.capacity = capacity;
		this.features = features;
	}

	public MeetingRoom( String name, Integer capacity, String location) {
		super();
		this.name = name;
		this.capacity = capacity;
		this.features = features;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}
	
	

}
