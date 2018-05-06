package com.yuraloga.ecarservice.dao.impl;

import com.yuraloga.ecarservice.dao.AutomobileManufacturerLogoDao;
import com.yuraloga.ecarservice.model.AutomobileManufacturerLogo;
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
 * Created by yura on 4/19/17.
 */
@Slf4j
@Repository
public class AutomobileManufacturerLogoDaoImpl implements AutomobileManufacturerLogoDao {
    private static final String INSERT_QUERY = "INSERT INTO automobile_manufacturer_logo(content, image_url) VALUES(?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM automobile_manufacturer_logo";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AutomobileManufacturerLogoDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    @Override
    public AutomobileManufacturerLogo save(AutomobileManufacturerLogo automobileManufacturerLogo) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps =
                    connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
            ps.setBlob(1, automobileManufacturerLogo.getContent());
            ps.setString(2, automobileManufacturerLogo.getImageUrl());
            return ps;
        }, keyHolder);
        automobileManufacturerLogo.setId((Integer) keyHolder.getKey());
        return automobileManufacturerLogo;
    }

    @Transactional
    @Override
    public List<AutomobileManufacturerLogo> findAll() {
        return jdbcTemplate.query(SELECT_ALL_QUERY, new BeanPropertyRowMapper(AutomobileManufacturerLogo.class));
    }
}
