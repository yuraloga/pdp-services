package com.yuraloga.ecarservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@JsonIgnoreProperties("hibernateLazyInitializer")
@Data
@Entity
@EqualsAndHashCode(exclude = {"photoSet"})
@ToString(exclude = {"content", "photoSet"})
public class Photo implements Serializable {
    @Id
    private Integer id;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "photoset_id",
        referencedColumnName = "id"
    )
    private PhotoSet photoSet;
    private String name;
    private byte[] content;
    private String imageUrl;
}
