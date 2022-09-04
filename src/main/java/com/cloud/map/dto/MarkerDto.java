package com.cloud.map.dto;

import com.cloud.map.model.MarkerEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarkerDto {


    private String name;

    private String address;

    private double lat;

    private double lng;

    public MarkerDto(MarkerEntity entity) {
        this.name = entity.getName();
        this.address = entity.getAddress();
        this.lat = entity.getLat();
        this.lng = entity.getLng();
    }
}