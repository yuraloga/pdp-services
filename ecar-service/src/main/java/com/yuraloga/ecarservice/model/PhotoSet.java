package com.yuraloga.ecarservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties("hibernateLazyInitializer")
@Data
@Entity
@Table(name = "photoset")
public class PhotoSet implements Serializable {
    @Id
    private Integer id;
    private String name;
    @BatchSize(size = 400)
    @JsonManagedReference
    @OneToMany(mappedBy = "photoSet")
    private List<Photo> photos;
}
