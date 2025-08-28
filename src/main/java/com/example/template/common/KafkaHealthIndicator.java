package com.example.template.common;

import java.util.Properties;

import org.apache.kafka.clients.admin.AdminClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * KafkaHealthIndicator.java
 * - HealthCheck : Kafka Listener 가 정상적으로 브로커와 연결돼 있는지도 체크
 *
 * @author myungki you
 * @created 2025. 8. 27.
 */

@Component
public class KafkaHealthIndicator implements HealthIndicator {
	
	@Value("${spring.kafka.consumer.bootstrap-servers}")
    private String serverName;

    @Override
    public Health health() {
        try {
            Properties props = new Properties();
            props.put("bootstrap.servers", serverName); // 브로커 주소
            try (AdminClient client = AdminClient.create(props)) {
                client.listTopics().names().get(); // 토픽 조회 시도
            }
            return Health.up().build();
        } catch (Exception e) {
            return Health.down(e).build();
        }
    }
}