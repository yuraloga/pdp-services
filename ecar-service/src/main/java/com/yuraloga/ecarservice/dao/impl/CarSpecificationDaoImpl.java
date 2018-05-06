package com.yuraloga.ecarservice.dao.impl;

import com.yuraloga.ecarservice.dao.CarSpecificationDao;
import com.yuraloga.ecarservice.model.CarSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Collections;
import java.util.List;

/**
 * Created by yura on 4/9/17.
 */
@Slf4j
@Repository
public class CarSpecificationDaoImpl implements CarSpecificationDao {
    private static final String INSERT_QUERY = "INSERT INTO car_specification(automobile_manufacturer_id, model_name, year, body_type, number_of_doors_seats, equipped_weight, gross_vehicle_weight, aerodynamic_resistance_coef, maximum_speed, acceleration_to100, minimum_turning_radius, trunk_volume_min_max, length, width, height, wheelbase, track_front_back, ground_clearance, engine_type, location, volume, compression_ratio, number_and_arrangement_of_cylinders, cylinder_diameter_and_stoke_of_the_piston, number_of_valves, power, maximum_twisting_moment, transmition_type, drive_unit, start_stop_system, front_wheels, rear_wheels, tire_size, disk_size, front_brakes, rear_brakes, city_cycle, country_cycle, mixed_cycle, fuel_type, fuel_tank_capacity, emissions_of_CO2, environmental_class, photoset_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_BY_MODEL_NAME_QUERY = "SELECT * FROM car_specification cs WHERE cs.model_name = ?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CarSpecificationDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    @Override
    public CarSpecification save(CarSpecification carSpecification) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps =
                    connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
            setValueOrNull(ps, 1, carSpecification.getAutomobileManufacturerId());
            ps.setString(2, carSpecification.getModelName());
            ps.setString(3, carSpecification.getYear());
            ps.setString(4, carSpecification.getBodyType());
            ps.setString(5, carSpecification.getNumberOfDoorsSeats());
            ps.setString(6, carSpecification.getEquippedWeight());
            ps.setString(7, carSpecification.getGrossVehicleWeight());
            setValueOrNull(ps, 8, carSpecification.getAerodynamicResistanceCoef());
            ps.setString(9, carSpecification.getMaximumSpeed());
            ps.setString(10, carSpecification.getAccelerationTo100());
            setValueOrNull(ps, 11, carSpecification.getMinimumTurningRadius());
            ps.setString(12, carSpecification.getTrunkVolumeMinMax());

            setValueOrNull(ps, 13, carSpecification.getLength());
            setValueOrNull(ps, 14, carSpecification.getWidth());
            setValueOrNull(ps, 15, carSpecification.getHeight());
            setValueOrNull(ps, 16, carSpecification.getWheelbase());
            ps.setString(17, carSpecification.getTrackFrontBack());
            setValueOrNull(ps, 18, carSpecification.getGroundClearance());

            ps.setString(19, carSpecification.getEngineType());
            ps.setString(20, carSpecification.getLocation());
            ps.setDouble(21, carSpecification.getVolume());
            setValueOrNull(ps, 22, carSpecification.getCompressionRatio());
            ps.setString(23, carSpecification.getNumberAndArrangementOfCylinders());
            ps.setString(24, carSpecification.getCylinderDiameterAndStokeOfThePiston());
            setValueOrNull(ps, 25, carSpecification.getNumberOfValves());
            ps.setString(26, carSpecification.getPower());
            ps.setString(27, carSpecification.getMaximumTwistingMoment());

            ps.setString(28, carSpecification.getTransmitionType());
            ps.setString(29, carSpecification.getDriveUnit());
            ps.setString(30, carSpecification.getStartStopSystem());

            ps.setString(31, carSpecification.getFrontWheels());
            ps.setString(32, carSpecification.getRearWheels());
            ps.setString(33, carSpecification.getTireSize());
            ps.setString(34, carSpecification.getDiskSize());

            ps.setString(35, carSpecification.getFrontBrakes());
            ps.setString(36, carSpecification.getRearBrakes());

            ps.setString(37, carSpecification.getCityCycle());
            ps.setString(38, carSpecification.getCountryCycle());
            ps.setString(39, carSpecification.getMixedCycle());
            ps.setString(40, carSpecification.getFuelType());
            setValueOrNull(ps, 41, carSpecification.getFuelTankCapacity());

            ps.setString(42, carSpecification.getEmissionsOfCO2());
            ps.setString(43, carSpecification.getEnvironmentalClass());

            ps.setInt(44, carSpecification.getPhotoSetId());
            return ps;
        }, keyHolder);
        carSpecification.setId((Integer) keyHolder.getKey());
        return carSpecification;
    }

    private void setValueOrNull(PreparedStatement ps, int index, Double value) throws SQLException {
        if (value != null) {
            ps.setDouble(index, value);
        } else {
            ps.setNull(index, Types.DOUBLE);
        }
    }

    private void setValueOrNull(PreparedStatement ps, int index, Integer value) throws SQLException {
        if (value != null) {
            ps.setInt(index, value);
        } else {
            ps.setNull(index, Types.INTEGER);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<CarSpecification> findByModelName(String modelName) {
        // TODO: add functionality
        // return jdbcTemplate.query(SELECT_BY_MODEL_NAME_QUERY, new Object[] {modelName}, CarSpecificationMapper::mapResultSet);
        return Collections.emptyList();
    }
}
