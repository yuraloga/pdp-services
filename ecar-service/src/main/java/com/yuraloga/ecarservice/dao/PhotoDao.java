package com.yuraloga.ecarservice.dao;

import com.yuraloga.ecarservice.model.Photo;

import java.sql.Blob;
import java.util.List;

/**
 * Created by yura on 4/8/17.
 */
public interface PhotoDao {
    List<Photo> findAll();
    List<Photo> findAllWithoutImageContent();
    Photo save(Photo photo);
    int update(Photo photo);
    int updateImageContent(Integer id, Blob imageContent);
    List<Photo> getByPhotoSetId(long photoSetId);
}
