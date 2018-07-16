package com.yuraloga.ecarservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@JsonIgnoreProperties("hibernateLazyInitializer")
@Data
@Entity
public class AutomobileManufacturer implements Serializable {
    @Id
    private Integer id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "logo_id",
        referencedColumnName = "id"
    )
    private AutomobileManufacturerLogo automobileManufacturerLogo;
}
