package com.yuraloga.ecarservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
    @JsonManagedReference
    @OneToMany(mappedBy = "photoSet")
    private List<Photo> photos;
}
