package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.MaintenanceItem;

import java.util.List;

public interface MaintenanceItemService {
    List<MaintenanceItem> findAll();
    void save(MaintenanceItem mi);
}
