package com.example.template.sample;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.template.model.entity.VehicleDataEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * SampleCousumerService.java
 * - 브로커로부터 메세지를 구독하여 로그로 출력 및 저장 
 *
 * @author myungki you
 * @created 2025. 8. 27.
 */

@Service
public class SampleCousumerService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final SampleWriteRepository writeRepository;
    private final ObjectMapper mapper = new ObjectMapper();

    public SampleCousumerService(SampleWriteRepository writeRepository) {
        this.writeRepository = writeRepository;
    }
    
    @KafkaListener(topics = "vehicle-data", groupId = "vehicle-consumer-group")
    public void consume(String message) {
    	logger.info("Thread: {} || message : {}", Thread.currentThread().getName(), message);
        try {
        	VehicleDataEntity vehicle = mapper.readValue(message, VehicleDataEntity.class);
        	
        	// ID가 없으면 항상 insert
            vehicle.setId(null);
            
            writeRepository.save(vehicle);
            logger.info("IMEI: {}, Time: {}, Lat: {}, Lng: {}, Speed: {}",
                    Optional.ofNullable(vehicle).map(VehicleDataEntity::getImei).orElse(null),
                    Optional.ofNullable(vehicle).map(VehicleDataEntity::getTime).orElse(null),
                    Optional.ofNullable(vehicle)
                            .map(VehicleDataEntity::getLocation)
                            .map(VehicleDataEntity.Location::getLat)
                            .orElse(null),
                    Optional.ofNullable(vehicle)
                            .map(VehicleDataEntity::getLocation)
                            .map(VehicleDataEntity.Location::getLng)
                            .orElse(null),
                    Optional.ofNullable(vehicle).map(VehicleDataEntity::getSpeed).orElse(null)
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
