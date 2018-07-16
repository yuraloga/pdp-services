package com.yuraloga.ecarservice.dao;

import com.yuraloga.ecarservice.model.AutomobileManufacturerLogo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomobileManufacturerLogoDao extends PagingAndSortingRepository<AutomobileManufacturerLogo, Integer> {
}
