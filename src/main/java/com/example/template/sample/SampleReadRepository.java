package com.example.template.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.example.template.model.entity.VehicleDataEntity;

/**
 * SampleRepository.java
 * - 읽기 전용 Repository
 *
 * @author myungki you
 * @created 2025. 8. 27.
 */

@Repository
public class SampleReadRepository {

	private final MongoTemplate mongoTemplate;

    public SampleReadRepository(@Qualifier("mongoReadTemplate") MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public VehicleDataEntity findById(String id) {
        return mongoTemplate.findById(id, VehicleDataEntity.class);
    }
}
