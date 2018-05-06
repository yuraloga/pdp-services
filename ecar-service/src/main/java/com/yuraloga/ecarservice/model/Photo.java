package com.yuraloga.ecarservice.model;

import lombok.Data;

import java.sql.Blob;

/**
 * Created by yura on 4/1/17.
 */
@Data
public class Photo {
    private Integer id;
    private Integer photoSetId;
    private String name;
    private Blob content;
    private String imageUrl;

    public Photo(Integer id, Integer photoSetId, String name, Blob content, String imageUrl) {
        this.id = id;
        this.photoSetId = photoSetId;
        this.name = name;
        this.content = content;
        this.imageUrl = imageUrl;
    }

    public Photo(Integer photoSetId, String name, Blob blob, String imageUrl) {
        this.photoSetId = photoSetId;
        this.name = name;
        this.content = blob;
        this.imageUrl = imageUrl;
    }
}
