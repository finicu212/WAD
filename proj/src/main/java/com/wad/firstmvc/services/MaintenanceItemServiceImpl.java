package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.MaintenanceItem;
import com.wad.firstmvc.repositories.MaintenanceItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MaintenanceItemServiceImpl implements MaintenanceItemService {
    @Autowired
    MaintenanceItemRepository maintenanceItemRepository;

    @Override
    public List<MaintenanceItem> findAll() {
        List<MaintenanceItem> maintenanceItems = new ArrayList<>();
        maintenanceItemRepository.findAll().forEach(maintenanceItems :: add);

        return maintenanceItems;
    }

    @Override
    public void save(MaintenanceItem mi) {
        maintenanceItemRepository.save(mi);
    }
}
