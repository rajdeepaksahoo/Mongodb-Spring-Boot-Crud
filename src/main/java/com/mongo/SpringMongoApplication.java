package com.mongo;

import com.mongo.crud.CrudApp;
import com.mongodb.client.*;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class SpringMongoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
