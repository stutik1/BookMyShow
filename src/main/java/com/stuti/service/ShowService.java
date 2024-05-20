package com.stuti.service;

import com.stuti.model.Shows;
import com.stuti.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShowService {

    private final ShowRepository showRepository;

    @Autowired
    public ShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }


    public List<Shows> findShowsByMovie(Long movieId) {
        return showRepository.findShowsByMovie(movieId);
    }

    public List<Shows> getShowsByMovieIdAndCity(Long movieId, String city) {
        return showRepository.findShowsByMovieAndLocation(movieId,city);
    }
}
