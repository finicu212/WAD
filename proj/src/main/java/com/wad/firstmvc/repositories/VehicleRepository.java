package com.wad.firstmvc.repositories;

import com.wad.firstmvc.domain.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
}
