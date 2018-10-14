package com.yuraloga.ecarservice.service;

import com.yuraloga.ecarservice.controller.request.CarSpecificationRequest;
import com.yuraloga.ecarservice.model.CarSpecification;

import java.util.List;

public interface CarSpecificationService {
    CarSpecification getCarSpecification(int id);
    List<CarSpecification> getCarSpecificationByModelNameStartingWith(String modelName);
    List<CarSpecification> getCarSpecifications(CarSpecificationRequest request);
}
