package com.yuraloga.ecarservice.service;

import com.yuraloga.ecarservice.model.AutomobileManufacturer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AutomobileManufacturerService {
    Page<AutomobileManufacturer> getCarModels(Pageable pageable);
    AutomobileManufacturer getCarModel(String name);
}
