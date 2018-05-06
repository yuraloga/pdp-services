package com.yuraloga.ecarservice.dao.impl;

import com.yuraloga.ecarservice.dao.PhotoDao;
import com.yuraloga.ecarservice.dao.mappers.PhotoMapper;
import com.yuraloga.ecarservice.model.Photo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

/**
 * Created by yura on 4/8/17.
 */
@Slf4j
@Repository
public class PhotoDaoImpl implements PhotoDao {
    private static final String INSERT_QUERY = "INSERT INTO photo(photoset_id, name, content, image_url) VALUES(?, ?, ?, ?)";
    private static final String SELECT_BY_PHOTOSET_ID_QUERY = "SELECT * FROM photo p WHERE p.photoset_id = ?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM photo";
    private static final String FIND_ALL_WITHOUT_IMAGE_CONTENT_QUERY = "SELECT pl.* FROM (SELECT p.*, OCTET_LENGTH(p.content) AS blob_length from photo p) as pl WHERE pl.blob_length = 0";
    private static final String UPDATE_QUERY = "UPDATE photo p SET p.photoset_id=?, p.name=?, p.content=?, p.image_url=? WHERE p.id=?";
    private static final String UPDATE_IMAGE_CONTENT_QUERY = "UPDATE photo p SET p.content=? WHERE p.id=?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PhotoDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Photo> findAll() {
        return jdbcTemplate.query(FIND_ALL_QUERY, PhotoMapper::mapResultSet);
    }

    @Override
    public List<Photo> findAllWithoutImageContent() {
        return jdbcTemplate.query(FIND_ALL_WITHOUT_IMAGE_CONTENT_QUERY, PhotoMapper::mapResultSet);
    }

    @Transactional
    @Override
    public Photo save(Photo photo) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps =
                    connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, photo.getPhotoSetId());
            ps.setString(2, photo.getName());
            ps.setBlob(3, photo.getContent());
            ps.setString(4, photo.getImageUrl());
            return ps;
        }, keyHolder);
        photo.setId((Integer) keyHolder.getKey());
        return photo;
    }

    @Override
    public int update(Photo photo) {
        int updated = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY);
            ps.setInt(1, photo.getPhotoSetId());
            ps.setString(2, photo.getName());
            ps.setBlob(3, photo.getContent());
            ps.setString(4, photo.getImageUrl());
            ps.setInt(5, photo.getId());
            return ps;
        });
        if (updated == 0) {
            log.warn("Photo was not updated");
        }
        return updated;
    }

    @Override
    public int updateImageContent(Integer id, Blob imageContent) {
        int updated = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(UPDATE_IMAGE_CONTENT_QUERY);
            ps.setBlob(1, imageContent);
            ps.setInt(2, id);
            return ps;
        });
        if (updated == 0) {
            log.warn("Photo was not updated");
        }
        return updated;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Photo> getByPhotoSetId(long photoSetId) {
        return jdbcTemplate.query(SELECT_BY_PHOTOSET_ID_QUERY, new Object[] {photoSetId}, PhotoMapper::mapResultSet);
    }
}
