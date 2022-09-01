package com.cloud.map.map;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class MapController {

    private final MapService mapService;

    public MapController(MapService mapService) {
        this.mapService = mapService;
    }

    @PostMapping("/")
    public Flux<MarkerDto> getMarkers(@RequestBody Map<String,String> markerType) {
        return mapService.getMarkers(markerType.get("markerType"));
    }
}

