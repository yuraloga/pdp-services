package com.yuraloga.ecarservice.dao;

import com.yuraloga.ecarservice.model.AutomobileManufacturer;

import java.util.List;

/**
 * Created by yura on 4/8/17.
 */
public interface AutomobileManufacturerDao {
    AutomobileManufacturer save(AutomobileManufacturer automobileManufacturer);
    AutomobileManufacturer getByName(String name);
    List<AutomobileManufacturer> findAll();
    int update(AutomobileManufacturer automobileManufacturer);
}
