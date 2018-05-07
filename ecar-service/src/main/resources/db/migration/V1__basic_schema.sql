CREATE TABLE automobile_manufacturer_logo (
  id            SERIAL PRIMARY KEY,
  content       BYTEA,
  image_url     VARCHAR(255) NOT NULL
);

CREATE TABLE automobile_manufacturer (
  id   SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  logo_id INT,
  CONSTRAINT UK_name UNIQUE (name),
  CONSTRAINT FK_logo FOREIGN KEY (logo_id) REFERENCES automobile_manufacturer_logo(id)
);
CREATE TABLE photoset (
  id   SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);
CREATE TABLE photo (
  id                         SERIAL PRIMARY KEY,
  photoset_id                INT NOT NULL,
  name                       VARCHAR(255) NOT NULL,
  content                    BYTEA,
  image_url                  VARCHAR(255) NOT NULL,
  FOREIGN KEY (photoset_id) REFERENCES photoset(id)
);
CREATE TABLE car_specification (
  id                                          SERIAL PRIMARY KEY,
  automobile_manufacturer_id                  INT NOT NULL,
-- general information
  model_name                                  VARCHAR(255) NOT NULL,
  year                                        VARCHAR(255),
  body_type                                   VARCHAR(255),
  number_of_doors_seats                       VARCHAR(255),
  equipped_weight                             VARCHAR(255),
  gross_vehicle_weight                        VARCHAR(255),
  aerodynamic_resistance_coef                 DECIMAL,
  maximum_speed                               VARCHAR(255),
  acceleration_to100                          VARCHAR(255),
  minimum_turning_radius                      DECIMAL,
  trunk_volume_min_max                        VARCHAR(255),
-- dimentions
  length                                      INT,
  width                                       INT,
  height                                      INT,
  wheelbase                                   INT,
  track_front_back                            VARCHAR(255),
  ground_clearance                            INT,
-- engine
  engine_type                                 VARCHAR(255),
  location                                    VARCHAR(255),
  volume                                      DECIMAL,
  compression_ratio                           DECIMAL,
  number_and_arrangement_of_cylinders         VARCHAR(255),
  cylinder_diameter_and_stoke_of_the_piston   VARCHAR(255),
  number_of_valves                            INT,
  power                                       VARCHAR(255),
  maximum_twisting_moment                     VARCHAR(255),
-- transmission
  transmition_type                            VARCHAR(255),
  drive_unit                                  VARCHAR(255),
  start_stop_system                           VARCHAR(255),
-- suspension
  front_wheels                                VARCHAR(255),
  rear_wheels                                 VARCHAR(255),
  tire_size                                   VARCHAR(255),
  disk_size                                   VARCHAR(255),
-- brakes
  front_brakes                                VARCHAR(255),
  rear_brakes                                 VARCHAR(255),
-- fuel consumption
  city_cycle                                  VARCHAR(255),
  country_cycle                               VARCHAR(255),
  mixed_cycle                                 VARCHAR(255),
  fuel_type                                   VARCHAR(255),
  fuel_tank_capacity                          DECIMAL,
-- ecological characteristics
  emissions_of_CO2                            VARCHAR(255),
  environmental_class                         VARCHAR(255),
-- album
  photoset_id                                 INT,
  FOREIGN KEY (automobile_manufacturer_id) REFERENCES automobile_manufacturer(id),
  FOREIGN KEY (photoset_id) REFERENCES photoset(id)
);
