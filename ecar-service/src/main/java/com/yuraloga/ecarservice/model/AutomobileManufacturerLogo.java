package com.yuraloga.ecarservice.model;

import lombok.Data;

import java.sql.Blob;

/**
 * Created by yura on 4/1/17.
 */
@Data
public class AutomobileManufacturerLogo {
    private Integer id;
    private Blob content;
    private String imageUrl;

    public AutomobileManufacturerLogo() {
    }

    public AutomobileManufacturerLogo(Integer id, Blob content, String imageUrl) {
        this.id = id;
        this.content = content;
        this.imageUrl = imageUrl;
    }

    public AutomobileManufacturerLogo(Blob content, String imageUrl) {
        this.content = content;
        this.imageUrl = imageUrl;
    }

    public AutomobileManufacturerLogo(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
