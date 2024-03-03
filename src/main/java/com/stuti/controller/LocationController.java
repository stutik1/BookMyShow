package com.stuti.controller;

import com.stuti.Location;
import com.stuti.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bms/location")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping("/create")
    public ResponseEntity<Location> createLocation(@RequestBody Location location){
        locationService.createLocation(location);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/getAll")
    public ResponseEntity<Location> getAllLocations(){
    List<Location> location = locationService.getLocations() ;
        return (ResponseEntity) ResponseEntity.ok(location);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable Long id ){
        Location location = locationService.getLocationById(id);
        return ResponseEntity.ok().body(location);
    }
}
