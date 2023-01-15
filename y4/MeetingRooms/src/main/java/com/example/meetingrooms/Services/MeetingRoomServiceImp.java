package com.example.meetingrooms.Services;

import com.example.meetingrooms.entity.MeetingRoom;
import com.example.meetingrooms.interfaces.MeetingRoomService;
import com.example.meetingrooms.repository.MeetingRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.MissingResourceException;
import java.util.Optional;

@Service
@Transactional
public class MeetingRoomServiceImp implements MeetingRoomService{

	@Autowired
	MeetingRoomRepository meetingRoomRepository;
	
	public MeetingRoomServiceImp(MeetingRoomRepository meetingRoomRepository) {
		super();
		this.meetingRoomRepository = meetingRoomRepository;
	}
	

	public MeetingRoomServiceImp() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public void createMeetingRoom(MeetingRoom meetingroom) {
		meetingRoomRepository.save(meetingroom);
		
	}

	@Override
	public List<MeetingRoom> getMeetingRoom() {
		return (List<MeetingRoom>) meetingRoomRepository.findAll();
	}

	@Override
	public MeetingRoom findById(Integer id) {
		 Optional<MeetingRoom> optMeetingRoom = meetingRoomRepository.findById(id); // returns java8 optional
		    if (optMeetingRoom.isPresent()) {
		        return optMeetingRoom.get();
		    } else {
		       throw new MissingResourceException("MeetingRoom", "Id", id.toString());
		    }
	}

	@Override
	public MeetingRoom update(MeetingRoom meetingroom, Integer id) {
		Optional<MeetingRoom> optMeetingRoom = meetingRoomRepository.findById(id); // returns java8 optional
	    if (optMeetingRoom.isPresent()) {
	    	MeetingRoom newRoom = optMeetingRoom.get();
	    	newRoom.setName(meetingroom.getName());
	    	newRoom.setCapacity(meetingroom.getCapacity());
	    	newRoom.setLocation(meetingroom.getLocation());

	        MeetingRoom updatedroom = meetingRoomRepository.save(newRoom);
	        return updatedroom;
	    } else {
	    	throw new MissingResourceException("MeetingRoom", "Id", id.toString());
	    }
	}

	@Override
	public Boolean deleteMeetingRoomById(Integer id) {
		Optional<MeetingRoom> optMeetingRoom = meetingRoomRepository.findById(id); // returns java8 optional
	    if (optMeetingRoom.isPresent()) {
	    	meetingRoomRepository.delete(optMeetingRoom.get());
	        return true;
	    } else {
	       throw new MissingResourceException("MeetingRoom", "Id", id.toString());
	    }
	}

	@Override
	public List<MeetingRoom> findMeetingRoomAvailable(Date db, Date de) {
		return (List<MeetingRoom>) meetingRoomRepository.findMeetingRoomAvailable(db, de);
	}


}
