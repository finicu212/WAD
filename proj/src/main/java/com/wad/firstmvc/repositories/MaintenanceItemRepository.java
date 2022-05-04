package com.wad.firstmvc.repositories;

import com.wad.firstmvc.domain.MaintenanceItem;
import org.springframework.data.repository.CrudRepository;

public interface MaintenanceItemRepository extends CrudRepository<MaintenanceItem, Long> {
}
