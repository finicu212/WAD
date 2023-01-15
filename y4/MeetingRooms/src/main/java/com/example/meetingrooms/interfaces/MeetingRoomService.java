package com.example.meetingrooms.interfaces;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.meetingrooms.entity.MeetingRoom;

@Service
@Transactional
public interface MeetingRoomService {
	void addRoom(MeetingRoom meetingroom);
    List<MeetingRoom> getAllRooms();
    MeetingRoom findById(Integer id);
    MeetingRoom updateRoom(MeetingRoom meetingroom, Integer id);
    Boolean deleteRoom(Integer id);
    List<MeetingRoom> findMeetingRoomAvailable(Date db, Date de);
}
