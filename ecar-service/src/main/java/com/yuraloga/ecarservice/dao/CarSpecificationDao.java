package com.yuraloga.ecarservice.dao;

import com.yuraloga.ecarservice.model.CarSpecification;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarSpecificationDao extends PagingAndSortingRepository<CarSpecification, Integer> {
    List<CarSpecification> findByModelName(String modelName);
}
