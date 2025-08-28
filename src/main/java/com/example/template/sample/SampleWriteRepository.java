package com.example.template.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.example.template.model.entity.VehicleDataEntity;

/**
 * SampleRepository.java
 * - 쓰기 전용 Repository
 *
 * @author myungki you
 * @created 2025. 8. 27.
 */

@Repository
public class SampleWriteRepository {

	private final MongoTemplate mongoTemplate;

    public SampleWriteRepository(@Qualifier("mongoWriteTemplate") MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void save(VehicleDataEntity vehicleData) {
        mongoTemplate.save(vehicleData);
    }
}
