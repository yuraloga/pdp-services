package com.yuraloga.ecarservice.dao;

import com.yuraloga.ecarservice.model.CarSpecification;

import java.util.List;

/**
 * Created by yura on 4/9/17.
 */
public interface CarSpecificationDao {
    CarSpecification save(CarSpecification carSpecification);
    List<CarSpecification> findByModelName(String modelName);
}
