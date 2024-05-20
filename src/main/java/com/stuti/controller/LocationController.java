package com.stuti.controller;

import com.stuti.model.Location;
//import com.stuti.service.KafkaConsumerService;
//import com.stuti.service.KafkaProducerService;
import com.stuti.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bms/location")
public class LocationController {

    private final LocationService locationService;
//    private final KafkaProducerService kafkaProducerService;
//    private final KafkaConsumerService kafkaConsumerService;

//    @Autowired
//    public LocationController(LocationService locationService, KafkaProducerService kafkaProducerService, KafkaConsumerService kafkaConsumerService) {
//        this.locationService = locationService;
//        this.kafkaProducerService = kafkaProducerService;
//        this.kafkaConsumerService = kafkaConsumerService;
//    }
    @Autowired
        public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping("/create")
    public ResponseEntity<Location> createLocation(@RequestBody Location location){
        locationService.createLocation(location);
        //kafkaProducerService.sendMessage("guru",location.getCity());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/getAll")
    public ResponseEntity<Location> getAllLocations(){
    List<Location> location = locationService.getLocations() ;
    List<Object> allCity = new ArrayList<>();
        allCity.addAll(location);
        //allCity.addAll(kafkaConsumerService.messageList);
    return (ResponseEntity) ResponseEntity.ok(allCity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable Long id ){
        Location location = locationService.getLocationById(id);
        return ResponseEntity.ok().body(location);
    }
}
