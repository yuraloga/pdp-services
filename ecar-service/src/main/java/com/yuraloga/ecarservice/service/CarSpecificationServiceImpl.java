package com.yuraloga.ecarservice.service;

import com.yuraloga.ecarservice.dao.CarSpecificationDao;
import com.yuraloga.ecarservice.exceptions.NotFoundException;
import com.yuraloga.ecarservice.model.CarSpecification;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CarSpecificationServiceImpl implements CarSpecificationService {
    private static final String CAR_SPECIFICATION_WAS_NOT_FOUND_MESSAGE = "Car Specification was not found";

    private final CarSpecificationDao carSpecificationDao;

    @Transactional(readOnly = true)
    @Override
    public CarSpecification getCarSpecification(int id) {
        log.debug("Finding car specification by id: {}", id);
        return carSpecificationDao.findById(id)
                .orElseThrow(() -> new NotFoundException(CAR_SPECIFICATION_WAS_NOT_FOUND_MESSAGE));
    }

    @Transactional(readOnly = true)
    @Override
    public List<CarSpecification> getCarSpecificationByModelNameStartingWith(String modelName) {
        log.debug("Finding car specifications by modelName: {}", modelName);
        return carSpecificationDao.findByModelNameStartingWith(modelName);
    }
}
