package com.yuraloga.ecarservice.service.impl;

import com.yuraloga.ecarservice.dao.AutomobileManufacturerDao;
import com.yuraloga.ecarservice.model.AutomobileManufacturer;
import com.yuraloga.ecarservice.service.AutomobileManufacturerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
@AllArgsConstructor
public class AutomobileManufacturerServiceImpl implements AutomobileManufacturerService {
    private final AutomobileManufacturerDao automobileManufacturerDao;

    @Transactional(readOnly = true)
    @Override
    public Page<AutomobileManufacturer> getCarModels(Pageable pageable) {
        log.debug("Finding automobile manufacturers: {}", pageable);
        return automobileManufacturerDao.findAll(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public AutomobileManufacturer getCarModel(String name) {
        log.debug("Finding automobile manufacturer by name: {}", name);
        return automobileManufacturerDao.findByName(name);
    }

}
