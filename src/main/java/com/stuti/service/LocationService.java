package com.stuti.service;

import com.stuti.Locations;
import com.stuti.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Locations> getLocations() {
        return locationRepository.findAllLocations();
    }


    public Locations getLocationById(Long id) {
        return locationRepository.findLocationsById(id);
    }
}
