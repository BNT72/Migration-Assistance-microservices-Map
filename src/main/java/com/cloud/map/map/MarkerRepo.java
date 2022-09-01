package com.cloud.map.map;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface MarkerRepo extends ReactiveMongoRepository<MarkerEntity, String> {

    Flux<MarkerEntity> findAllByMarkerType(EMarkerType type);

    Mono<MarkerEntity> findByAddressAndName(String name, String address);
}
