package com.yuraloga.ecarservice.dao;

import com.yuraloga.ecarservice.controller.request.CarSpecificationRequest;
import com.yuraloga.ecarservice.model.CarSpecification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarSpecificationDao extends PagingAndSortingRepository<CarSpecification, Integer> {

    List<CarSpecification> findByModelName(String modelName);

    List<CarSpecification> findByModelNameStartingWith(String modelName);

    @Query(
            "SELECT cs FROM CarSpecification cs WHERE " +
                    "cs.modelName LIKE :#{#request.modelName}% AND " +
                    "(:#{#request.bodyType} IS NULL OR cs.bodyType = :#{#request.bodyType}) AND " +
                    "(:#{#request.year} IS NULL OR cs.year LIKE %:#{#request.year}%)"
    )
    List<CarSpecification> find(@Param("request") CarSpecificationRequest request);
}
