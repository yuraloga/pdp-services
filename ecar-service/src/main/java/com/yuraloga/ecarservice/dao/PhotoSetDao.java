package com.yuraloga.ecarservice.dao;

import com.yuraloga.ecarservice.model.PhotoSet;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoSetDao extends PagingAndSortingRepository<PhotoSet, Integer> {
}
