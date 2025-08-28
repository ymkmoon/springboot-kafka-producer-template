package com.example.template.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * VehicleDataEntity.java
 * - Producer (IOT) JSON 데이터 구조
 *
 * @author myungki you
 * @created 2025. 8. 26.
 */
@Document(collection = "tb_vehicle_operation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDataEntity {
	@Id
    private String id;
    
    private String imei;
	private int speed;
    private Location location;
    private String time;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Location {
        private double lat;
        private double lng;
    }
}
