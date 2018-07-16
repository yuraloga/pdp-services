package com.yuraloga.ecarservice.dao;

import com.yuraloga.ecarservice.model.Photo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoDao extends PagingAndSortingRepository<Photo, Integer> {
    List<Photo> findByPhotoSetId(long photoSetId);
}
