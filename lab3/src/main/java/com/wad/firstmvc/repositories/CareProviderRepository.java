package com.wad.firstmvc.repositories;

import com.wad.firstmvc.domain.CareProvider;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component("careProviderRepository")
public interface CareProviderRepository extends CrudRepository<CareProvider, Long> {
}
