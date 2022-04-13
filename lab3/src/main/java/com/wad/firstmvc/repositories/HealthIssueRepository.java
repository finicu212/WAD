package com.wad.firstmvc.repositories;

import com.wad.firstmvc.domain.HealthIssue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component("healthIssueRepository")
public interface HealthIssueRepository extends CrudRepository<HealthIssue, Long> {
}
