package com.cloud.map.model;

import com.cloud.map.model.EMarkerType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class MarkerEntity {

    @Id
    private String id;

    private String name;

    private String address;

    private double lat;

    private double lng;

    private EMarkerType markerType;

}