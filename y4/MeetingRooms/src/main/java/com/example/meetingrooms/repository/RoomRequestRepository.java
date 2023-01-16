package com.example.meetingrooms.repository;

import com.example.meetingrooms.entity.RoomRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public interface RoomRequestRepository extends JpaRepository<RoomRequest, Long> {
    List<RoomRequest> findByApproved(Boolean approved);

//    @Query("select r from Reservations r where r.dateEnd >=:date order by createdAt desc")
//    LinkedList<RoomRequest> findAllByDate(Date date);

}
