package com.mongo.crud;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CrudApp {

    @Autowired
    private MongoCollection mongoCollection;

    public void create(Map<String,Object> data){
        InsertOneResult insertOneResult = mongoCollection.insertOne(new Document(data));
        System.out.println(insertOneResult);
    }

    public void update(Map<String,Object> filterData,Map<String,Object> newData){
        UpdateResult updateResult = mongoCollection.updateOne(new Document(filterData),new Document(Map.of("$set",new Document(newData))));
        System.out.println(updateResult);
    }

    public void delete(String key, Object value){
        DeleteResult deleteResult = mongoCollection.deleteOne(new Document(Map.of(key,value)));
        System.out.println(deleteResult);
    }

    public void readOne(String key, Object value){
        System.out.println();
        FindIterable<Document> findIterable = mongoCollection.find(new Document(Map.of(key,value)));
        findIterable.forEach(i-> i.forEach((k,v)-> System.out.println(k+" : "+v)));
    }

    public void readAll(){
        FindIterable<Document> findIterable = mongoCollection.find();
        System.out.println();
        findIterable.forEach(i-> i.forEach((k,v)-> System.out.println(k+" : "+v)));
    }
}
