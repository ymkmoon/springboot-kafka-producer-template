package com.example.template.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.template.model.entity.VehicleDataEntity;

/**
 * KafkaProducerService.java
 *
 * @author myungki you
 * @created 2025. 8. 28.
 */

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, VehicleDataEntity> kafkaTemplate;
    private static final String TOPIC = "vehicle-data";

    public KafkaProducerService(KafkaTemplate<String, VehicleDataEntity> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(VehicleDataEntity vehicle) {
        kafkaTemplate.send(TOPIC, vehicle);
        System.out.println("[KafkaProducer] Sent VehicleDataEntity: " + vehicle);
    }
}