package com.yuraloga.ecarservice.dao.impl;

import com.yuraloga.ecarservice.dao.PhotoSetDao;
import com.yuraloga.ecarservice.model.PhotoSet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

/**
 * Created by yura on 4/6/17.
 */
@Slf4j
@Repository
public class PhotoSetDaoImpl implements PhotoSetDao {
    private static final String INSERT_QUERY = "INSERT INTO photoSet(name) VALUES(?)";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM photoSet ps WHERE ps.id = ?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PhotoSetDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    @Override
    public PhotoSet save(PhotoSet photoSet) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps =
                    connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, photoSet.getName());
            return ps;
        }, keyHolder);
        photoSet.setId((Integer) keyHolder.getKey());
        return photoSet;
    }

    @Transactional(readOnly = true)
    @Override
    public List<PhotoSet> getById(long id) {
        return jdbcTemplate.query(SELECT_BY_ID_QUERY, new Object[] {id}, new BeanPropertyRowMapper(PhotoSet.class));
    }
}
