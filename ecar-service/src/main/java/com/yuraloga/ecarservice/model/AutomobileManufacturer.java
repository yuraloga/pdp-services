package com.yuraloga.ecarservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by yura on 4/1/17.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AutomobileManufacturer {
    private Integer id;
    private String name;
    private Integer logoId;

    public AutomobileManufacturer(String name) {
        this.name = name;
    }
}
