package com.stuti.controller;

import com.stuti.Locations;
import com.stuti.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bms/location")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/getAll")
    public List<Locations> getAllLocations(Locations location){
        return locationService.getLocations() ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Locations> getLocationById(@PathVariable Long id ){
        Locations location = locationService.getLocationById(id);
        return ResponseEntity.ok().body(location);
    }
}
