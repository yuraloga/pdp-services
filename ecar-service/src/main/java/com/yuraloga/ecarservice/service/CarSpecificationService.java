package com.yuraloga.ecarservice.service;

import com.yuraloga.ecarservice.model.CarSpecification;

import java.util.List;

public interface CarSpecificationService {
    CarSpecification getCarSpecification(int id);
    List<CarSpecification> getCarSpecificationByModelNameStartingWith(String modelName);
}
