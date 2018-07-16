package com.yuraloga.ecarservice.controller.request;

import lombok.Data;

@Data
public class CarSpecificationRequest {
    private String modelName;
    private String bodyType;
    private String year;
}
