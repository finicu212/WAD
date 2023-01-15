package com.example.meetingrooms.Services;

import com.example.meetingrooms.entity.MeetingRoom;
import com.example.meetingrooms.entity.Reservations;
import com.example.meetingrooms.repository.MeetingRoomRepository;
import com.example.meetingrooms.repository.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
public class ReservationsServiceImp implements ReservationService {

    @Autowired
    ReservationsRepository reservationsRepository;

    @Autowired
    MeetingRoomRepository meetingRoomRepository;

    public ReservationsServiceImp() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ReservationsServiceImp(com.example.meetingrooms.repository.ReservationsRepository reservationsRepository) {
        super();
        reservationsRepository = reservationsRepository;
    }

    @Override
    public LinkedList<Reservations> getFutureBookings() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(new Date());
        format = String.format("%s 00:00:00", format.split(" ")[0]);
        LinkedList<Reservations> allByDate = null;
        try {
            allByDate = reservationsRepository.findAllByDate(dateFormat.parse(format));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return allByDate;
    }

    @Override
    public List<Reservations> getReservations() {
        return (List<Reservations>) reservationsRepository.findAll();
    }

    @Override
    public Reservations findById(Integer id) {
        Optional<Reservations> optReservation = reservationsRepository.findById(id); // returns java8 optional
        if (optReservation.isPresent()) {
            return optReservation.get();
        } else {
            throw new MissingResourceException("Reservation", "Id", id.toString());
        }
    }

    @Override
    public Boolean deleteReservationsById(Integer id) {
        Optional<Reservations> optReservation = reservationsRepository.findById(id); // returns java8 optional
        if (optReservation.isPresent()) {
            reservationsRepository.delete(optReservation.get());
            return true;
        } else {
            throw new MissingResourceException("Reservation", "Id", id.toString());
//            throw new MissingResourceException("Reservation", "Id", id.toString());
        }
    }

    @Override
    public List<Reservations> findByName(String name) {
        return (List<Reservations>) reservationsRepository.findByName(name);
    }

    @Override
    public Reservations createReservation(Reservations reservation) {
        System.out.println("Reservation to create: " + reservation);
        MeetingRoom room = meetingRoomRepository.checkAvailability(reservation.getDateBegin(), reservation.getDateEnd(), reservation.getRoomId());
        System.out.println("Room to book: " + room);
        if (room != null) {
            Reservations r = reservationsRepository.save(reservation);
            return r;
        } else
            return null;
    }


}
