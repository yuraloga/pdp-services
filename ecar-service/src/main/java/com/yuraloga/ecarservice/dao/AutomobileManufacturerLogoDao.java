package com.yuraloga.ecarservice.dao;

import com.yuraloga.ecarservice.model.AutomobileManufacturerLogo;

import java.util.List;

/**
 * Created by yura on 4/19/17.
 */
public interface AutomobileManufacturerLogoDao {
    AutomobileManufacturerLogo save(AutomobileManufacturerLogo automobileManufacturerLogo);
    List<AutomobileManufacturerLogo> findAll();
}
