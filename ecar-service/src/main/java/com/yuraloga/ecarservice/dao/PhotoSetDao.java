package com.yuraloga.ecarservice.dao;

import com.yuraloga.ecarservice.model.PhotoSet;

import java.util.List;

/**
 * Created by yura on 4/6/17.
 */
public interface PhotoSetDao {
    PhotoSet save(PhotoSet photoSet);
    List<PhotoSet> getById(long id);
}
