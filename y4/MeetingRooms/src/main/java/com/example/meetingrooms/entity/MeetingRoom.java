package com.example.meetingrooms.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="meeting_room")
public class MeetingRoom {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="capacity")
	private Integer capacity;
	
	@Column(name="features")
	private String features;

	@OneToMany(cascade = CascadeType.ALL)
	private List<TimeInterval> unavailableIntervals;

	public MeetingRoom() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MeetingRoom(Integer id, String name, Integer capacity, String features) {
		super();
		this.id = id;
		this.name = name;
		this.capacity = capacity;
		this.features = features;
		this.unavailableIntervals = new ArrayList<>();
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

	public List<TimeInterval> getUnavailableIntervals() {
		return unavailableIntervals;
	}

	public void setUnavailableIntervals(List<TimeInterval> unavailableIntervals) {
		this.unavailableIntervals = unavailableIntervals;
	}
}
