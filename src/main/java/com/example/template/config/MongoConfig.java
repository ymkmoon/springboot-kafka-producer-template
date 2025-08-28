package com.example.template.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

/**
 * MongoConfig.java
 * - 몽고디비 설정 클래스
 *
 * @author myungki you
 * @created 2025. 8. 26.
 */

@Configuration
public class MongoConfig {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Value("${spring.data.mongodb.write-uri}")
    private String writeUri;

    @Value("${spring.data.mongodb.read-uri}")
    private String readUri;
    
    @Value("${spring.data.mongodb.database}")
    private String databaseName;

    // Write용 MongoTemplate
    @Bean(name = "mongoWriteTemplate")
    @Primary
    public MongoTemplate mongoWriteTemplate() {
        MongoClient client = MongoClients.create(writeUri);
        return new MongoTemplate(client, databaseName);
    }

    // Read용 MongoTemplate
    @Bean(name = "mongoReadTemplate")
    public MongoTemplate mongoReadTemplate() {
        MongoClient client = MongoClients.create(readUri);
        return new MongoTemplate(client, databaseName);
    }
}