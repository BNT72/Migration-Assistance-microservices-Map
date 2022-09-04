package com.cloud.map.service;

import com.cloud.map.dto.MarkerDto;
import com.cloud.map.repo.MarkerRepo;
import com.cloud.map.model.EMarkerType;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.Optional;

@Component
public class MapService {
    private final MarkerRepo markerRepo;

    public MapService(MarkerRepo markerRepo) {
        this.markerRepo = markerRepo;
    }

    public Flux<MarkerDto> getMarkers(String markerType) {

        Optional<EMarkerType> type = Optional.of(EMarkerType.valueOf(markerType));
        return markerRepo
                .findAllByMarkerType(type.orElseThrow(IllegalArgumentException::new))
                .map(MarkerDto::new);


    }
}
