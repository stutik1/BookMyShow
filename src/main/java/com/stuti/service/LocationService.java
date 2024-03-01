package com.stuti.service;

import com.stuti.Location;
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

    public Location createLocation(Location location) {
        locationRepository.createLocation(location);
        return location;
    }

    public List<Location> getLocations() {
        return locationRepository.findAllLocations();
    }


    public Location getLocationById(Long id) {
        return locationRepository.findLocationsById(id);
    }
}
