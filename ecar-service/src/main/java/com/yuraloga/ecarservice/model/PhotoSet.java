package com.yuraloga.ecarservice.model;

import lombok.Data;

/**
 * Created by yura on 4/1/17.
 */
@Data
public class PhotoSet {
    private Integer id;
    private String name;

    public PhotoSet(String name) {
        this.name = name;
    }
}
