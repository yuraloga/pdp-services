package com.yuraloga.ecarservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@JsonIgnoreProperties("hibernateLazyInitializer")
@Data
@Entity
public class AutomobileManufacturerLogo implements Serializable {
    @Id
    private Integer id;
    private byte[] content;
    private String imageUrl;
}
