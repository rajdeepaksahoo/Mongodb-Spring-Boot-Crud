package com.mongo.runner;

import com.mongo.crud.CrudApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class CustomCommandLineRunner {
    @Autowired
    private CrudApp crudApp;

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
//		Create
        crudApp.create(Map.of("name", "Amarendra", "age", 40, "hobbies", List.of("Wining War", "Taking Care Of Prajas")));
//		Read One
        crudApp.readOne("name", "Amarendra");
//		Update
        crudApp.update(Map.of("name", "Amarendra"), Map.of("name", "Amarendra Bahubali"));
//		Read All
        crudApp.readAll();
//		Delete
        crudApp.delete("name", "Amarendra Bahubali");
//		Read All
        crudApp.readAll();
        };
    }
}
