package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.HealthIssue;
import org.springframework.stereotype.Service;

import java.util.List;

public interface HealthIssueService {
    void save(HealthIssue healthIssue);
    List<HealthIssue> findAll();
}
