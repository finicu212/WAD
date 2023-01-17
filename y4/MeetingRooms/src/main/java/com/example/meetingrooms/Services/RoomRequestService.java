package com.example.meetingrooms.Services;

import com.example.meetingrooms.entity.RoomRequest;
import com.example.meetingrooms.repository.RoomRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomRequestService {

    @Autowired
    private RoomRequestRepository roomRequestRepository;

    public List<RoomRequest> getPendingRequests() {
        return roomRequestRepository.findByApproved(false);
    }

    public RoomRequest getRequestById(Long requestId) {
        return roomRequestRepository.findById(requestId).orElse(null);
    }

    public void saveRequest(RoomRequest roomRequest) {
        roomRequestRepository.save(roomRequest);
    }
}
