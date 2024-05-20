package com.stuti.service;

import com.stuti.model.Theatres;
import com.stuti.repository.TheatresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TheatresService {

    private final TheatresRepository theatresRepository;

    @Autowired
    public TheatresService(TheatresRepository theatresRepository) {
        this.theatresRepository = theatresRepository;
    }

    public List<Theatres> findTheatersByLocation(Long id) {
        return theatresRepository.findByLocation(id);
    }

    public List<Theatres> getAllTheaters() {
        return theatresRepository.findAll();
    }
}
