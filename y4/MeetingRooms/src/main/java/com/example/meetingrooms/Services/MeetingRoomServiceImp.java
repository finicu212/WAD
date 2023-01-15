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
	public void addRoom(MeetingRoom meetingroom) {
		meetingRoomRepository.save(meetingroom);
		
	}

	@Override
	public List<MeetingRoom> getAllRooms() {
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
	public MeetingRoom updateRoom(MeetingRoom meetingroom, Integer id) {
		meetingroom.setId(id);
		return meetingRoomRepository.save(meetingroom);
	}

	@Override
	public Boolean deleteRoom(Integer id) {
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
