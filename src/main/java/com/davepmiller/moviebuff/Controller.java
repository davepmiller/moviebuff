package com.davepmiller.moviebuff;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    private Service service;

    @Autowired
    Controller(Service service) {
        this.service = service;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/movie-genres")
    public String[] getGenres() {
        return service.getGenres();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/movies")
    public List<Movie> getMovies() {
        return service.getMovies();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/movies/{id}")
    public Movie getMovie(@RequestBody Long id) {
        return service.getMovie(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/api/movies")
    public Movie create(@RequestBody Movie movie) {
        if (this.service.createMovie(movie)) {
            return movie;
        }

        return movie;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/api/movies/{id}")
    public void delete(@PathVariable Long id) {
        if (this.service.deleteMovie(id)) {

        } else {

        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/api/movies/{id}")
    public Movie update(@RequestBody Movie movie) {
        if (service.updateMovie(movie)) {
            return movie;
        }

        return movie;
    }
}