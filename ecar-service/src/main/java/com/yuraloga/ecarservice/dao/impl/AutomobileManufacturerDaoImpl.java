package com.yuraloga.ecarservice.dao.impl;

import com.yuraloga.ecarservice.dao.AutomobileManufacturerDao;
import com.yuraloga.ecarservice.model.AutomobileManufacturer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

/**
 * Created by yura on 4/8/17.
 */
@Slf4j
@Repository
public class AutomobileManufacturerDaoImpl implements AutomobileManufacturerDao {
    private static final String INSERT_QUERY = "INSERT INTO automobile_manufacturer(name) VALUES(?)";
    private static final String UPDATE_QUERY = "UPDATE automobile_manufacturer am SET am.name=?, am.logo_id=? WHERE am.id=?";
    private static final String SELECT_BY_NAME_QUERY = "SELECT * FROM automobile_manufacturer am WHERE am.name = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM automobile_manufacturer";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AutomobileManufacturerDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    @Override
    public AutomobileManufacturer save(AutomobileManufacturer automobileManufacturer) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps =
                    connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, automobileManufacturer.getName());
            return ps;
        }, keyHolder);
        automobileManufacturer.setId((Integer) keyHolder.getKey());
        return automobileManufacturer;
    }

    @Transactional(readOnly = true)
    @Override
    public AutomobileManufacturer getByName(String name) {
        List<AutomobileManufacturer> results = jdbcTemplate.query(SELECT_BY_NAME_QUERY, new Object[] {name}, new BeanPropertyRowMapper(AutomobileManufacturer.class));
        if (CollectionUtils.isEmpty(results)) {
            return null;
        } else {
            return results.get(0);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<AutomobileManufacturer> findAll() {
        return jdbcTemplate.query(SELECT_ALL_QUERY, new BeanPropertyRowMapper(AutomobileManufacturer.class));
    }

    @Override
    public int update(AutomobileManufacturer automobileManufacturer) {
        int updated = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY);
            ps.setString(1, automobileManufacturer.getName());
            ps.setInt(2, automobileManufacturer.getLogoId());
            ps.setInt(3, automobileManufacturer.getId());
            return ps;
        });
        if (updated == 0) {
            log.warn("Automobile Manufacturer was not updated");
        }
        return updated;
    }
}
