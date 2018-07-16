package com.yuraloga.ecarservice.dao;

import com.yuraloga.ecarservice.model.AutomobileManufacturer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomobileManufacturerDao extends PagingAndSortingRepository<AutomobileManufacturer, Integer> {
    AutomobileManufacturer findByName(String name);
}
