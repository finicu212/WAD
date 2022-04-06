package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.HealthService;

import java.util.List;

public interface HealthServiceService {
    void save(HealthService healthService);
    List<HealthService> findAll();
}
