package com.yuraloga.ecarservice.model;

import lombok.Data;

/**
 * Created by yura on 4/1/17.
 */
@Data
public class CarSpecification {
    private Integer id;
    private Integer automobileManufacturerId;
    // General information
    private String modelName;
    private String year;
    private String bodyType;
    private String numberOfDoorsSeats;
    private String equippedWeight;
    private String grossVehicleWeight;
    private Double aerodynamicResistanceCoef;
    private String maximumSpeed;
    private String accelerationTo100;
    private Double minimumTurningRadius;
    private String trunkVolumeMinMax;
    // dimentions
    private Integer length;
    private Integer width;
    private Integer height;
    private Integer wheelbase;
    private String trackFrontBack;
    private Integer groundClearance;
    // engine
    private String engineType;
    private String location; // enum
    private Double volume;
    private Double compressionRatio;
    private String numberAndArrangementOfCylinders;
    private String cylinderDiameterAndStokeOfThePiston;
    private Integer numberOfValves;
    private String power;
    private String maximumTwistingMoment;

    // transmission
    private String transmitionType;
    private String driveUnit;
    private String startStopSystem;

    // suspension
    private String frontWheels;
    private String rearWheels;
    private String tireSize;
    private String diskSize;

    // brakes
    private String frontBrakes;
    private String rearBrakes;

    // fuel consumption
    private String cityCycle;
    private String countryCycle;
    private String mixedCycle;
    private String fuelType;
    private Double fuelTankCapacity;

    // ecological characteristics
    private String emissionsOfCO2;
    private String environmentalClass;

    // album
    private Integer photoSetId;
}
