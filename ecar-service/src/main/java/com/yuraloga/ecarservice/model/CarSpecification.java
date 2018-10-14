package com.yuraloga.ecarservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Values parsed from website.
 * Most of the values have <code>String</code> type
 */
@JsonIgnoreProperties("hibernateLazyInitializer")
@Data
@Entity
public class CarSpecification implements Serializable {
    @Id
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "automobile_manufacturer_id",
        referencedColumnName = "id"
    )
    private AutomobileManufacturer automobileManufacturer;
    // General information
    private String modelName;
    private String year;
    private String bodyType;
    private String numberOfDoorsSeats;
    private String equippedWeight;
    private String grossVehicleWeight;
    private BigDecimal aerodynamicResistanceCoef;
    private String maximumSpeed;
    private String accelerationTo100;
    private BigDecimal minimumTurningRadius;
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
    private BigDecimal volume;
    private BigDecimal compressionRatio;
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
    private BigDecimal fuelTankCapacity;

    // ecological characteristics
    @Column(name = "emissions_of_co2")
    private String emissionsOfCO2;
    private String environmentalClass;

    // album
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "photoset_id",
        referencedColumnName = "id"
    )
    private PhotoSet photoSet;
}
