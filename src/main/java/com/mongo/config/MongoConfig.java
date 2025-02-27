package com.mongo.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {
    @Value("${mongo.db.uri}")
    private String uri;

    @Value("${mongo.db.database}")
    private String database;

    @Value("${mongo.db.collection}")
    private String collection;

    @Bean
    public MongoClient mongoClient(){
        return MongoClients.create(uri);
    }

    @Bean
    public MongoDatabase mongoDatabase(){
        return mongoClient().getDatabase(database);
    }

    @Bean
    public MongoCollection mongoD(){
        return mongoDatabase().getCollection(collection);
    }
}
