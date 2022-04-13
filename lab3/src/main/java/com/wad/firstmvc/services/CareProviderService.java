package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.CareProvider;
import org.springframework.stereotype.Component;

import java.util.List;

public interface CareProviderService {
    void save(CareProvider careProvider);
    List<CareProvider> findAll();
}
