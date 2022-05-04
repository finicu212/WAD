package com.wad.firstmvc.repositories;

import com.wad.firstmvc.domain.Appointment;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
}
