package com.cloud.map.config;

import com.cloud.map.model.MarkerEntity;
import com.cloud.map.repo.MarkerRepo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class MongoMigration implements CommandLineRunner {

    @Value("${mongo.migration}")
    private String migrationFilePath;

    private final MarkerRepo markerRepo;

    public MongoMigration( MarkerRepo markerRepo) {
        this.markerRepo = markerRepo;
    }


    @Override
    public void run(String... args) {
        ObjectMapper objectMapper = new ObjectMapper();
        mapMigration(objectMapper);
    }



    private void mapMigration(ObjectMapper objectMapper) {
        List<MarkerEntity> mapEntities;
        try {
            mapEntities = objectMapper.readValue(new File(migrationFilePath), new TypeReference<>() {
            });
            Flux.fromIterable(mapEntities).flatMap(testQuestionEntity ->
                            markerRepo.findByAddressAndName(testQuestionEntity.getAddress(), testQuestionEntity.getName())
                                    .map(testQuestionEntity1 -> testQuestionEntity1).switchIfEmpty(markerRepo.save(testQuestionEntity)))
                    .subscribe();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
